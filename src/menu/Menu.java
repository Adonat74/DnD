package menu;
import java.util.Scanner;
import character.Character;
import game.Game;


public class Menu {
    private Character character;
    private int choice = 0;

    public Menu() {
    }


    public void menuChoice() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Game game = new Game();

//      start the game with a choice between quit or create character
        while (choice!=2 && choice!=1) {
            System.out.println("Choice > 1: Character creation 2: Quit game");
            choice = scan.nextInt();
            if (choice==1){
                createCharacter(scan);
            } else if (choice==2){
                System.exit(0);
            }
        }
//      Choose to play the game or to quit
        while(true) {
            choice = 0;
            while (choice!=2 && choice!=1) {
                System.out.println("Choice > 1: Play  2: Quit game");
                choice = scan.nextInt();
                if (choice==1){
                    game.play(character);// lance le jeu avec la fonction play
                } else if (choice==2){
                    System.exit(0);
                }
            }
        }
    }
//  function to create a character
    public void createCharacter(Scanner scan) {
        int type = 0;
//        choose a type 1 for warrior and 2 for wizard
        while (type!=2 && type!=1) {
            System.out.println("Enter character type > 1: warrior  2: wizard");
            type = scan.nextInt();
            scan.nextLine();
        }
//    then enter a name
        System.out.println("Enter character name");
        String name = scan.nextLine();
//        instenciate a character class
        character = new Character(type, name);

        character.printAttributes();
    }
}
