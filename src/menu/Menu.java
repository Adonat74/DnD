package menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import character.PlayerCharacter;
import character.types.Warrior;
import character.types.Mage;
import exceptions.CharacterOutOfBoardException;
import exceptions.CharacterSavedListEmptyException;
import game.Game;
import db.DB;
import util.GetValidInputChoice;
import util.Pause;
import util.ConsolePrints;

public class Menu {
    private PlayerCharacter playerCharacter;
    private int choice = 0;
    DB db = new DB();
    GetValidInputChoice getValidInputChoice = new GetValidInputChoice();


    public Menu() throws SQLException {
    }


    public void menuChoice() throws InterruptedException, SQLException {
        Scanner scan = new Scanner(System.in);
        Game game = new Game();
        while(true) {

            choice = 0;
    //      start the game with a choice between quit or create character
            while (choice!=2 && choice!=1 && choice!=3) {
                ConsolePrints.printHomeMenu();
                
                choice = getValidInputChoice.getValidInt(scan);
                
                if (choice==1){
                    createCharacter(scan);
                } else if (choice==2){
//              Bloc qui verifie si il y a des personnages dans la bdd
                    int id = -1;
                    while (id == -1) {
                        try {
                            ConsolePrints.printCharacterChoice();
                            db.getHeroes();
                        } catch (CharacterSavedListEmptyException e) {
                            System.out.println(e.getMessage());
                            choice = 0;
                        }
//                        Throw an error if the character id does not exist
                        try {
                            id = getValidInputChoice.getValidInt(scan);
                            createCharacter(scan, id);
                        } catch (Exception e) {
                            ConsolePrints.printCharacterDoesntExist();
                            choice = 0;
                            id = -1;
                        }
                    }

                } else if (choice==3){
                    System.exit(0);
                }
            }
    //      Choose to play the game or to quit

            choice = 0;
            while (choice!=2 && choice!=1 && choice!=3) {
                ConsolePrints.printPlayMenu();
                choice = getValidInputChoice.getValidInt(scan);
                if (choice==1){
                    try{
                        // lance le jeu avec la fonction play
                        game.testPlay(playerCharacter, db);
                    } catch (CharacterOutOfBoardException e) {
                        System.out.println(e.getMessage());
                        Pause.pause(500);
                        ConsolePrints.printEnterToMenu();
                        scan.nextLine();
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
                ConsolePrints.printTypeChoice();
                type = getValidInputChoice.getValidInt(scan);
                scan.nextLine();
            }
            // then enter a name
            ConsolePrints.printEnterName();
            String name = getValidInputChoice.getValidString(scan);
            // instantiate a warrior or wizard class
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
