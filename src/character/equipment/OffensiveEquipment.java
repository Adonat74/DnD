package character.equipment;

public class OffensiveEquipment {
    private String type;
    private int attackLevel;
    private String name;



    public OffensiveEquipment(String type, String name) {
        this.type = type;
        this.name = name;
        if (type.equals("weapon")){
            this.attackLevel = 10;
        } else if (type.equals("spell")){
            this.attackLevel = 15;
        }
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
