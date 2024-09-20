package character.defensiveEquipment;

public class DefensiveEquipment {
    String type;
    int defenseLevel;
    String name;

    public DefensiveEquipment(String type, String name) {
        this.type = type;
        this.name = name;
        if (type.equals("shield")){
            this.defenseLevel = 10;
        } else if (type.equals("filter")){
            this.defenseLevel = 15;
        }
    }

    public String getType() {
        return type;
    }
    public int getDefenseLevel() {
        return defenseLevel;
    }
    public String getName() {
        return name;
    }
}
