package character.equipment.defensive;

import character.equipment.DefensiveEquipment;

public class Shield extends DefensiveEquipment {
    public Shield(String name) {
        super(name);
        this.type = "shield";
        this.defenseLevel = 10;
    }
}
