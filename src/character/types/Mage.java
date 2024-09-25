package character.types;

import character.Character;
import character.equipment.defensive.Filter;
import character.equipment.offensive.Spell;

public class Mage extends Character {
    public Mage(String name) {
        super(name);
        this.type = "wizard";
        this.life = 6;
        this.attack = 15;
        this.offensiveEquipment = new Spell("fire ball");
        this.defensiveEquipment = new Filter("filter");
    }

}
