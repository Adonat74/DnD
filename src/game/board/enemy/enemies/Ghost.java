package game.board.enemy.enemies;

import game.board.enemy.Enemy;

public class Ghost extends Enemy {
    public Ghost() {
        this.health = 15;
        this.attack = 5;
        this.type = "Ghost";
        this.emoji = Character.toString(0x1F47B);
    }
}
