public class Character {
    String type;
    String name;
    int life;
    int attack;
    String weapon;
    String defense;

    public Character(String type, String name) {
        type = type.toLowerCase();
        name = name;

        if (type.equals("warrior")){
            life = 10;
            attack = 10;
            weapon = "sword";
            defense = "shield";
        } else if (type.equals("wizard")){
            life = 6;
            attack = 15;
            weapon = "spell";
            defense = "filter";
        }
    }
}
