import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        CreatureComparator comp = new CreatureComparator();

        Dungeon abyssDungeon = new Dungeon('A', "water");
        Dungeon hiddenRuinesDungeon = new Dungeon('S', "fire");

        HashMap<String, Integer> tankAttacks = new HashMap<>();
        tankAttacks.put("basic attack", 40);
        tankAttacks.put("Titan's Slam", 100);
        tankAttacks.put("Meteor Crash", 50);

        HashMap<String, Integer> mageAttacks = new HashMap<>();
        mageAttacks.put("basic attack", 40);
        mageAttacks.put("fire ball", 100);
        mageAttacks.put("chidori", 50);

        HashMap<String, Integer> dragonAttacks = new HashMap<>();
        dragonAttacks.put("Fire breath", 100);
        dragonAttacks.put("Bite", 50);
        
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        if(type.charAt(0) == 'c'){}
        System.out.println("Choose a role ");
        

        Creature tank = new Adventurer(, 250, 1, tankAttacks, "Shield");

        Creature mage = new Adventurer(, 250, 1, mageAttacks, "Magic stick");

        Creature dragon = new Monster("dragon", 100
        , 5, dragonAttacks, "fire");

        while (!hero.isDead() && !dragon.isDead()) {
            comp.compare(hero, dragon);
            dragon.attack(hero, "Bite");
            hero.attack(dragon, "Thrust");
            dragon.heal();

        }

    }
}