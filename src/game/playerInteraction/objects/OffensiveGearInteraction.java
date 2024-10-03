package game.playerInteraction.objects;

import character.PlayerCharacter;
import game.board.cell.Cell;
import game.board.surpriseBoxLoot.equipment.OffensiveEquipment;
import game.board.surpriseBoxLoot.equipment.offensive.Spell;
import game.board.surpriseBoxLoot.equipment.offensive.Weapon;

public class OffensiveGearInteraction {

    public void interact(Cell<?> cell, PlayerCharacter playerCharacter){
        String characterType = playerCharacter.getType();
        String upArrowEmoji = Character.toString(0x1F51D);
        String crossEmoji = Character.toString(0x274C);
        if (cell.getEntity() instanceof Weapon && characterType.equals("warrior")) {

            //            if you are a warrior, and it's a weapon you can equip the gear
            int equipmentAttack = ((Weapon) cell.getEntity()).getOffensiveEquipmentAttackLevel();
            playerCharacter.setOffensiveEquipment((Weapon) cell.getEntity());
            System.out.println("A new offensive gear! "+((Weapon) cell.getEntity()).getOffensiveEquipmentType() + ((Weapon) cell.getEntity()).getEmoji() + "  Attack level : " + equipmentAttack);
            System.out.println("You equip this gear : Your attack > " + playerCharacter.getAttack() + " +  Equipment Attack > " + equipmentAttack + upArrowEmoji);


        } else if (cell.getEntity() instanceof Spell && characterType.equals("mage")) {

            //            if you are a mage, and it's a spell you can equip the gear
            int equipmentAttack = ((Spell) cell.getEntity()).getOffensiveEquipmentAttackLevel();
            playerCharacter.setOffensiveEquipment((Spell) cell.getEntity());
            System.out.println("A new offensive gear! "+((Spell) cell.getEntity()).getOffensiveEquipmentType() + ((Spell) cell.getEntity()).getEmoji());
            System.out.println("You equip this gear : " + playerCharacter.getAttack() + " > " + equipmentAttack + upArrowEmoji);


        } else {
            //            else you can't equip the gear
            System.out.println(((OffensiveEquipment) cell.getEntity()).getOffensiveEquipmentType() + ((OffensiveEquipment) cell.getEntity()).getEmoji());
            System.out.println("You are a " + playerCharacter.getType() + ", you can't equip this gear !" + crossEmoji);
        }
    }

}
