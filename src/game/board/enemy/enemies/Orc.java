package game.board.enemy.enemies;

import game.board.enemy.Enemy;

public class Orc extends Enemy {
    public Orc() {
        this.health = 10;
        this.attack = 6;
        this.type = "Orc";
        this.emoji = Character.toString(0x1F9DF);
    }
}
