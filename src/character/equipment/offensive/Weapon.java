package character.equipment.offensive;

import character.equipment.OffensiveEquipment;

public class Weapon extends OffensiveEquipment {
    public Weapon(String name) {
        super(name);
        this.type = "weapon";
        this.attackLevel = 10;
    }
}
