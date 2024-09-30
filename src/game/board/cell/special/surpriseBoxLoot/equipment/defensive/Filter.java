package game.board.cell.special.surpriseBoxLoot.equipment.defensive;

import game.board.cell.special.surpriseBoxLoot.equipment.DefensiveEquipment;

public class Filter extends DefensiveEquipment {
    public Filter(String name) {
        super(name);
        this.type = "filter";
        this.defenseLevel = 6;
    }
}
