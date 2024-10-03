package game.board.surpriseBoxLoot.potions.healingPotions;

public class GreaterPotionOfHealing extends PotionOfHealing {
    public GreaterPotionOfHealing() {
        this.healthBonus = 5;
        this.potionType = "Greater Potion";
        this.emoji = Character.toString(0x1F37B);
    }
}
