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

        System.out.println("Enemy detected ...");
        pause();

        System.out.println("It's a " + enemy.getEnemyType() + " !");
        pause();

        System.out.println("Your health: " + characterHealth + "  Enemy health: " + enemy.getEnemyHealth()+"\n"+ "Your attack: " + characterAttack + "  Enemy attack: " + enemy.getEnemyAttack());
        pause();

        while(playerCharacter.getHealth() > 0 && enemy.getEnemyHealth() > 0){

            System.out.println("Choose action > 1: attack  2: run away");
            int choice = scan.nextInt();


            if (choice == 1){
                System.out.println("You strike !");
                int enemyHealth = enemy.getEnemyHealth();
                enemy.setHealth(characterAttack);
                pause();
                System.out.println("Enemy health: " + enemyHealth + " - " + characterAttack + " > " + enemy.getEnemyHealth());
                pause();
                if (enemy.getEnemyHealth() <= 0) {
                    break;
                }
            } else if (choice == 2){
                System.out.println("You run away !");
                int sixFaceDie = (int)(Math.random() * 4)+1;

                game.setFirstCharacter(game.getFirstCharacter()-1);
                System.out.println("You go back " + 1 + " cells !");
                break;
            }
            System.out.println("Enemy strike !");
            pause();
            playerCharacter.setDamageTaken(enemy.getEnemyAttack());
            System.out.println("Your health: " + characterHealth + " - " + enemy.getEnemyAttack() + " > " + playerCharacter.getHealth());
            pause();

            db.changeHealthPoints(playerCharacter);
        }


        if (enemy.getEnemyHealth()<= 0) {
            System.out.println("You killed the enemy !");
        } else if (playerCharacter.getHealth() <= 0) {
            System.out.println("Enemy killed you !");
            game.setGameOver(true);
            System.out.println("GAME OVER !");
        }
    }
}
