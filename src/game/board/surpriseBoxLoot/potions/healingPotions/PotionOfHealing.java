package game.board.surpriseBoxLoot.potions.healingPotions;

import game.board.surpriseBoxLoot.potions.Potion;

public class PotionOfHealing extends Potion {

    public PotionOfHealing() {
        this.healthBonus = 2;
        this.potionType = "Potion";
        this.emoji = Character.toString(0x1F37A);
    }
}
