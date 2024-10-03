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
        if (enemy instanceof Dragon && this instanceof Bow) {
            this.bonusDamage=2;
            System.out.println("It's a dragon your Bow makes more damage!");
        } else if (enemy instanceof Ghost && this instanceof Invisibility){
            this.bonusDamage=3;
            System.out.println("It's a Ghost your Invisibility makes more damage!");
        } else {
            bonusDamage=0;
        }
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
