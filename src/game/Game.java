package game;

import character.PlayerCharacter;
import character.types.Mage;
import character.types.Warrior;
import db.DB;
import game.board.Board;
import exception.CharacterOutOfBoardException;
import game.dieRoll.DieRoll;
import game.playerInteraction.PlayerEncounterInteractions;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Game {
    private int firstCharacter;
    private final Board board;
    private int turn;
    private boolean gameOver = false;

    private final PlayerEncounterInteractions playerEncounterInteractions;


    public Game() throws SQLException {
        playerEncounterInteractions = new PlayerEncounterInteractions(this);
        this.firstCharacter = 0;
        this.turn = 1;
        board = new Board();
    }

    public void playTurn () {
        int dieRoll = new DieRoll(6).getDie();
        this.firstCharacter+=dieRoll;
    }

    public void testPlayTurn (PlayerCharacter playerCharacter, DB db) throws InterruptedException, SQLException {
        playerEncounterInteractions.manageInteractions(board, firstCharacter, playerCharacter, db);
    }

    public void testPlay(PlayerCharacter playerCharacter, DB db) throws InterruptedException, CharacterOutOfBoardException, SQLException {

    //        permet de remmettre à 0 les stats du joueur lors d'une nouvelle partie
        if (playerCharacter.getType().equals("warrior")) {
            playerCharacter = new Warrior(playerCharacter.getName());
        } else {
            playerCharacter = new Mage(playerCharacter.getName());
        }
        board.resetBoard();

        Scanner scan = new Scanner(System.in);
    //        reset the player pos and the turn number each new game
        this.firstCharacter = 0;
        this.turn = 1;


    //      while player not on 64th square continue
        while(firstCharacter < board.getBoard().size() && !gameOver){



            System.out.println("turn number : " + turn);
            System.out.println(playerCharacter.getName() + " is on square nb" + (firstCharacter));
            testPlayTurn(playerCharacter, db);
            if (!gameOver) {
                System.out.println("press enter to throw die");
                scan.nextLine();

                firstCharacter++;
                turn++;
            }
    //            if (firstCharacter >64) {
    //                throw new CharacterOutOfBoardException();
    //            }
        }
    }


// GETTERS
    public int getFirstCharacter() {
        return firstCharacter;
    }
//SETTERS
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setFirstCharacter(int firstCharacter) {
        this.firstCharacter = firstCharacter;
    }

















//////////////////////////////////////////////////////////////////////////////





    public void play(PlayerCharacter playerCharacter) throws InterruptedException, CharacterOutOfBoardException {
    //        reset the player pos and the turn number each new game
        this.firstCharacter = 1;
        this.turn = 1;
        System.out.println("turn number : " + turn);
        System.out.println(playerCharacter.getName() + " is on square nb" + firstCharacter);

    //      while player not on 64th square continue
        while(firstCharacter<64){

    //          instance of a diceRoll that return a random number between 1 and 6.
            int dieRoll = new DieRoll(6).getDie();
            firstCharacter+= dieRoll;
            turn++;
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("turn number : " + turn);
            System.out.println(playerCharacter.getName() + " is on square nb" + firstCharacter);
    //            if player is on square 64 or more after a die roll place the player on the 64th square.
            if (firstCharacter >64) {
                throw new CharacterOutOfBoardException();
            }
        }
    }
}
