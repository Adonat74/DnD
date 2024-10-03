package game.playerInteraction;

import character.PlayerCharacter;
import db.DB;
import game.Game;
import game.board.Board;
import game.board.cell.Cell;
import game.board.cell.special.EmptyCell;
import game.board.enemy.Enemy;
import game.board.enemy.enemies.Ghost;
import game.board.enemy.enemies.Orc;
import game.board.surpriseBoxLoot.potion.Potion;
import game.board.surpriseBoxLoot.equipment.OffensiveEquipment;
import game.board.surpriseBoxLoot.equipment.offensive.Spell;
import game.board.surpriseBoxLoot.equipment.offensive.Weapon;
import util.Pause;

import java.sql.SQLException;
import java.util.Objects;

public class PlayerEncounterInteractions {
    private final Pause pause = new Pause();

    String upArrowEmoji = Character.toString(0x1F51D);
    String crossEmoji = Character.toString(0x274C);

    private final Game game;

    public PlayerEncounterInteractions(Game game) {
        this.game = game;
    }

    public void manageInteractions(Board board, int firstCharacter, PlayerCharacter playerCharacter, DB db) throws SQLException, InterruptedException {

        OffensiveEquipment offensiveEquipment = playerCharacter.getOffensiveEquipment();
        int characterAttack = playerCharacter.getAttack();
        int characterHealth = playerCharacter.getHealth();
        String characterType = playerCharacter.getType();

//      déclaration du type générique de l'entitée Cell
        Cell<?> cell = board.getBoard().get(firstCharacter);

//      Verify the type of the cell attribute entity
        if (cell.getEntity() instanceof Enemy) {
            String enemyType = ((Enemy) cell.getEntity()).getEnemyType();
            // gère les cases comprenant un ennemi

            if (((Enemy) cell.getEntity()).getIsDead()){
                System.out.println(enemyType + " is already dead");
            } else if (cell.getEntity() instanceof Orc && Objects.equals(characterType, "mage") || cell.getEntity() instanceof Ghost && Objects.equals(characterType, "warrior")) {
                System.out.println("You are a " + characterType + ", " + enemyType + " fear you! ");
                pause.pause(500);
                System.out.println(enemyType + " run away !");
            } else {
                Fights fight = new Fights(game, firstCharacter);
                fight.fight(playerCharacter, characterAttack, characterHealth, db, cell, offensiveEquipment);
            }
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
                int equipmentAttack = ((Weapon) cell.getEntity()).getOffensiveEquipmentAttackLevel();

                playerCharacter.setOffensiveEquipment((Weapon) cell.getEntity());

                System.out.println("A new offensive gear! "+((Weapon) cell.getEntity()).getOffensiveEquipmentType() + ((Weapon) cell.getEntity()).getEmoji() + "  Attack level : " + equipmentAttack);

                System.out.println("You equip this gear : Your attack > " + playerCharacter.getAttack() + " +  Equipment Attack > " + equipmentAttack + upArrowEmoji);


            } else if (cell.getEntity() instanceof Spell && characterType.equals("mage")) {


                //            if you are a mage, and it's a spell you can equip the gear
                int equipmentAttack = ((Spell) cell.getEntity()).getOffensiveEquipmentAttackLevel();

                playerCharacter.setOffensiveEquipment((Spell) cell.getEntity());

                System.out.println("A new offensive gear! "+((Spell) cell.getEntity()).getOffensiveEquipmentType() + ((Spell) cell.getEntity()).getEmoji());

                System.out.println("You equip this gear : " + playerCharacter.getAttack() + " > " + equipmentAttack + upArrowEmoji);




            } else {
                //            else you can't equip the gear
                System.out.println(((OffensiveEquipment) cell.getEntity()).getOffensiveEquipmentType() + ((OffensiveEquipment) cell.getEntity()).getEmoji());
                System.out.println("You are a " + playerCharacter.getType() + ", you can't equip this gear !" + crossEmoji);
            }
        }
    }
}
