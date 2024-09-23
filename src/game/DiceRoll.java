package game;

public class DiceRoll {
    private int dice;
    public DiceRoll() {
        this.dice = (int)(Math.random() * 6)+1;
    }
//     GETTERS
    public int getDice() {
        return dice;
    }
}
