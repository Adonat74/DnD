package game;

import character.Character;
import exception.CharacterOutOfBoardException;

import java.util.concurrent.TimeUnit;


public class Game {
    private int firstCharacter;
    private int[] table;
    private int diceRoll;
    private int turn;

    public Game() {
        this.firstCharacter = 1;
        this.turn = 1;
        this.table = new int[64];
        this.table[0] = 1;
    }

    public void play(Character character) throws InterruptedException, CharacterOutOfBoardException {
//        reset the player pos and the turn number each new game
        this.firstCharacter = 1;
        this.turn = 1;


//      while player not on 64th square continue
        do {
            System.out.println("turn number : " + turn);
            System.out.println(character.getName() + " is on square nb" + firstCharacter);
//          instance of a diceRoll that return a random number between 1 and 6.
            diceRoll = new DiceRoll().getDice();
            firstCharacter+=diceRoll;
            turn++;
            TimeUnit.MILLISECONDS.sleep(300);
//            if player is on square 64 or more after a die roll place the player on the 64th square.
            if(firstCharacter >=64) {
                firstCharacter = 64;
                System.out.println("turn number : " + turn);
                System.out.println(character.getName() + " is on square nb" + firstCharacter);
                throw new CharacterOutOfBoardException();
            }

        } while (firstCharacter<64);

    }
}
