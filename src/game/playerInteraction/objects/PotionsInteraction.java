package game.playerInteraction.objects;

import character.PlayerCharacter;
import db.DB;
import game.board.cell.Cell;
import game.board.surpriseBoxLoot.potions.Potion;
import game.board.surpriseBoxLoot.potions.attributePotions.ThunderclapPotion;
import game.board.surpriseBoxLoot.potions.healingPotions.GreaterPotionOfHealing;
import game.board.surpriseBoxLoot.potions.healingPotions.PotionOfHealing;
import util.ConsolePrints;

import java.sql.SQLException;

public class PotionsInteraction {


    public static void interact(Cell<?> cell, PlayerCharacter playerCharacter, DB db) throws SQLException {
        int characterAttack = playerCharacter.getAttack();
        int characterHealth = playerCharacter.getHealth();
        String upArrowEmoji = Character.toString(0x1F51D);

        if (cell.getEntity() instanceof PotionOfHealing || cell.getEntity() instanceof GreaterPotionOfHealing){

            int bonusHealth = ((Potion) cell.getEntity()).getHealthBonus();
            playerCharacter.setHealth(bonusHealth);
            ConsolePrints.printHealingPotionInteraction(cell, characterHealth, playerCharacter);

            db.changeHealthPoints(playerCharacter);

        } else if (cell.getEntity() instanceof ThunderclapPotion){

            if (!playerCharacter.getHasAttackBonus()) {
                playerCharacter.setAttack(characterAttack * 2);
                playerCharacter.setHasAttackBonus(true);
            }

            ConsolePrints.printAttributePotionInteraction(cell, characterAttack, playerCharacter);
        }
    }



}
