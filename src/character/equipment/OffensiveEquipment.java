package character.equipment;

public class OffensiveEquipment {
    protected String type;
    protected int attackLevel;
    protected String name;


    public OffensiveEquipment(String name) {
        this.name = name;
    }

//  GETTERS
    public String getType() {
        return type;
    }
    public int getAttackLevel() {
        return attackLevel;
    }
    public String getName() {
        return name;
    }

}
