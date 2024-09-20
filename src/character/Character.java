package character;

import character.defensiveEquipment.DefensiveEquipment;
import character.offensiveEquipment.OffensiveEquipment;

public class Character {
    String type;
    String name;
    int life;
    int attack;

    public Character() {


    }
    public Character(String name) {
        this.name = name;
    }

    public Character(String type, String name) {
        this.type = type.toLowerCase();
        this.name = name;

        if (type.equals("warrior")){
            life = 10;
            attack = 10;
            OffensiveEquipment offensiveEquipment = new OffensiveEquipment("weapon", "sword");
            DefensiveEquipment defensiveEquipment = new DefensiveEquipment("shield", "wood");
        } else if (type.equals("wizard")){
            life = 6;
            attack = 15;
            OffensiveEquipment offensiveEquipment = new OffensiveEquipment("spell", "fire ball");
            DefensiveEquipment defensiveEquipment = new DefensiveEquipment("filter", "defense filter");
        }
    }
}
