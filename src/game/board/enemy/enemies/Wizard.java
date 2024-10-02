package game.board.enemy.enemies;

import game.board.enemy.Enemy;

public class Wizard extends Enemy {
    public Wizard() {
        this.health = 9;
        this.attack = 2;
        this.type = "Wizard";
        this.emoji = Character.toString(0x1F9B9);
    }
}
