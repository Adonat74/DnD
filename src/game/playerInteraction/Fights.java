package game.playerInteraction;

import character.Character;
import game.cell.Cell;
import game.cell.special.Enemy;
import game.cell.special.enemies.Dragon;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Fights {
    private void pause() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
    }


    public void fight(Character character,int firstCharacter, int characterAttack, int characterHealth, ArrayList<Cell> cellsTable) throws InterruptedException {
        Enemy enemy = (Enemy) cellsTable.get(firstCharacter); // Cast en type Enemy
        System.out.println("Enemy detected ...");
        pause();
        if (enemy instanceof Dragon) {
            Dragon dragon = (Dragon) enemy;
            System.out.println("It's a dragon !");
            pause();
        }

        System.out.println("Your health: " + characterHealth + "  Enemy health: " + enemy.getEnemyHealth()+"\n"+ "Your attack: " + characterAttack + "  Enemy attack: " + enemy.getEnemyAttack());

        pause();
        System.out.println("You strike !");
        int enemyHealth = enemy.getEnemyHealth();
        enemy.setHealth(characterAttack);
        pause();
        System.out.println("Enemy health: " + enemyHealth + " - " + characterAttack + " > " + enemy.getEnemyHealth());
        pause();
        if (enemy.getEnemyHealth()<= 0) {
            System.out.println("You killed the enemy !");
        } else {
            System.out.println("Enemy strike !");
            pause();
            character.setDamage(enemy.getEnemyAttack());
            System.out.println("Your health: " + characterHealth + " - " + enemy.getEnemyAttack() + " > " + character.getHealth());
            pause();
            System.out.println("Enemy run away !");
        }
    }
}
