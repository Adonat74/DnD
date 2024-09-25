package game.dieRoll;

public class DieRoll {
    private int die;
    public DieRoll() {
        this.die = (int)(Math.random() * 6)+1;
    }
//     GETTERS
    public int getDie() {
        return die;
    }
}
