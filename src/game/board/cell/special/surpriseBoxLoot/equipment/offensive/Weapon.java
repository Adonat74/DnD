package game.board.cell.special.surpriseBoxLoot.equipment.offensive;

import game.board.cell.special.surpriseBoxLoot.equipment.OffensiveEquipment;

public class Weapon extends OffensiveEquipment {
    public Weapon(String name) {
        super(name);
        this.type = "weapon";
        this.attackLevel = 5;
    }
}
