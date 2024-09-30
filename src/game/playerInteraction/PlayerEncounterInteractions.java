package game.playerInteraction;

import character.PlayerCharacter;
import db.DB;
import game.Game;
import game.board.Board;
import game.board.cell.special.EmptyCell;
import game.board.cell.special.Enemy;
import game.board.cell.special.surpriseBoxLoot.Potion;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Weapon;

import java.sql.SQLException;

public class PlayerEncounterInteractions {
    private final Game game;

    public PlayerEncounterInteractions(Game game) {
        this.game = game;
    }

    public void manageInteractions(Board board, int firstCharacter, PlayerCharacter playerCharacter, DB db) throws SQLException, InterruptedException {

        int characterAttack = playerCharacter.getAttack();
        int characterHealth = playerCharacter.getHealth();


        if (board.getBoard().get(firstCharacter) instanceof Enemy) {
            // gère les cases comprenant un ennemi

            Fights fight = new Fights(game);
            fight.fight(playerCharacter, characterAttack, characterHealth, board.getBoard(), db);


        } else if (board.getBoard().get(firstCharacter) instanceof Potion) {


            // gère les cases comprenant une potion
            int bonusHealth = new Potion().getHealthBonus();
            playerCharacter.setHealth(bonusHealth);
            System.out.println("potion");
            System.out.println("your health increases : " + characterHealth + " > " + playerCharacter.getHealth());
            db.changeHealthPoints(playerCharacter);

        } else if (board.getBoard().get(firstCharacter) instanceof EmptyCell) {

            System.out.println("empty cell");

        } else if (board.getBoard().get(firstCharacter) instanceof Weapon) {

            // gère les cases comprenant une arme
            int bonusAttack = new Weapon().getOffensiveEquipmentAttackLevel();
            playerCharacter.setAttack(bonusAttack);
            System.out.println("weapon");
            System.out.println("your attack increases : " + characterAttack + " > " + playerCharacter.getAttack());
        }
    }
}
