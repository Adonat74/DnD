package game.board.cell.special.enemies;

import game.board.cell.special.Enemy;

public class Goblin extends Enemy {
    public Goblin() {
        this.health = 6;
        this.attack = 1;
        this.type = "Goblin";
        this.emoji = Character.toString(0x1F47A);

    }
}
