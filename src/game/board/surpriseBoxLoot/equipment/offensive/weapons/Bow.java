package game.board.surpriseBoxLoot.equipment.offensive.weapons;

import game.board.enemy.Enemy;
import game.board.enemy.enemies.Dragon;
import game.board.surpriseBoxLoot.equipment.offensive.Weapon;

public class Bow extends Weapon {

    public Bow() {
        this.type = "Bow";
        this.attackLevel = 4;
        this.emoji = Character.toString(0x1F3F9);
    }

}
