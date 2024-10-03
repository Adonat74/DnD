package game.board.surpriseBoxLoot.potions;

public class Potion {
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
