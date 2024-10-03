package util;

import character.PlayerCharacter;
import game.Game;
import game.board.cell.Cell;
import game.board.enemy.Enemy;
import game.board.surpriseBoxLoot.equipment.OffensiveEquipment;
import game.board.surpriseBoxLoot.equipment.offensive.Spell;
import game.board.surpriseBoxLoot.equipment.offensive.Weapon;
import game.board.surpriseBoxLoot.potions.Potion;

public class ConsolePrints {
    private static final String gameOverEmoji = Character.toString(0x274C);
    private static final String warriorEmoji = Character.toString(0x1F6E1);
    private static final String mageEmoji = Character.toString(0x1F9D9);
    private static final String listEmoji = Character.toString(0x1F4DC);
    private static final String dieEmoji = Character.toString(0x1F3B2);
    private static final String runEmoji = Character.toString(0x1F3C3);
    private static final String strikeEmoji = Character.toString(0x1F4A5);
    private static final String healthEmoji = Character.toString(0x2764);
    private static final String deathEmoji = Character.toString(0x1F480);
    private static final String backArrowEmoji = Character.toString(0x1F519);
    private static final String lensEmoji = Character.toString(0x1F50D);
    private static final String downArrowEmoji = Character.toString(0x2B07);
    private static final String upArrowEmoji = Character.toString(0x1F51D);
    private static final String crossEmoji = Character.toString(0x274C);



    public static void printHomeMenu() {
        System.out.println("Choice > 1: Character creation 2: Select existing character 3: Quit game");
    }
    public static void printCharacterChoice() {
        System.out.println("Choose a character by it's id : " + listEmoji);
    }
    public static void printCharacterDoesntExist() {
        System.out.println("This character does not exist" + gameOverEmoji);
    }
    public static void printPlayMenu() {
        System.out.println("Choice > 1: Play  2: New character  3: Quit game");
    }
    public static void printEnterToMenu() {
        System.out.println("Press Enter to go back to the menu.");
    }
    public static void printTypeChoice() {
        System.out.println("Enter character type > 1: warrior" + warriorEmoji + "  2: mage" + mageEmoji);
    }
    public static void printEnterName() {
        System.out.println("Enter character name");
    }
    public static void printIsOnSquare(PlayerCharacter playerCharacter, int firstCharacter) {
        System.out.println(playerCharacter.getName() + " is on square nb " + (firstCharacter));
    }
    public static void printTurn(int turn) {
        System.out.println("Turn number : " + turn);
    }
    public static void printEnterToThrowDie() {
        System.out.println("Press enter to throw die" + dieEmoji);
    }
    public static void printDieResult(int dieRoll) {
        System.out.println("Die result : " + dieRoll + dieEmoji);
    }
    public static void printIsDead(String enemyType) {
        System.out.println(enemyType + " is already dead");

    }
    public static void printSpecialEnemyInteraction(String characterType, String enemyType) throws InterruptedException {
        System.out.println("You are a " + characterType + ", " + enemyType + " fear you! ");
        Pause.pause(500);
        System.out.println(enemyType + " run away !");
    }
    public static void printEnemyDetected(Enemy enemy) throws InterruptedException {
        System.out.println("Enemy detected ..." + lensEmoji);
        Pause.pause(500);
        System.out.println("It's a " + enemy.getEnemyType() + " !" + enemy.getEmoji());
        Pause.pause(500);
    }
    public static void printCharacterInfos(int characterHealth, int characterAttack, OffensiveEquipment offensiveEquipment, Enemy enemy) throws InterruptedException {
        System.out.println("Your health: " + characterHealth +  " Your attack: " + characterAttack + "   Your Equipment : "+ offensiveEquipment.getOffensiveEquipmentType() + "   Equipment Attack : "+ offensiveEquipment.getOffensiveEquipmentAttackLevel() +"\n"+ "Enemy health: " + enemy.getEnemyHealth()+"  Enemy attack: " + enemy.getEnemyAttack());
        Pause.pause(500);
    }
    public static void printFightChoice() {
        System.out.println("Choose action > 1: attack" + strikeEmoji + "  2: run away" + runEmoji);
    }
    public static void printYouStrike() {
        System.out.println("You strike !" + strikeEmoji);
    }
    public static void printEnemyHealthUpdate(int enemyHealth, int characterAttack, OffensiveEquipment offensiveEquipment, Enemy enemy) throws InterruptedException {
        Pause.pause(500);
        System.out.println("Enemy health: " + enemyHealth + " - " + characterAttack+ "+"  + offensiveEquipment.getOffensiveEquipmentAttackLevel()+" > " + enemy.getEnemyHealth() + healthEmoji);
        Pause.pause(500);
    }
    public static void printYouRunAway() {
        System.out.println("You run away !" + runEmoji);
    }
    public static void printYouGoBack(Game game) {
        System.out.println("You go back " + game.getFirstCharacter() + " cells !" + backArrowEmoji);
    }
    public static void printYouGoBackDie(int dieRoll) {
        System.out.println("You go back " + dieRoll + " cells !" + backArrowEmoji);
    }
    public static void printThunderclapNoEffect(PlayerCharacter playerCharacter) {
        System.out.println("The Thunderclap potion effects vanishes : Your Attack" + " > " + playerCharacter.getAttack() + downArrowEmoji);
    }
    public static void printEnemyStrike() throws InterruptedException {
        System.out.println("Enemy strike !" + strikeEmoji);
        Pause.pause(500);
    }
    public static void printCharacterHealthUpdate(int characterHealth, Enemy enemy, PlayerCharacter playerCharacter) throws InterruptedException {
        System.out.println("Your health: " + characterHealth + " - " + enemy.getEnemyAttack() + " > " + playerCharacter.getHealth() + healthEmoji);
        Pause.pause(500);
    }
    public static void printYouKilled() {
        System.out.println("You killed the enemy !" + deathEmoji);
    }
    public static void printEnemyKilledYou() {
        System.out.println("Enemy killed you !" + deathEmoji + deathEmoji + deathEmoji);
    }
    public static void printGameOver() {
        System.out.println("GAME OVER !" + gameOverEmoji);
    }
    public static void printWeaponInteraction(Cell<?> cell, int equipmentAttack, PlayerCharacter playerCharacter) {
        System.out.println("A new offensive gear! "+((Weapon) cell.getEntity()).getOffensiveEquipmentType() + ((Weapon) cell.getEntity()).getEmoji() + "  Attack level : " + equipmentAttack);
        System.out.println("You equip this gear : Your attack > " + playerCharacter.getAttack() + " +  Equipment Attack > " + equipmentAttack + upArrowEmoji);
    }
    public static void printSpellInteraction(Cell<?> cell, int equipmentAttack, PlayerCharacter playerCharacter) {
        System.out.println("A new offensive gear! "+((Spell) cell.getEntity()).getOffensiveEquipmentType() + ((Spell) cell.getEntity()).getEmoji() + "  Attack level : " + equipmentAttack);
        System.out.println("You equip this gear : Your attack > " + playerCharacter.getAttack() + " +  Equipment Attack > " + equipmentAttack + upArrowEmoji);
    }

    public static void printCantEquipGear(Cell<?> cell, PlayerCharacter playerCharacter) {
        System.out.println(((OffensiveEquipment) cell.getEntity()).getOffensiveEquipmentType() + ((OffensiveEquipment) cell.getEntity()).getEmoji());
        System.out.println("You are a " + playerCharacter.getType() + ", you can't equip this gear !" + crossEmoji);
    }

    public static void printHealingPotionInteraction(Cell<?> cell, int characterHealth, PlayerCharacter playerCharacter) {
        System.out.println(((Potion) cell.getEntity()).getPotionType() + ((Potion) cell.getEntity()).getEmoji());
        System.out.println("your health increases : " + characterHealth + " > " + playerCharacter.getHealth() + upArrowEmoji);
    }

    public static void printAttributePotionInteraction(Cell<?> cell, int characterAttack, PlayerCharacter playerCharacter) {
        System.out.println(((Potion) cell.getEntity()).getPotionType() + ((Potion) cell.getEntity()).getEmoji());
        System.out.println("your attack increases for 1 turn: " + characterAttack + " > " + playerCharacter.getAttack() + upArrowEmoji);
    }


}
