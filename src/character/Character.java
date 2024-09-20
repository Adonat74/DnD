package character;

import character.defensiveEquipment.DefensiveEquipment;
import character.offensiveEquipment.OffensiveEquipment;

public class Character {
    private String type;
    private String name;
    private int life;
    private int attack;
    private OffensiveEquipment offensiveEquipment;
    private DefensiveEquipment defensiveEquipment;

    public Character() {
    }
    public Character(String name) {
        this.name = name;
    }
    public Character(String type, String name) {
        this.type = type.toLowerCase();
        this.name = name;

        if (type.equals("warrior")){
            this.life = 10;
            this.attack = 10;
            this.offensiveEquipment = new OffensiveEquipment("weapon", "sword");
            this.defensiveEquipment = new DefensiveEquipment("shield", "wood");
        } else if (type.equals("wizard")){
            this.life = 6;
            this.attack = 15;
            this.offensiveEquipment = new OffensiveEquipment("spell", "fire ball");
            this.defensiveEquipment = new DefensiveEquipment("filter", "filter");
        }
    }

    public void printAttributes() {
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("Life: " + life);
        System.out.println("Attack force: " + attack);
        System.out.println("Weapon type: " + offensiveEquipment.getType() + ", Weapon name: " + offensiveEquipment.getName() + ", Weapon attack level: " + offensiveEquipment.getAttackLevel());
        System.out.println("Defense type: " + defensiveEquipment.getType() + ", Defense name: " + defensiveEquipment.getName() + ", Defense level: " + defensiveEquipment.getDefenseLevel());
    }
    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getLife() {
        return this.life;
    }

    public int getAttack() {
        return this.attack;
    }
}