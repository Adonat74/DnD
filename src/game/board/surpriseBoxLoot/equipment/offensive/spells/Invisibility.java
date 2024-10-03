package game.board.surpriseBoxLoot.equipment.offensive.spells;

import game.board.enemy.Enemy;
import game.board.enemy.enemies.Dragon;
import game.board.enemy.enemies.Ghost;
import game.board.surpriseBoxLoot.equipment.offensive.Spell;
import game.board.surpriseBoxLoot.equipment.offensive.weapons.Bow;

public class Invisibility extends Spell {

    public Invisibility() {
        this.type = "Invisibility";
        this.attackLevel = 5;
        this.emoji = Character.toString(0x1F32B);
    }

    public void isAgainstGhost(Enemy enemy) {
        if (enemy instanceof Dragon) {
            this.attackLevel+=3;
        } else {
            this.attackLevel-=3;
        }
    }
    @Override
    public void isAgainstSpecialEnemy(Enemy enemy) {
        if (enemy instanceof Ghost){
            this.bonusDamage=3;
            System.out.println("It's a Ghost your Invisibility makes more damage!");
        } else {
            bonusDamage=0;
        }
    }
}
