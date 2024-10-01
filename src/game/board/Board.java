package game.board;

import game.board.cell.Cell;
import game.board.cell.special.EmptyCell;
import game.board.cell.special.enemies.Dragon;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.weapons.Mace;
import game.board.cell.special.surpriseBoxLoot.potion.GreaterPotionOfHealing;

import java.util.ArrayList;

public class Board {
    private ArrayList<Cell> board;

    public Board() {
        resetBoard();
    }

    public void resetBoard() {
        this.board = new ArrayList<>(4);
        this.board.add(0, new EmptyCell());
        this.board.add(1, new Dragon());
        this.board.add(2, new Mace());
        this.board.add(3, new GreaterPotionOfHealing());
    }

//    GETTERS
    public ArrayList<Cell> getBoard () {
        return this.board;
    }
}
