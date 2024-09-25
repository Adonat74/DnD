package game;

import character.Character;
import exception.CharacterOutOfBoardException;
import game.cell.Cell;
import game.cell.special.enemies.Dragon;
import game.dieRoll.DieRoll;

import java.util.concurrent.TimeUnit;


public class Game {
    private int firstCharacter;
    private Cell[] cellsTable;
    private int dieRoll;
    private int turn;

    public Game() {
        this.firstCharacter = 1;
        this.turn = 1;
        this.cellsTable = new Cell[4];
        cellsTable[0] = new Dragon();
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
            dieRoll = new DieRoll().getDie();
            firstCharacter+=dieRoll;
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
