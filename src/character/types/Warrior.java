package character.types;

import character.Character;
import character.equipment.defensive.Shield;
import character.equipment.offensive.Weapon;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.type = "warrior";
        this.life = 10;
        this.attack = 10;
        this.offensiveEquipment = new Weapon("sword");
        this.defensiveEquipment = new Shield("wood");

    }

}
