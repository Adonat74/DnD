package character;

import game.board.surpriseBoxLoot.equipment.DefensiveEquipment;
import game.board.surpriseBoxLoot.equipment.OffensiveEquipment;

public class PlayerCharacter {
    protected String type;
    protected String name;
    protected int health;
    protected int attack;
    protected OffensiveEquipment offensiveEquipment;
    protected DefensiveEquipment defensiveEquipment;

    public PlayerCharacter() {
    }
//    constructeur appelé dans les classes enfant warrior et wizard
    public PlayerCharacter(String name) {
        this.name = name;
    }
// print character attributes
    @Override
    public String toString() {
        return "Type: " + type + "\n" + "Name: "+ name+"\n"+"Life: " + health+"\n" + "Attack force: " + attack + "\n" + "Weapon type: " + offensiveEquipment.getOffensiveEquipmentType() + ", Weapon attack level: " + offensiveEquipment.getOffensiveEquipmentAttackLevel() + "\n" + "Defense type: " + defensiveEquipment.getType() + ", Defense name: " + defensiveEquipment.getName() + ", Defense level: " + defensiveEquipment.getDefenseLevel();
    }

    //    SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health += health;
    }
    public void setAttack(int attack) {
        this.attack += attack;
    }
    public void setDamageTaken(int damage) {
        this.health -= damage;
    }
//    GETTERS
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public int getAttack() {
        return this.attack;
    }

    public String getType() {
        return type;
    }

    public String getOffensiveEquipment() {
        return offensiveEquipment.getOffensiveEquipmentType();
    }
}
