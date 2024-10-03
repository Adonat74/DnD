package game.playerInteraction.objects;

import character.PlayerCharacter;
import db.DB;
import game.board.cell.Cell;
import game.board.surpriseBoxLoot.potions.Potion;
import game.board.surpriseBoxLoot.potions.attributePotions.ThunderclapPotion;
import game.board.surpriseBoxLoot.potions.healingPotions.GreaterPotionOfHealing;
import game.board.surpriseBoxLoot.potions.healingPotions.PotionOfHealing;

import java.sql.SQLException;

public class PotionsInteraction {


    public void potionsInteraction(Cell<?> cell, PlayerCharacter playerCharacter, DB db) throws SQLException {
        int characterAttack = playerCharacter.getAttack();
        int characterHealth = playerCharacter.getHealth();
        String upArrowEmoji = Character.toString(0x1F51D);

        if (cell.getEntity() instanceof PotionOfHealing || cell.getEntity() instanceof GreaterPotionOfHealing){

            int bonusHealth = ((Potion) cell.getEntity()).getHealthBonus();
            playerCharacter.setHealth(bonusHealth);
            System.out.println(((Potion) cell.getEntity()).getPotionType() + ((Potion) cell.getEntity()).getEmoji());
            System.out.println("your health increases : " + characterHealth + " > " + playerCharacter.getHealth() + upArrowEmoji);
            db.changeHealthPoints(playerCharacter);

        } else if (cell.getEntity() instanceof ThunderclapPotion){

            if (!playerCharacter.getHasAttackBonus()) {
                playerCharacter.setAttack(characterAttack * 2);
                playerCharacter.setHasAttackBonus(true);
            }
            System.out.println(((Potion) cell.getEntity()).getPotionType() + ((Potion) cell.getEntity()).getEmoji());
            System.out.println("your attack increases for 1 turn: " + characterAttack + " > " + playerCharacter.getAttack() + upArrowEmoji);
        }
    }



}
