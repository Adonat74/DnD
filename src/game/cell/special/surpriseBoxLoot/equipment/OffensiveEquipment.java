package game.cell.special.surpriseBoxLoot.equipment;

import game.cell.Cell;

public abstract class OffensiveEquipment implements Cell {
    protected String type;
    protected int attackLevel;
    protected String name;


    public OffensiveEquipment(String name) {
        this.name = name;
    }

//  GETTERS
    public String getOffensiveEquipmentType() {
        return type;
    }
    public int getOffensiveEquipmentAttackLevel() {
        return attackLevel;
    }
    public String getOffensiveEquipmentName() {
        return name;
    }

}
