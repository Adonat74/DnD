package game.board.cell.special.surpriseBoxLoot;

import game.board.cell.Cell;

public class Potion implements Cell {
    protected int healthBonus;
    protected String potionType;
    protected String emoji;

    public Potion() {
    }
    public int getHealthBonus() {
        return healthBonus;
    }
    public String getPotionType() {
        return potionType;
    }

    public String getEmoji() {
        return emoji;
    }
}
