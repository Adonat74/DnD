package exceptions;

public class CharacterOutOfBoardException extends Exception {
    public CharacterOutOfBoardException() {
        super("player position out of the board length");
    }
}
