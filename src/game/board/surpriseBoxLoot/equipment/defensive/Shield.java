package game.board.surpriseBoxLoot.equipment.defensive;

import game.board.surpriseBoxLoot.equipment.DefensiveEquipment;

public class Shield extends DefensiveEquipment {
    public Shield(String name) {
        super(name);
        this.type = "shield";
        this.defenseLevel = 10;
    }
}
