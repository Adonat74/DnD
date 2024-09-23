package character;

import character.equipment.DefensiveEquipment;
import character.equipment.OffensiveEquipment;

public class Character {
    protected String name;
    protected int life;
    protected int attack;
    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    public Character() {
    }
//    constructeur appelé dans les classes enfant warrior et wizard
    public Character(String name) {
        this.name = name;
    }



// print character attributes
    @Override
    public String toString() {
        return "NAME: "+ name+"\n"+"LIFE: " + life+"\n" + "Attack force: " + attack + "\n" + "Weapon type: " + offensiveEquipment.getType() + ", Weapon name: " + offensiveEquipment.getName() + ", Weapon attack level: " + offensiveEquipment.getAttackLevel() + "\n" + "Defense type: " + defensiveEquipment.getType() + ", Defense name: " + defensiveEquipment.getName() + ", Defense level: " + defensiveEquipment.getDefenseLevel();
    }

    //    SETTERS
    public void setName(String name) {
        this.name = name;
    }
//    GETTERS
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
