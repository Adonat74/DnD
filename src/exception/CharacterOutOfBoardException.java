package exception;

public class CharacterOutOfBoardException extends Exception {
    public CharacterOutOfBoardException() {
        System.out.println("player position out of the board length");
    }
}
