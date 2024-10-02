package game.board.enemy;

public class Enemy {
    protected int attack;
    protected int health;
    protected String type;
    protected String emoji;

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

    public String getEmoji() {
        return emoji;
    }
}
