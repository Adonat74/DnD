package game.playerInteraction;

import character.PlayerCharacter;
import db.DB;
import game.Game;
import game.board.cell.Cell;
import game.board.cell.special.Enemy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Fights {
    String runEmoji = Character.toString(0x1F3C3);
    String strikeEmoji = Character.toString(0x1F4A5);
    String healthEmoji = Character.toString(0x2764);
    String deathEmoji = Character.toString(0x1F480);
    String gameOverEmoji = Character.toString(0x274C);
    String backArrowEmoji = Character.toString(0x1F519);
    String lensEmoji = Character.toString(0x1F50D);



    private final Game game;

    public Fights(Game game) throws SQLException {
        this.game = game;
    }

    private void pause() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
    }


    public void fight(PlayerCharacter playerCharacter, int characterAttack, int characterHealth, ArrayList<Cell> board, DB db) throws InterruptedException, SQLException {
        Scanner scan = new Scanner(System.in);
        Enemy enemy = (Enemy) board.get(game.getFirstCharacter()); // Cast en type Enemy

        System.out.println("Enemy detected ..." + lensEmoji);
        pause();

        System.out.println("It's a " + enemy.getEnemyType() + " !" + enemy.getEmoji());
        pause();

        System.out.println("Your health: " + characterHealth + "  Enemy health: " + enemy.getEnemyHealth()+"\n"+ "Your attack: " + characterAttack + "  Enemy attack: " + enemy.getEnemyAttack());
        pause();

        while(playerCharacter.getHealth() > 0 && enemy.getEnemyHealth() > 0){

            System.out.println("Choose action > 1: attack" + strikeEmoji + "  2: run away" + runEmoji);
            int choice = scan.nextInt();


            if (choice == 1){
                System.out.println("You strike !" + strikeEmoji);
                int enemyHealth = enemy.getEnemyHealth();
                enemy.setHealth(characterAttack);
                pause();
                System.out.println("Enemy health: " + enemyHealth + " - " + characterAttack + " > " + enemy.getEnemyHealth() + healthEmoji);
                pause();
                if (enemy.getEnemyHealth() <= 0) {
                    break;
                }
            } else if (choice == 2){
                System.out.println("You run away !" + runEmoji);
                int sixFaceDie = (int)(Math.random() * 4)+1;

                game.setFirstCharacter(game.getFirstCharacter()-1);
                System.out.println("You go back " + 1 + " cells !" + backArrowEmoji);
                break;
            }
            System.out.println("Enemy strike !" + strikeEmoji);
            pause();
            playerCharacter.setDamageTaken(enemy.getEnemyAttack());
            System.out.println("Your health: " + characterHealth + " - " + enemy.getEnemyAttack() + " > " + playerCharacter.getHealth() + healthEmoji);
            pause();

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
