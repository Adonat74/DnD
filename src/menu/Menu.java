package menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import character.PlayerCharacter;
import character.types.Warrior;
import character.types.Mage;
import exception.CharacterOutOfBoardException;
import game.Game;
import db.DB;


public class Menu {
    private PlayerCharacter playerCharacter;
    private int choice = 0;
    DB db = new DB();

    public Menu() throws SQLException {
    }


    public void menuChoice() throws InterruptedException, SQLException {
        Scanner scan = new Scanner(System.in);
        Game game = new Game();
        while(true) {

            choice = 0;
    //      start the game with a choice between quit or create character
            while (choice!=2 && choice!=1 && choice!=3) {
                System.out.println("Choice > 1: Character creation 2: Select existing character 3: Quit game");
                choice = scan.nextInt();
                if (choice==1){
                    createCharacter(scan);
                } else if (choice==2){
                    System.out.println("Choice of id > ");
                    db.getHeroes();
                    int id = scan.nextInt();
                    createCharacter(scan, id);
                } else if (choice==3){
                    System.exit(0);
                }
            }
    //      Choose to play the game or to quit

            choice = 0;
            while (choice!=2 && choice!=1 && choice!=3) {
                System.out.println("Choice > 1: Play  2: New character  3: Quit game");
                choice = scan.nextInt();
                if (choice==1){
                    try{
                        game.testPlay(playerCharacter, db);// lance le jeu avec la fonction play
                    } catch (CharacterOutOfBoardException e) {
                        throw new RuntimeException(e);
                    }
                    choice = 0;
                } else if (choice==2){

                } else if (choice==3){
                    System.exit(0);
                }
            }
        }
    }
//  function to create a character
    public void createCharacter(Scanner scan, int... id) throws SQLException {

//         à modifier si le personnage doit avoir des stats persistantes.
        if (id.length !=0){
            ResultSet rs = db.getOneHero(id[0]);
            while (rs.next()) {
                if (rs.getString("type").equals("warrior")) {
                    playerCharacter = new Warrior(rs.getString("name"));
                } else if(rs.getString("type").equals("mage")) {
                    playerCharacter = new Mage(rs.getString("name"));
                }
            }
        } else {
            int type = 0;
//        choose a type 1 for warrior and 2 for wizard
            while (type!=2 && type!=1) {
                System.out.println("Enter character type > 1: warrior  2: mage");
                type = scan.nextInt();
                scan.nextLine();
            }
            // then enter a name
            System.out.println("Enter character name");
            String name = scan.nextLine();
            // instenciate a warrior or wizard class
            if (type==1){
                playerCharacter = new Warrior(name);
                db.createHero(playerCharacter);
            } else if (type==2){
                playerCharacter = new Mage(name);
                db.createHero(playerCharacter);
            }
        }

        System.out.println(playerCharacter.toString());
    }
}
