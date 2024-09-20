package game;

import character.Character;

import java.util.concurrent.TimeUnit;


public class Game {
    private int firstCharacter;
    private int[] table;
    private int diceRoll;
    private int turn;

    public Game() {
        this.firstCharacter = 1;
        this.table = new int[64];
        this.table[0] = 1;
        this.turn = 1;
    }

    public void play(Character character) throws InterruptedException {

        while (firstCharacter<64) {
            System.out.println("turn number : " + turn);
            System.out.println(character.getName() + "is on square nb" + firstCharacter);
            diceRoll = new DiceRoll().getDice();
            firstCharacter+=diceRoll;

            turn++;
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println();
    }
}
