package exceptions;

public class CharacterSavedListEmptyException extends Exception {
    public CharacterSavedListEmptyException() {
        super("No character saved, please create a new one !");
    }
}
