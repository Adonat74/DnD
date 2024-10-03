package game.playerInteraction.objects;

import character.PlayerCharacter;
import game.board.cell.Cell;
import game.board.surpriseBoxLoot.equipment.offensive.Spell;
import game.board.surpriseBoxLoot.equipment.offensive.Weapon;
import util.ConsolePrints;

public class OffensiveGearInteraction {

    public static void interact(Cell<?> cell, PlayerCharacter playerCharacter){
        String characterType = playerCharacter.getType();
        if (cell.getEntity() instanceof Weapon && characterType.equals("warrior")) {

            //            if you are a warrior, and it's a weapon you can equip the gear
            int equipmentAttack = ((Weapon) cell.getEntity()).getOffensiveEquipmentAttackLevel();
            playerCharacter.setOffensiveEquipment((Weapon) cell.getEntity());
            ConsolePrints.printWeaponInteraction(cell, equipmentAttack, playerCharacter);

        } else if (cell.getEntity() instanceof Spell && characterType.equals("mage")) {

            //            if you are a mage, and it's a spell you can equip the gear
            int equipmentAttack = ((Spell) cell.getEntity()).getOffensiveEquipmentAttackLevel();
            playerCharacter.setOffensiveEquipment((Spell) cell.getEntity());
            ConsolePrints.printSpellInteraction(cell, equipmentAttack, playerCharacter);

        } else {
            //            else you can't equip the gear
            ConsolePrints.printCantEquipGear(cell, playerCharacter);
        }
    }

}
