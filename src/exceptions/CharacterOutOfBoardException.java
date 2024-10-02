package exceptions;

public class CharacterOutOfBoardException extends Exception {
    public CharacterOutOfBoardException() {
        super("You got to the 64 cell !! you win!");
    }
}
