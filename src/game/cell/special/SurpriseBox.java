package game.cell.special;

import game.cell.Cell;
import game.cell.special.surpriseBoxLoot.Potion;
import game.cell.special.surpriseBoxLoot.equipment.OffensiveEquipment;
import game.cell.special.surpriseBoxLoot.equipment.offensive.Spell;
import game.cell.special.surpriseBoxLoot.equipment.offensive.Weapon;

import java.util.Random;

public class SurpriseBox implements Cell {
    private Cell loot;

    public SurpriseBox() {
        int Rand = (int)(Math.random() * 3);
        if (Rand == 0) {
            loot = new Weapon("sword");
        } else if (Rand == 1) {
            loot = new Spell("fire ball");
        } else if (Rand == 2) {
            loot = new Potion();
        }
    }

    public Cell getLoot() {
        return loot;
    }
}
