package character.types;

import character.Character;
import game.board.cell.special.surpriseBoxLoot.equipment.defensive.Shield;
import game.board.cell.special.surpriseBoxLoot.equipment.offensive.Weapon;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.type = "warrior";
        this.health = 10;
        this.attack = 10;
        this.offensiveEquipment = new Weapon("sword");
        this.defensiveEquipment = new Shield("wood");

    }

}
