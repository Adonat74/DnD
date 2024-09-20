package menu;
import java.util.Scanner;
import character.Character;
import game.Game;


public class Menu {
    private Character character;

    public void menuChoice() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Game game = new Game();


        System.out.println("Choice : \"Character creation\" \"Quit game\"");

//        start the game with a choice between quit or create character
        String choice = "";
        while (!choice.equals("Quit game") && !choice.equals("Character creation")) {
            choice = scan.nextLine();
            if (choice.equals("Character creation")){
                createCharacter(scan);
            } else if (choice.equals("Quit game")){
                System.exit(0);
            } else {
                System.out.println("wrong Choice : \"Character creation\" \"Quit game\"");
            }
        }

        System.out.println("Choice : \"Play\" \"Quit game\"");
        while (!choice.equals("Quit game") && !choice.equals("Play")) {
            choice = scan.nextLine();
            if (choice.equals("Play")){
                game.play(character);
            } else if (choice.equals("Quit game")){
                System.exit(0);
            } else {
                System.out.println("wrong Choice : \"Play\" \"Quit game\"");
            }
        }

        scan.close();
    }

    public void createCharacter(Scanner scan) {

        System.out.println("Enter character type : warrior or wizard");
        String type = scan.nextLine();
        System.out.println("Enter character name");
        String name = scan.nextLine();
        character = new Character(type, name);


        character.printAttributes();
    }
}
