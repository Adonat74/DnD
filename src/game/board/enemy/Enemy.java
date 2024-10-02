package game.board.enemy;

public class Enemy {
    protected int attack;
    protected int health;
    protected String type;
    protected String emoji;
    protected boolean isDead = false;

    public Enemy () {

    }

//    SETTERS
    public void setHealth(int damage) {
        this.health -= damage;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
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
    public boolean getIsDead() {
        return isDead;
    }
    public String getEmoji() {
        return emoji;
    }
}
