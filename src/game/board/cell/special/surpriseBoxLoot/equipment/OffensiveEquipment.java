package game.board.cell.special.surpriseBoxLoot.equipment;

import game.board.cell.Cell;

public abstract class OffensiveEquipment implements Cell {
    protected String type;
    protected int attackLevel;


    public OffensiveEquipment() {
    }

//  GETTERS
    public String getOffensiveEquipmentType() {
        return type;
    }
    public int getOffensiveEquipmentAttackLevel() {
        return attackLevel;
    }

}
