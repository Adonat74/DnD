package game.board.surpriseBoxLoot.equipment;

import game.board.enemy.Enemy;
import game.board.enemy.enemies.Dragon;
import game.board.enemy.enemies.Ghost;
import game.board.surpriseBoxLoot.equipment.offensive.spells.Invisibility;
import game.board.surpriseBoxLoot.equipment.offensive.weapons.Bow;

public abstract class OffensiveEquipment {
    protected String type;
    protected int attackLevel;
    protected int bonusDamage;
    protected String emoji;


    public OffensiveEquipment() {
    }
//    Verify the enemy type and the equipment type so that attack increase against these enemies
    public void isAgainstSpecialEnemy(Enemy enemy) {
            bonusDamage=0;
    }

//  GETTERS
    public String getOffensiveEquipmentType() {
        return type;
    }
    public int getOffensiveEquipmentAttackLevel() {
        return attackLevel+bonusDamage;
    }

    public String getEmoji() {
        return emoji;
    }
}
