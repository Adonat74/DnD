package game.board.surpriseBoxLoot.equipment;

public class DefensiveEquipment {
    protected String type;
    protected int defenseLevel;
    protected String name;

    public DefensiveEquipment(String name) {
        this.name = name;
    }
//   GETTERS
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
