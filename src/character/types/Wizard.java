package character.types;

import character.Character;
import character.equipment.defensive.Filter;
import character.equipment.offensive.Spell;

public class Wizard extends Character {
    public Wizard(String name) {
        super(name);
        this.life = 6;
        this.attack = 15;
        this.offensiveEquipment = new Spell("fire ball");
        this.defensiveEquipment = new Filter("filter");
    }

    @Override
    public String toString() {
        return  "TYPE: wizard" + "\n" + super.toString();
    }
}
