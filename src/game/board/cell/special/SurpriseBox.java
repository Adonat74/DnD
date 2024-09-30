package game.board.cell.special;

import game.board.cell.Cell;
import game.board.cell.special.surpriseBoxLoot.Potion;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Spell;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Weapon;

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
