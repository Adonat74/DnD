package menu;
import java.util.Scanner;


public class Menu {
    public static void play() {
        Scanner scan = new Scanner(System.in);


        System.out.println("Choice : \"Character creation\" \"Quit game\"");

        String choix = "";
        while (!choix.equals("Quit game") && !choix.equals("Character creation")) {
            choix = scan.nextLine();
            if (choix.equals("Character creation")){
                System.out.println("Enter character type : warrior or wizard");
                String type = scan.nextLine();
                System.out.println("Enter character name");
                String name = scan.nextLine();
                System.out.println(type + name);
            } else if (choix.equals("Quit game")){
                System.exit(0);
            } else {
                System.out.println("wrong Choice : \"Character creation\" \"Quit game\"");
            }
        }






        scan.close();
    }

}
