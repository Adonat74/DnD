package game.board.surpriseBoxLoot.equipment;

public abstract class OffensiveEquipment {
    protected String type;
    protected int attackLevel;
    protected String emoji;


    public OffensiveEquipment() {
    }

//  GETTERS
    public String getOffensiveEquipmentType() {
        return type;
    }
    public int getOffensiveEquipmentAttackLevel() {
        return attackLevel;
    }

    public String getEmoji() {
        return emoji;
    }
}