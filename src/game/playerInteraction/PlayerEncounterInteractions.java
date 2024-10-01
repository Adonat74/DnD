package game.playerInteraction;

import character.PlayerCharacter;
import db.DB;
import game.Game;
import game.board.Board;
import game.board.cell.Cell;
import game.board.cell.special.EmptyCell;
import game.board.cell.special.Enemy;
import game.board.cell.special.surpriseBoxLoot.Potion;
import game.board.cell.special.surpriseBoxLoot.equipment.OffensiveEquipment;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Spell;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Weapon;

import java.sql.SQLException;

public class PlayerEncounterInteractions {
    String upArrowEmoji = Character.toString(0x1F51D);
    String crossEmoji = Character.toString(0x274C);

    private final Game game;

    public PlayerEncounterInteractions(Game game) {
        this.game = game;
    }

    public void manageInteractions(Board board, int firstCharacter, PlayerCharacter playerCharacter, DB db) throws SQLException, InterruptedException {

        int characterAttack = playerCharacter.getAttack();
        int characterHealth = playerCharacter.getHealth();
        String characterType = playerCharacter.getType();

        Cell cell = board.getBoard().get(firstCharacter);


        if (cell instanceof Enemy) {
            // gère les cases comprenant un ennemi
            Fights fight = new Fights(game);
            fight.fight(playerCharacter, characterAttack, characterHealth, board.getBoard(), db);


        } else if (cell instanceof Potion) {
            // gère les cases comprenant une potion
            int bonusHealth = ((Potion) cell).getHealthBonus();
            playerCharacter.setHealth(bonusHealth);
            System.out.println(((Potion) cell).getPotionType() + ((Potion) cell).getEmoji());
            System.out.println("your health increases : " + characterHealth + " > " + playerCharacter.getHealth() + upArrowEmoji);
            db.changeHealthPoints(playerCharacter);


        } else if (cell instanceof EmptyCell) {
            System.out.println("empty cell");


        } else if (cell instanceof OffensiveEquipment ) {
            if (cell instanceof Weapon && characterType.equals("warrior")) {
                //            if you are a warrior and it's a weapon you can equip the gear
                int bonusAttack = ((Weapon) cell).getOffensiveEquipmentAttackLevel();
                playerCharacter.setAttack(bonusAttack);
                System.out.println(((Weapon) cell).getOffensiveEquipmentType() + ((Weapon) cell).getEmoji());
                System.out.println("your attack increases : " + characterAttack + " > " + playerCharacter.getAttack() + upArrowEmoji);
            } else if (cell instanceof Spell && characterType.equals("mage")) {
                //            if you are a mage and it's a spell you can equip the gear
                int bonusAttack = ((Spell) cell).getOffensiveEquipmentAttackLevel();
                playerCharacter.setAttack(bonusAttack);
                System.out.println(((Spell) cell).getOffensiveEquipmentType() + ((Spell) cell).getEmoji());
                System.out.println("your attack increases : " + characterAttack + " > " + playerCharacter.getAttack() + upArrowEmoji);
            } else {
                //            else you can't equip the gear
                System.out.println(((OffensiveEquipment) cell).getOffensiveEquipmentType() + ((OffensiveEquipment) cell).getEmoji());
                System.out.println("You are a " + playerCharacter.getType() + ", you can't equip this gear !" + crossEmoji);
            }
        }
    }
}
