package game;

import character.Character;
import character.types.Mage;
import character.types.Warrior;
import game.cell.special.EmptyCell;
import game.cell.special.Enemy;
import game.cell.special.surpriseBoxLoot.equipment.offensive.Weapon;
import exception.CharacterOutOfBoardException;
import game.cell.Cell;
import game.cell.special.enemies.Dragon;
import game.cell.special.surpriseBoxLoot.Potion;
import game.dieRoll.DieRoll;
import game.playerInteraction.Fights;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Game {
    private int firstCharacter;
    private final ArrayList<Cell> cellsTable;
    private int turn;

    public Game() {
        this.firstCharacter = 0;
        this.turn = 1;
        this.cellsTable = new ArrayList<Cell>();
        this.cellsTable.add(0, new EmptyCell());
        this.cellsTable.add(1, new Dragon());
        this.cellsTable.add(2, new Weapon("sword"));
        this.cellsTable.add(3, new Potion());
    }

    public void playTurn () {
        int dieRoll = new DieRoll(6).getDie();
        this.firstCharacter+=dieRoll;
    }

    private void pause() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
    }

    public void testPlayTurn (Character character) throws InterruptedException {

        this.firstCharacter++; // piped die

        int characterAttack = character.getAttack();
        int characterHealth = character.getHealth();

        if (cellsTable.get(firstCharacter) instanceof Enemy) {
        // gère les cases comprenant un ennemi

            Fights fight = new Fights();
            fight.fight(character, firstCharacter, characterAttack, characterHealth,  cellsTable);

        } else if (cellsTable.get(firstCharacter) instanceof Potion) {
        // gère les cases comprenant une potion
            int bonusHealth = new Potion().getHealthBonus();
            character.setHealth(bonusHealth);
            System.out.println("potion");
            System.out.println("your health increases : " + characterHealth + " > " + character.getHealth());


        } else if (cellsTable.get(firstCharacter) instanceof EmptyCell) {
            System.out.println("empty cell, next turn");
        } else if (cellsTable.get(firstCharacter) instanceof Weapon) {
        // gère les cases comprenant une arme
            int bonusAttack = new Weapon("sword").getOffensiveEquipmentAttackLevel();
            character.setAttack(bonusAttack);
            System.out.println("weapon");
            System.out.println("your attack increases : " + characterAttack + " > " + character.getAttack());
        }
    }

    public void testPlay(Character character) throws InterruptedException, CharacterOutOfBoardException {
//        permet de remmettre à 0 les stats du joueur lors d'une nouvelle partie
        if (character.getType().equals("warrior")) {
            character = new Warrior(character.getName());
        } else {
            character = new Mage(character.getName());
        }

        Scanner scan = new Scanner(System.in);
//        reset the player pos and the turn number each new game
        this.firstCharacter = 0;
        this.turn = 1;
        System.out.println("turn number : " + turn);
        System.out.println(character.getName() + " is on square nb" + (firstCharacter));

//      while player not on 64th square continue
        while(firstCharacter<3){
            System.out.println("press enter to throw die");
            scan.nextLine();
            testPlayTurn(character);

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
