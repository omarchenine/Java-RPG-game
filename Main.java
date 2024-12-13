import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        CreatureComparator comp = new CreatureComparator();

        HashMap<String, Integer> heroAttacks = new HashMap<>();
        heroAttacks.put("Slash", 100);
        heroAttacks.put("Thrust", 50);

        HashMap<String, Integer> monsterAttacks = new HashMap<>();
        monsterAttacks.put("Fire breath", 100);
        monsterAttacks.put("Bite", 50);
        Creature hero = new Creature("dragon slayer", 120
        , 1, heroAttacks);
        Creature monster = new Creature("dragon", 100
        , 1, monsterAttacks);

        while (!hero.isDead() && !monster.isDead()) {
            comp.compare(hero, monster);
            monster.attack(hero, "Bite");
            hero.attack(monster, "Thrust");
            monster.heal();

        }

    }
}