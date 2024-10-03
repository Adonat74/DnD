package game.board.surpriseBoxLoot.equipment.offensive.spells;

import game.board.enemy.Enemy;
import game.board.enemy.enemies.Dragon;
import game.board.surpriseBoxLoot.equipment.offensive.Spell;

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
}
