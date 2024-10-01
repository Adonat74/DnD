package game.board.cell.special.surpriseBoxLoot.equipment.offensive.weapons;

import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Weapon;

public class Mace extends Weapon {
    public Mace() {
        this.type = "Mace";
        this.attackLevel = 3;
        this.emoji = Character.toString(0x1F528);
    }
}
