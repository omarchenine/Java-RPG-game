import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        CreatureComparator comp = new CreatureComparator();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        Dungeon abyssDungeon = new Dungeon('A', "water");
        Dungeon hiddenRuinesDungeon = new Dungeon('S', "fire");


        HashMap<String, Integer> tankAttacks = new HashMap<>();
        tankAttacks.put("basic attack", 40);
        tankAttacks.put("Titan's Slam", 50);
        tankAttacks.put("Meteor Crash", 50);

        HashMap<String, Integer> mageAttacks = new HashMap<>();
        mageAttacks.put("basic attack", 50);
        mageAttacks.put("fire ball", 60);
        mageAttacks.put("chidori", 60);

        //selection of role and name

        System.out.println("Choose a role: \n1 - Tank\n2 - Mage");
        int role = scanner.nextInt();

        System.out.println("Choose a name: ");
        String name = scanner.next();

        Adventurer hero;
        if (role == 1) {
            hero = new Adventurer(name, 350, 1, tankAttacks, "Shield");
        } else if (role == 2) {
            hero = new Adventurer(name, 275, 1, mageAttacks, "Magic stick");
        } else {
            System.out.println("Invalid choice. Exiting game.");
            return;
        }
        
        //intro
        System.out.println("\nI salute you Mr."+ hero.getName() + " The great adventurer,"
        +" we need your help in clearing the abyss Dungeon of difficulty class "+ abyssDungeon.getDifficulty() 
        + " and the hidden runes Dungon of difficulty class "+ hiddenRuinesDungeon.getDifficulty()
        +", these two dungeons can cause chaos in our continent if the dungeon monsters escape "
        + ", only you can do this impossible mission , the future of the kingdom depends on you. Good luck!");
        
        //create monsters and their attacks and add them to dungeon
        HashMap<String, Integer> slimeAttacks = new HashMap<>();
        slimeAttacks.put("basic attack", 10);
        slimeAttacks.put("Water Splash", 10);

        Monster slime = new Monster("Slime", 55, 1, slimeAttacks, "water");
        
        HashMap<String, Integer> orkAttacks = new HashMap<>();
        orkAttacks.put("1TON fist", 50);
        orkAttacks.put("Headbutt", 30);

        Monster ork = new Monster("ork", 120, 1, orkAttacks, "earth");

        HashMap<String, Integer> goblinAttacks = new HashMap<>();
        goblinAttacks.put("basic attack", 20);
        goblinAttacks.put("Dagger slash", 30);

        Monster goblin = new Monster("Goblin", 100, 1, goblinAttacks, "nature");

        HashMap<String, Integer> dragonAttacks = new HashMap<>();
        dragonAttacks.put("Fire breath", 100);
        dragonAttacks.put("Bite", 70);

        Monster dragon = new Monster("Dragon", 225, 2, dragonAttacks, "Fire");

        abyssDungeon.addMonster(slime);
        abyssDungeon.addMonster(ork);

        hiddenRuinesDungeon.addMonster(goblin);
        hiddenRuinesDungeon.addMonster(dragon);
       
        abyssDungeon.addAdventurer(hero);


        System.out.println("\nYou entered the Abyss dungeon!");

        abyssDungeon.close();

        for (Monster monster : abyssDungeon.monsters) {
            System.out.println("\nYou encountered a "+ monster.getName() + " in the dungeon!");
        while (!hero.isDead() && !monster.isDead()) {
            System.out.println("\nYour Turn! Choose an action:");
            System.out.println("1 - Attack\n2 - Heal");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                
                System.out.println("Choose your attack(case sensetive):");
                for (String attack : hero.attacks.keySet()) {
                    System.out.println("- " + attack);
                }
                
                String attack = scanner.nextLine();
                if (hero.attacks.containsKey(attack)) {
                    hero.attack(monster, attack);
                } else {
                    hero.attack(monster, "basic attack");
                }
            } else if (choice == 2) {    
                hero.heal();
            } else {
                System.out.println("Invalid choice! The enemy attacks!");
            }
            if(monster.getHp() > 0)
            System.out.println("\nmonster's Turn!");
            String[] attackNames = monster.attacks.keySet().toArray(new String[0]);
            int monsterAction = random.nextInt(3);
            if (monsterAction < 2) {
                monster.attack(hero, attackNames[monsterAction] );
            } else {
                monster.heal();
            }
            
            if (random.nextInt(10) < 3) {
                System.out.println("Oh no you were attacked by a trap!");
                abyssDungeon.attackWithTrap(hero);
            }
            
            if (hero.isDead()) {
                System.out.println("\nYou were defeated by the Monster. Game Over.");
                return;
            }
            if(monster.getHp() > 0)
                comp.compare(hero, monster);
          }
          System.out.println("\nCongratulations! You defeated the monster!");
          if(monster.getName() == "ork"){
            hero.levelUp();
            hero.levelUp();
          }else{
            hero.levelUp();
          }
        }
        System.out.println("\nCongratulations you cleared the abyss dungeon!!");

        System.out.println("\nNow only one dungeon remaining!!");
        hiddenRuinesDungeon.addAdventurer(hero);

        System.out.println("\nYou entered the hidden ruines dungeon!");

        hiddenRuinesDungeon.close();

        for (Monster monster : hiddenRuinesDungeon.monsters) {
            System.out.println("\nYou encountered a "+ monster.getName() + " in the dungeon!");
        while (!hero.isDead() && !monster.isDead()) {
            System.out.println("\nYour Turn! Choose an action:");
            System.out.println("1 - Attack\n2 - Heal");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                
                System.out.println("Choose your attack(case sensetive):");
                for (String attack : hero.attacks.keySet()) {
                    System.out.println("- " + attack);
                }
                
                String attack = scanner.nextLine();
                if (hero.attacks.containsKey(attack)) {
                    hero.attack(monster, attack);
                } else {
                    hero.attack(monster, "basic attack");
                }
            } else if (choice == 2) {    
                hero.heal();
            } else {
                System.out.println("Invalid choice! The enemy attacks!");
            }
            if(monster.getHp() > 0)
            System.out.println("\nmonster's Turn!");
            String[] attackNames = monster.attacks.keySet().toArray(new String[0]);
            int monsterAction = random.nextInt(3);
            if (monsterAction < 2) {
                monster.attack(hero, attackNames[monsterAction] );
            } else {
                monster.heal();
            }
            
            if (random.nextInt(10) < 3) {
                System.out.println("Oh no you were attacked by a trap!");
                hiddenRuinesDungeon.attackWithTrap(hero);
            }
            
            if (hero.isDead()) {
                System.out.println("\nYou were defeated by the Monster. Game Over.");
                return;
            }
            if(monster.getHp() > 0)
                comp.compare(hero, monster);
          }
          System.out.println("\nCongratulations! You defeated the monster!");
          if(monster.getName() == "Dragon"){
            hero.levelUp();
            hero.levelUp();
            hero.levelUp();
          }else{
            hero.levelUp();
            hero.levelUp();
          }
        }
        System.out.println("\nCongratulations you cleared the hidden Ruines dungeon!!");

        scanner.close();
        System.out.println("\nThank you for Saving our Kingdom Hero!");
    }
}
