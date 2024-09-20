package menu;
import java.util.Scanner;
import character.Character;
import game.Game;


public class Menu {
    private Character character;
    private int choice = 0;

    private boolean isPlaying;

    public Menu() {
        this.isPlaying = true;
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

        while(isPlaying) {
            choice = 0;
            while (choice!=2 && choice!=1) {
                System.out.println("Choice > 1: Play  2: Quit game");
                choice = scan.nextInt();
                if (choice==1){
                    game.play(character);
                } else if (choice==2){
                    System.exit(0);
                }
            }
        }
        scan.close();
    }

    public void createCharacter(Scanner scan) {
        int type = 0;
        while (type!=2 && type!=1) {
            System.out.println("Enter character type > 1: warrior  2: wizard");
            type = scan.nextInt();
            scan.nextLine();
        }

        System.out.println("Enter character name");
        String name = scan.nextLine();
        character = new Character(type, name);

        character.printAttributes();
    }
}
