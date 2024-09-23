package character.equipment.defensive;

import character.equipment.DefensiveEquipment;

public class Filter extends DefensiveEquipment {
    public Filter(String name) {
        super(name);
        this.type = "filter";
        this.defenseLevel = 6;
    }
}
