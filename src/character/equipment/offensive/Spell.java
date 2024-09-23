package character.equipment.offensive;

import character.equipment.OffensiveEquipment;

public class Spell extends OffensiveEquipment {
    public Spell(String name) {
        super(name);
        this.type = "spell";
        this.attackLevel = 15;
    }
}
