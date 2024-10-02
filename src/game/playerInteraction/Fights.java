package game.playerInteraction;

import character.PlayerCharacter;
import db.DB;
import game.Game;
import game.board.Board;
import game.board.cell.Cell;
import game.board.enemy.Enemy;
import util.DieRoll;
import util.GetValidInputChoice;
import util.Pause;

import java.sql.SQLException;
import java.util.Scanner;

public class Fights {
    String runEmoji = Character.toString(0x1F3C3);
    String strikeEmoji = Character.toString(0x1F4A5);
    String healthEmoji = Character.toString(0x2764);
    String deathEmoji = Character.toString(0x1F480);
    String gameOverEmoji = Character.toString(0x274C);
    String backArrowEmoji = Character.toString(0x1F519);
    String lensEmoji = Character.toString(0x1F50D);


    private final Pause pause = new Pause();
    private final Board board;
    private final Game game;

    GetValidInputChoice getValidInputChoice = new GetValidInputChoice();


    public Fights(Game game) throws SQLException, InterruptedException {
        this.game = game;
        this.board = game.getBoard();
    }



    public void fight(PlayerCharacter playerCharacter, int characterAttack, int characterHealth, DB db, Cell<?> cell) throws InterruptedException, SQLException {
        Scanner scan = new Scanner(System.in);

        Enemy enemy = (Enemy) cell.getEntity(); // Cast en type Enemy

        System.out.println("Enemy detected ..." + lensEmoji);
        pause.pause(500);

        System.out.println("It's a " + enemy.getEnemyType() + " !" + enemy.getEmoji());
        pause.pause(500);

        System.out.println("Your health: " + characterHealth + "  Enemy health: " + enemy.getEnemyHealth()+"\n"+ "Your attack: " + characterAttack + "  Enemy attack: " + enemy.getEnemyAttack());
                pause.pause(500);


        while(playerCharacter.getHealth() > 0 && enemy.getEnemyHealth() > 0){

            int choice = 0;
            while (choice!= 1 && choice!=2) {
                System.out.println("Choose action > 1: attack" + strikeEmoji + "  2: run away" + runEmoji);
                choice = getValidInputChoice.getValidInt(scan);
            }

            if (choice == 1){
                System.out.println("You strike !" + strikeEmoji);
                int enemyHealth = enemy.getEnemyHealth();
                enemy.setHealth(characterAttack);
                        pause.pause(500);

                System.out.println("Enemy health: " + enemyHealth + " - " + characterAttack + " > " + enemy.getEnemyHealth() + healthEmoji);
                        pause.pause(500);

                if (enemy.getEnemyHealth() <= 0) {
                    break;
                }
            } else if (choice == 2){
                System.out.println("You run away !" + runEmoji);
                int dieRoll = new DieRoll(6).getDie();

                game.setFirstCharacter(game.getFirstCharacter()-dieRoll);
                System.out.println("You go back " + dieRoll + " cells !" + backArrowEmoji);
                System.out.println(playerCharacter.getName() + " is on square nb " + (game.getFirstCharacter()));

                break;
            }
            System.out.println("Enemy strike !" + strikeEmoji);
                    pause.pause(500);

            playerCharacter.setDamageTaken(enemy.getEnemyAttack());
            System.out.println("Your health: " + characterHealth + " - " + enemy.getEnemyAttack() + " > " + playerCharacter.getHealth() + healthEmoji);
                    pause.pause(500);


            db.changeHealthPoints(playerCharacter);
        }


        if (enemy.getEnemyHealth()<= 0) {
            System.out.println("You killed the enemy !" + deathEmoji);
        } else if (playerCharacter.getHealth() <= 0) {
            System.out.println("Enemy killed you !" + deathEmoji + deathEmoji + deathEmoji);
            game.setGameOver(true);
            System.out.println("GAME OVER !" + gameOverEmoji);
        }
    }
}
