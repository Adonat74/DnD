package game.board.cell.special;

import game.board.cell.Cell;

public class Enemy implements Cell {
    protected int attack;
    protected int health;
    protected String type;

    public Enemy () {

    }

//    SETTERS
    public void setHealth(int damage) {
        this.health -= damage;
    }

//    GETTERS
    public int getEnemyAttack() {
        return attack;
    }
    public int getEnemyHealth() {
        return health;
    }
    public String getEnemyType() {
        return type;
    }



}
