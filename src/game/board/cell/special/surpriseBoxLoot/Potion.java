package game.board.cell.special.surpriseBoxLoot;

import game.board.cell.Cell;

public class Potion implements Cell {
    protected int healthBonus;

    public Potion() {
    }
    public int getHealthBonus() {
        return healthBonus;
    }
}
