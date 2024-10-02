package game.board.cell.special;

import game.board.cell.special.surpriseBoxLoot.equipment.offensive.spells.FireBall;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.spells.Thunderbolt;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.weapons.Mace;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.weapons.Sword;
import game.board.cell.special.surpriseBoxLoot.potion.GreaterPotionOfHealing;
import game.board.cell.special.surpriseBoxLoot.potion.PotionOfHealing;

public class SurpriseBox {
    private Object loot;

    public SurpriseBox() {
        int Rand = (int)(Math.random() * 6);

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
        }
    }

    public Object getLoot() {
        return loot;
    }
}
