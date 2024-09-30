package character.types;

import character.PlayerCharacter;
import game.board.cell.special.surpriseBoxLoot.equipment.defensive.Filter;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Spell;

public class Mage extends PlayerCharacter {
    public Mage(String name) {
        super(name);
        this.type = "mage";
        this.health = 6;
        this.attack = 15;
        this.offensiveEquipment = new Spell("fire ball");
        this.defensiveEquipment = new Filter("filter");
    }

}
