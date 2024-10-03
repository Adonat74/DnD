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
import game.board.surpriseBoxLoot.potions.Potion;
import game.board.surpriseBoxLoot.equipment.OffensiveEquipment;
import game.board.surpriseBoxLoot.equipment.offensive.Spell;
import game.board.surpriseBoxLoot.equipment.offensive.Weapon;
import game.playerInteraction.fights.Fights;
import game.playerInteraction.objects.OffensiveGearInteraction;
import game.playerInteraction.objects.PotionsInteraction;
import util.Pause;

import java.sql.SQLException;
import java.util.Objects;

public class PlayerEncounterInteractions {

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
                Pause.pause(500);
                System.out.println(enemyType + " run away !");
            } else {
                Fights fight = new Fights(game, firstCharacter);
                fight.fight(playerCharacter, characterAttack, characterHealth, db, cell, offensiveEquipment);
            }
        } else if (cell.getEntity() instanceof Potion) {

            // gère les cases comprenant une potion
            new PotionsInteraction().potionsInteraction(cell, playerCharacter, db);


        } else if (cell.getEntity() instanceof EmptyCell) {
            System.out.println("empty cell");
        } else if (cell.getEntity() instanceof OffensiveEquipment ) {
            new OffensiveGearInteraction().interact(cell, playerCharacter);
        }
    }
}
