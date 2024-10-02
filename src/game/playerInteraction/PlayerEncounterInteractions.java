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


    private final Board board;
    private final Game game;

    public PlayerEncounterInteractions(Game game) {
        this.game = game;
        this.board = game.getBoard();
    }

    public void manageInteractions(Board board, int firstCharacter, PlayerCharacter playerCharacter, DB db) throws SQLException, InterruptedException {

        int characterAttack = playerCharacter.getAttack();
        int characterHealth = playerCharacter.getHealth();
        String characterType = playerCharacter.getType();

//      déclaration du type générique de l'entitée Cell
        Cell<?> cell = board.getBoard().get(firstCharacter);

//      Verify the type of the cell attribute entity
        if (cell.getEntity() instanceof Enemy) {
            // gère les cases comprenant un ennemi
            Fights fight = new Fights(game);
            fight.fight(playerCharacter, characterAttack, characterHealth, db, cell);


        } else if (cell.getEntity() instanceof Potion) {
            // gère les cases comprenant une potion
            int bonusHealth = ((Potion) cell.getEntity()).getHealthBonus();
            playerCharacter.setHealth(bonusHealth);
            System.out.println(((Potion) cell.getEntity()).getPotionType() + ((Potion) cell.getEntity()).getEmoji());
            System.out.println("your health increases : " + characterHealth + " > " + playerCharacter.getHealth() + upArrowEmoji);
            db.changeHealthPoints(playerCharacter);


        } else if (cell.getEntity() instanceof EmptyCell) {
            System.out.println("empty cell");


        } else if (cell.getEntity() instanceof OffensiveEquipment ) {
            if (cell.getEntity() instanceof Weapon && characterType.equals("warrior")) {
                //            if you are a warrior, and it's a weapon you can equip the gear
                int bonusAttack = ((Weapon) cell.getEntity()).getOffensiveEquipmentAttackLevel();
                playerCharacter.setAttack(bonusAttack);
                System.out.println(((Weapon) cell.getEntity()).getOffensiveEquipmentType() + ((Weapon) cell.getEntity()).getEmoji());
                System.out.println("your attack increases : " + characterAttack + " > " + playerCharacter.getAttack() + upArrowEmoji);
            } else if (cell.getEntity() instanceof Spell && characterType.equals("mage")) {
                //            if you are a mage, and it's a spell you can equip the gear
                int bonusAttack = ((Spell) cell.getEntity()).getOffensiveEquipmentAttackLevel();
                playerCharacter.setAttack(bonusAttack);
                System.out.println(((Spell) cell.getEntity()).getOffensiveEquipmentType() + ((Spell) cell.getEntity()).getEmoji());
                System.out.println("your attack increases : " + characterAttack + " > " + playerCharacter.getAttack() + upArrowEmoji);
            } else {
                //            else you can't equip the gear
                System.out.println(((OffensiveEquipment) cell.getEntity()).getOffensiveEquipmentType() + ((OffensiveEquipment) cell.getEntity()).getEmoji());
                System.out.println("You are a " + playerCharacter.getType() + ", you can't equip this gear !" + crossEmoji);
            }
        }
    }
}
