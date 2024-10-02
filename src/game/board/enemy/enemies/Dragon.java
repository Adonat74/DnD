package game.board.enemy.enemies;

import game.board.enemy.Enemy;

public class Dragon extends Enemy {
    public Dragon() {
        this.health = 15;
        this.attack = 6;
        this.type = "Dragon";
        this.emoji = Character.toString(0x1F409);
    }
}
