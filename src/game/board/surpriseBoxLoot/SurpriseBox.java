package game.board.surpriseBoxLoot;

import game.board.surpriseBoxLoot.equipment.offensive.spells.FireBall;
import game.board.surpriseBoxLoot.equipment.offensive.spells.Invisibility;
import game.board.surpriseBoxLoot.equipment.offensive.spells.Thunderbolt;
import game.board.surpriseBoxLoot.equipment.offensive.weapons.Bow;
import game.board.surpriseBoxLoot.equipment.offensive.weapons.Mace;
import game.board.surpriseBoxLoot.equipment.offensive.weapons.Sword;
import game.board.surpriseBoxLoot.potions.attributePotions.ThunderclapPotion;
import game.board.surpriseBoxLoot.potions.healingPotions.GreaterPotionOfHealing;
import game.board.surpriseBoxLoot.potions.healingPotions.PotionOfHealing;

public class SurpriseBox {
    private Object loot;

    public SurpriseBox() {
        int Rand = (int)(Math.random() * 9);

        if (Rand == 0) {
            loot = new Sword();
        } else if (Rand == 1) {
            loot = new Mace();
        } else if (Rand == 2) {
            loot = new FireBall();
        } else if (Rand == 3) {
            loot = new Thunderbolt();
        } else if (Rand == 4) {
            loot = new GreaterPotionOfHealing();
        } else if (Rand == 5) {
            loot = new PotionOfHealing();
        } else if (Rand == 6) {
            loot = new Bow();
        } else if (Rand == 7) {
            loot = new Invisibility();
        } else if (Rand == 8) {
            loot = new ThunderclapPotion();
        }
    }

    public Object getLoot() {
        return loot;
    }
}
