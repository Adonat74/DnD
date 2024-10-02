package character.types;

import character.PlayerCharacter;
import game.board.surpriseBoxLoot.equipment.defensive.Shield;
import game.board.surpriseBoxLoot.equipment.offensive.Weapon;

public class Warrior extends PlayerCharacter {

    public Warrior(String name) {
        super(name);
        this.type = "warrior";
        this.health = 10;
        this.attack = 10;
        this.offensiveEquipment = new Weapon();
        this.defensiveEquipment = new Shield("wood");

    }

}
