package game.board.cell.special.surpriseBoxLoot;

import game.board.cell.Cell;

public class Potion implements Cell {
    private final int healthBonus;

    public Potion() {
        int rand = (int)(Math.random() * 2);
        if (rand == 0) {
            healthBonus = 2;
        } else {
            healthBonus = 5;
        }
    }
    public int getHealthBonus() {
        return healthBonus;
    }
}
