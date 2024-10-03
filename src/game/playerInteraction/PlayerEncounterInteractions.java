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
import game.playerInteraction.fights.Fights;
import game.playerInteraction.objects.OffensiveGearInteraction;
import game.playerInteraction.objects.PotionsInteraction;
import util.ConsolePrints;

import java.sql.SQLException;
import java.util.Objects;

public class PlayerEncounterInteractions {

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

                ConsolePrints.printIsDead(enemyType);

            } else if (cell.getEntity() instanceof Orc && Objects.equals(characterType, "mage") || cell.getEntity() instanceof Ghost && Objects.equals(characterType, "warrior")) {
                ConsolePrints.printSpecialEnemyInteraction(characterType, enemyType);
            } else {
                Fights fight = new Fights(game, firstCharacter);
                fight.fight(playerCharacter, characterAttack, characterHealth, db, cell, offensiveEquipment);
            }
        } else if (cell.getEntity() instanceof Potion) {
            // gère les cases comprenant une potion
            PotionsInteraction.interact(cell, playerCharacter, db);
        } else if (cell.getEntity() instanceof EmptyCell) {
            System.out.println("empty cell");
        } else if (cell.getEntity() instanceof OffensiveEquipment ) {
            OffensiveGearInteraction.interact(cell, playerCharacter);
        }
    }
}
