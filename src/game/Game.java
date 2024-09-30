package game;

import character.Character;
import character.types.Mage;
import character.types.Warrior;
import db.DB;
import game.board.Board;
import game.board.cell.special.EmptyCell;
import game.board.cell.special.Enemy;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Weapon;
import exception.CharacterOutOfBoardException;
import game.board.cell.special.surpriseBoxLoot.Potion;
import game.dieRoll.DieRoll;
import game.playerInteraction.Fights;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Game {
    private int firstCharacter;
    private final Board board;
    private int turn;

    public Game() throws SQLException {
        this.firstCharacter = 0;
        this.turn = 1;
        board = new Board();
    }


    public void playTurn () {
        int dieRoll = new DieRoll(6).getDie();
        this.firstCharacter+=dieRoll;
    }

    public void testPlayTurn (Character character, DB db) throws InterruptedException, SQLException {

        // piped die
        firstCharacter++;

        int characterAttack = character.getAttack();
        int characterHealth = character.getHealth();

        if (board.getBoard().get(firstCharacter) instanceof Enemy) {
            // gère les cases comprenant un ennemi
            Fights fight = new Fights();
            fight.fight(character, firstCharacter, characterAttack, characterHealth, board.getBoard(), db);
        } else if (board.getBoard().get(firstCharacter) instanceof Potion) {
            // gère les cases comprenant une potion
            int bonusHealth = new Potion().getHealthBonus();
            character.setHealth(bonusHealth);
            System.out.println("potion");
            System.out.println("your health increases : " + characterHealth + " > " + character.getHealth());
            db.changeHealthPoints(character);
        } else if (board.getBoard().get(firstCharacter) instanceof EmptyCell) {
            System.out.println("empty cell, next turn");
        } else if (board.getBoard().get(firstCharacter) instanceof Weapon) {
            // gère les cases comprenant une arme
            int bonusAttack = new Weapon("sword").getOffensiveEquipmentAttackLevel();
            character.setAttack(bonusAttack);
            System.out.println("weapon");
            System.out.println("your attack increases : " + characterAttack + " > " + character.getAttack());
        }
    }

    public void testPlay(Character character, DB db) throws InterruptedException, CharacterOutOfBoardException, SQLException {

    //        permet de remmettre à 0 les stats du joueur lors d'une nouvelle partie
        if (character.getType().equals("warrior")) {
            character = new Warrior(character.getName());
        } else {
            character = new Mage(character.getName());
        }
        board.resetBoard();

        Scanner scan = new Scanner(System.in);
    //        reset the player pos and the turn number each new game
        this.firstCharacter = 0;
        this.turn = 1;
        System.out.println("turn number : " + turn);
        System.out.println(character.getName() + " is on square nb" + (firstCharacter));

    //      while player not on 64th square continue

        while(firstCharacter < board.getBoard().size()-1){
            System.out.println("press enter to throw die");
            scan.nextLine();
            testPlayTurn(character, db);

            turn++;
            System.out.println("turn number : " + turn);
            System.out.println(character.getName() + " is on square nb" + (firstCharacter));
    //            if (firstCharacter >64) {
    //                throw new CharacterOutOfBoardException();
    //            }
        }
    }






    public void play(Character character) throws InterruptedException, CharacterOutOfBoardException {
    //        reset the player pos and the turn number each new game
        this.firstCharacter = 1;
        this.turn = 1;
        System.out.println("turn number : " + turn);
        System.out.println(character.getName() + " is on square nb" + firstCharacter);

    //      while player not on 64th square continue
        while(firstCharacter<64){

    //          instance of a diceRoll that return a random number between 1 and 6.
            int dieRoll = new DieRoll(6).getDie();
            firstCharacter+= dieRoll;
            turn++;
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("turn number : " + turn);
            System.out.println(character.getName() + " is on square nb" + firstCharacter);
    //            if player is on square 64 or more after a die roll place the player on the 64th square.
            if (firstCharacter >64) {
                throw new CharacterOutOfBoardException();
            }
        }
    }
}
