package game.board;

import game.board.cell.Cell;
import game.board.cell.special.EmptyCell;
import game.board.enemy.Enemy;
import game.board.enemy.enemies.*;
import game.board.surpriseBoxLoot.SurpriseBox;

import java.util.ArrayList;

public class Board {
    private ArrayList<Cell> board;
    private int enemies = 24;
    private int surpriseBox = 24;


    public Board() {
        resetBoard();
    }

    public void resetBoard() {
        this.surpriseBox = 24;
        this.enemies = 24;

        this.board = new ArrayList<>(64);

        // Initialize all cells first
        for (int i = 0; i < 64; i++) {
            this.board.add(new Cell<>());  // Add empty cells first
        }

        while (this.enemies > 0) {
            int rand64 = randNum(64);
            int rand5 = randNum(5);
            if (this.board.get(rand64).getEntity() == null) {
                if (rand5 == 0) {
                    this.board.get(rand64).setEntity(new Dragon());
                } else if (rand5 == 1) {
                    this.board.get(rand64).setEntity(new Goblin());
                } else if (rand5 == 2) {
                    this.board.get(rand64).setEntity(new Wizard());
                } else if (rand5 == 3) {
                    this.board.get(rand64).setEntity(new Orc());
                } else if (rand5 == 4) {
                    this.board.get(rand64).setEntity(new Ghost());
                }
                this.enemies--;
            }
        }
        while (this.surpriseBox > 0) {
            int rand64 = randNum(64);
            if (this.board.get(rand64).getEntity() == null) {
                this.board.get(rand64).setEntity(new SurpriseBox().getLoot());
                this.surpriseBox--;
            }
        }
        for (int i = 0; i < this.board.size(); i++) {
            if (this.board.get(i).getEntity() == null) {
                this.board.get(i).setEntity(new EmptyCell());
            }
        }
    }

    private int randNum(int range) {
        return (int) (Math.random() * range);
    }

//    GETTERS
    public ArrayList<Cell> getBoard () {
        return this.board;
    }

//    SETTERS

    public void setDeadEnemy(int pos) {
//        trouve le bon enemy et toggle si il est mort
        Cell<?> cell = this.board.get(pos);
        ((Enemy) cell.getEntity()).setIsDead(true);
    }
}
