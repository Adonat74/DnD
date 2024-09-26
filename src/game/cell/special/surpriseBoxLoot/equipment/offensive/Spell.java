package game.cell.special.surpriseBoxLoot.equipment.offensive;

import game.cell.special.surpriseBoxLoot.equipment.OffensiveEquipment;

public class Spell extends OffensiveEquipment {
    public Spell(String name) {
        super(name);
        this.type = "spell";
        this.attackLevel = 15;
    }
}
