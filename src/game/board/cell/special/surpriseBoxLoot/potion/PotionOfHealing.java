package game.board.cell.special.surpriseBoxLoot.potion;

import game.board.cell.special.surpriseBoxLoot.Potion;

public class PotionOfHealing extends Potion {

    public PotionOfHealing() {
        this.healthBonus = 2;
        this.potionType = "Potion";
        this.emoji = Character.toString(0x1F37A);
    }
}
