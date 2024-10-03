package game.playerInteraction.fights;

import character.PlayerCharacter;
import db.DB;
import game.Game;
import game.board.Board;
import game.board.cell.Cell;
import game.board.enemy.Enemy;
import game.board.surpriseBoxLoot.equipment.OffensiveEquipment;
import util.ConsolePrints;
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
    String downArrowEmoji = Character.toString(0x2B07);


    private final Board board;
    private final Game game;

    GetValidInputChoice getValidInputChoice = new GetValidInputChoice();


    public Fights(Game game, int firstCharacter) throws SQLException, InterruptedException {
        this.game = game;
        this.board = game.getBoard();
    }



    public void fight(PlayerCharacter playerCharacter, int characterAttack, int characterHealth, DB db, Cell<?> cell, OffensiveEquipment offensiveEquipment) throws InterruptedException, SQLException {
        Scanner scan = new Scanner(System.in);

        Enemy enemy = (Enemy) cell.getEntity(); // Cast en type Enemy

        ConsolePrints.printEnemyDetected(enemy);

        offensiveEquipment.isAgainstSpecialEnemy(enemy);

        ConsolePrints.printCharacterInfos(characterHealth, characterAttack, offensiveEquipment, enemy);


        while(playerCharacter.getHealth() > 0 && enemy.getEnemyHealth() > 0){

            int choice = 0;
            while (choice!= 1 && choice!=2) {
                ConsolePrints.printFightChoice();
                choice = getValidInputChoice.getValidInt(scan);
            }

            if (choice == 1){
                ConsolePrints.printYouStrike();

                int enemyHealth = enemy.getEnemyHealth();
                enemy.setHealth(characterAttack + offensiveEquipment.getOffensiveEquipmentAttackLevel());

                ConsolePrints.printEnemyHealthUpdate(enemyHealth, characterAttack, offensiveEquipment, enemy);

                if (enemy.getEnemyHealth() <= 0) {
                    break;
                }
            } else if (choice == 2){
                ConsolePrints.printYouRunAway();
                int dieRoll = new DieRoll(6).getDie();

                if (game.getFirstCharacter() < dieRoll) {
                    game.setFirstCharacter(0);
                    ConsolePrints.printYouGoBack(game);

                } else {
                    game.setFirstCharacter(game.getFirstCharacter()-dieRoll);
                    ConsolePrints.printYouGoBackDie(dieRoll);

                }
                int firstCharacter = game.getFirstCharacter();
                ConsolePrints.printIsOnSquare(playerCharacter, firstCharacter);

                if (playerCharacter.getHasAttackBonus()) {
                    playerCharacter.setAttack(characterAttack/2);
                    playerCharacter.setHasAttackBonus(false);

                    ConsolePrints.printThunderclapNoEffect(playerCharacter);
                }
                break;
            }
            ConsolePrints.printEnemyStrike();

            playerCharacter.setDamageTaken(enemy.getEnemyAttack());

            ConsolePrints.printCharacterHealthUpdate(characterHealth, enemy, playerCharacter);

            db.changeHealthPoints(playerCharacter);
        }


        if (enemy.getEnemyHealth()<= 0) {
            ConsolePrints.printYouKilled();
//            Appel la fonction qui toggle si un enemy est mort dans le tableau
            board.setDeadEnemy(game.getFirstCharacter());

        } else if (playerCharacter.getHealth() <= 0) {
            ConsolePrints.printEnemyKilledYou();

            game.setGameOver(true);
            ConsolePrints.printGameOver();
        }
        if (playerCharacter.getHasAttackBonus()) {
            playerCharacter.setAttack(characterAttack/2);
            playerCharacter.setHasAttackBonus(false);
            ConsolePrints.printThunderclapNoEffect(playerCharacter);
        }
    }
}
