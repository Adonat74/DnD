package game;

import character.PlayerCharacter;
import character.types.Mage;
import character.types.Warrior;
import db.DB;
import game.board.Board;
import exceptions.CharacterOutOfBoardException;
import util.DieRoll;
import game.playerInteraction.PlayerEncounterInteractions;
import util.GetValidInputChoice;
import util.Pause;

import java.sql.SQLException;
import java.util.Scanner;


public class Game {
    private int firstCharacter;
    private final Board board;
    private int turn;
    private boolean gameOver = false;

    GetValidInputChoice getValidInputChoice = new GetValidInputChoice();

    String dieEmoji = Character.toString(0x1F3B2);


    private final PlayerEncounterInteractions playerEncounterInteractions;


    public Game() throws SQLException {
        playerEncounterInteractions = new PlayerEncounterInteractions(this);
        this.firstCharacter = 0;
        this.turn = 1;
        board = new Board();
    }

    public void testPlayTurn(PlayerCharacter playerCharacter, DB db) throws InterruptedException, SQLException {
        playerEncounterInteractions.manageInteractions(board, firstCharacter, playerCharacter, db);
    }

    public void testPlay(PlayerCharacter playerCharacter, DB db) throws InterruptedException, CharacterOutOfBoardException, SQLException {

        //        permet de remettre à 0 les stats du joueur lors d'une nouvelle partie
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

        System.out.println(playerCharacter.getName() + " is on square nb " + (firstCharacter));
        System.out.println("Press enter to throw die" + dieEmoji);
        scan.nextLine();
        int dieRoll = new DieRoll(6).getDie();
        this.firstCharacter += dieRoll;
        System.out.println("Die result : " + dieRoll + dieEmoji);

        //      while player not on 64th square continue
        while (firstCharacter < board.getBoard().size() && !gameOver) {

            System.out.println("Turn number : " + turn);
            System.out.println(playerCharacter.getName() + " is on square nb " + (firstCharacter));
            testPlayTurn(playerCharacter, db);
            if (!gameOver) {
                System.out.println("Press enter to throw die" + dieEmoji);
                scan.nextLine();
                dieRoll = new DieRoll(6).getDie();
                this.firstCharacter += dieRoll;
                System.out.println("Die result : " + dieRoll + dieEmoji);
                Pause.pause(500);

                turn++;
            }
            if (firstCharacter >= 64) {
                throw new CharacterOutOfBoardException();
            }
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

    public Board getBoard() {
        return board;
    }


}
