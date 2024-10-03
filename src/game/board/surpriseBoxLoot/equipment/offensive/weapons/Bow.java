package game.board.surpriseBoxLoot.equipment.offensive.weapons;

import game.board.enemy.Enemy;
import game.board.enemy.enemies.Dragon;
import game.board.enemy.enemies.Ghost;
import game.board.surpriseBoxLoot.equipment.offensive.Weapon;
import game.board.surpriseBoxLoot.equipment.offensive.spells.Invisibility;

public class Bow extends Weapon {

    public Bow() {
        this.type = "Bow";
        this.attackLevel = 4;
        this.emoji = Character.toString(0x1F3F9);
    }

    @Override
    public void isAgainstSpecialEnemy(Enemy enemy) {
        if (enemy instanceof Dragon) {
            this.bonusDamage=2;
            System.out.println("It's a dragon your Bow makes more damage!");
        } else {
            bonusDamage=0;
        }
    }
}
