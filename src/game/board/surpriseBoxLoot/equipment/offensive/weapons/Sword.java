package game.board.surpriseBoxLoot.equipment.offensive.weapons;

import game.board.surpriseBoxLoot.equipment.offensive.Weapon;

public class Sword extends Weapon {
    public Sword() {

        this.type = "Sword";
        this.attackLevel = 5;
        this.emoji = Character.toString(0x1F5E1);
    }
}
