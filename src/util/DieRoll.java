package util;

public class DieRoll {
    private final int die;
    // parameter to choose the number of faces the dice have
    public DieRoll(int faces) {
        this.die = (int)(Math.random() * faces)+1;
    }
//     GETTERS
    public int getDie() {
        return die;
    }
}
