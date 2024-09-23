package character;

import character.equipment.DefensiveEquipment;
import character.equipment.OffensiveEquipment;

public class Character {
    private int type;
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
    public Character(int type, String name) {
        this.type = type;
        this.name = name;
//      if type is one create a warrior else if 2 create a wizard
        setOtherAttributes();
    }

//    Set attributes when the type is known
    private void setOtherAttributes() {
        if (type==1){
            this.life = 10;
            this.attack = 10;
//          instenciate a defensive and offensive equipment
            this.offensiveEquipment = new OffensiveEquipment("weapon", "sword");
            this.defensiveEquipment = new DefensiveEquipment("shield", "wood");
        } else if (type==2){
            this.life = 6;
            this.attack = 15;
            this.offensiveEquipment = new OffensiveEquipment("spell", "fire ball");
            this.defensiveEquipment = new DefensiveEquipment("filter", "filter");
        }
    }



// print character attributes
    public void printAttributes() {
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("Life: " + life);
        System.out.println("Attack force: " + attack);
        System.out.println("Weapon type: " + offensiveEquipment.getType() + ", Weapon name: " + offensiveEquipment.getName() + ", Weapon attack level: " + offensiveEquipment.getAttackLevel());
        System.out.println("Defense type: " + defensiveEquipment.getType() + ", Defense name: " + defensiveEquipment.getName() + ", Defense level: " + defensiveEquipment.getDefenseLevel());
    }


//    SETTERS
    public void setType(int type) {
        this.type = type;
        setOtherAttributes();
    }
    public void setName(String name) {
        this.name = name;
    }
//    GETTERS
    public int getType() {
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
