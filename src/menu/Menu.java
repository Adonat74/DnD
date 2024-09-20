package menu;
import java.util.Scanner;


public class Menu {
    public static void play() {
        Scanner scan = new Scanner(System.in);


        System.out.println("Choice : \"Character creation\" \"Quit game\"");

//        start the game with a choice between quit or create character
        String choice = "";
        while (!choice.equals("Quit game") && !choice.equals("Character creation")) {
            choice = scan.nextLine();
            if (choice.equals("Character creation")){
                System.out.println("Enter character type : warrior or wizard");
                String type = scan.nextLine();
                System.out.println("Enter character name");
                String name = scan.nextLine();
                System.out.println(type + name);
            } else if (choice.equals("Quit game")){
                System.exit(0);
            } else {
                System.out.println("wrong Choice : \"Character creation\" \"Quit game\"");
            }
        }






        scan.close();
    }

}
