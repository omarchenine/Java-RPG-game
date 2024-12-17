import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Setup dungeons with respective difficulty and environment
        Dungeon abyssDungeon = new Dungeon('A', "water");
        Dungeon hiddenRuinesDungeon = new Dungeon('S', "fire");

        // Setup attacks for the Tank and Mage roles
        HashMap<String, Integer> tankAttacks = new HashMap<>();
        tankAttacks.put("basic attack", 40);
        tankAttacks.put("Titan's Slam", 50);
        tankAttacks.put("Meteor Crash", 50);

        HashMap<String, Integer> mageAttacks = new HashMap<>();
        mageAttacks.put("basic attack", 50);
        mageAttacks.put("fire ball", 60);
        mageAttacks.put("chidori", 60);

        try{
            // Role selection for the hero
            System.out.println("Choose a role: \n1 - Tank\n2 - Mage");
            int role = scanner.nextInt();

            System.out.println("Choose a name: ");
            String name = scanner.next();

            // Create hero based on role
            Adventurer hero;
            if (role == 1) {
                hero = new Adventurer(name, 120, 1, tankAttacks, "Shield");
            } else if (role == 2) {
                hero = new Adventurer(name, 275, 1, mageAttacks, "Magic stick");
            } else {
                System.out.println("Invalid choice. Exiting game.");
                scanner.close();
                return;
            }
            // Print introduction and game objectives
            System.out.println("\nI salute you Mr."+ hero.getName() + " The great adventurer,"
            +" we need your help in clearing the abyss Dungeon of difficulty class "+ abyssDungeon.getDifficulty() 
            + " and the hidden runes Dungon of difficulty class "+ hiddenRuinesDungeon.getDifficulty()
            +", these two dungeons can cause chaos in our continent if the dungeon monsters escape "
            + ", only you can do this impossible mission , the future of the kingdom depends on you. Good luck!\n");
            
            HashMap<String, Integer> slimeAttacks = new HashMap<>();
            slimeAttacks.put("basic attack", 10);
            slimeAttacks.put("Water Splash", 10);

            // Setup monsters and their attacks
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

            // Add monsters to the respective dungeons
            abyssDungeon.addMonster(slime);
            abyssDungeon.addMonster(ork);

            hiddenRuinesDungeon.addMonster(goblin);
            hiddenRuinesDungeon.addMonster(dragon);

            // Add hero to the first dungeon
            abyssDungeon.addAdventurer(hero);
            System.out.println("\nYou entered the Abyss dungeon!");
            abyssDungeon.close();

            // Play the first dungeon
            boolean survivedAbyssDungeon = play(abyssDungeon, hero,scanner);
            if (!survivedAbyssDungeon) {
                scanner.close();  // Ensure scanner is closed if the hero dies
                return;  // Exit the game if the hero died in the first dungeon
            }

            System.out.println("\nCongratulations you cleared the abyss dungeon!!");
            System.out.println("\nNow only one dungeon remaining!!");
            hiddenRuinesDungeon.addAdventurer(hero);// Add hero to the second dungeon

            System.out.println("\nYou entered the hidden ruines dungeon!");
            hiddenRuinesDungeon.close();
            boolean survivedHiddenRuinsDungeon = play(hiddenRuinesDungeon, hero,scanner);// Play the second dungeon
            if (!survivedHiddenRuinsDungeon) {
                scanner.close();  // Ensure scanner is closed if the hero dies in the second dungeon
                return;  // Exit the game if the hero died in the second dungeon
            }
             // If the hero survives both dungeons, print the final success message
            System.out.println("\nCongratulations you cleared the hidden Ruines dungeon!!");
            System.out.println("\nThank you for Saving our Kingdom Hero!");
            scanner.close();

        }catch(Exception e){
            // Handle any unexpected exceptions and display the error
            System.out.println("An error occurred: " + e.getMessage());
        }
        finally{
            // Close the scanner in the finally block to ensure it's always closed, even if an exception occurs
            if(scanner!= null)
                scanner.close();
        }
    }

    public static boolean play(Dungeon dungeonMonsters, Adventurer hero,Scanner scanner){
        CreatureComparator comp = new CreatureComparator();
        Random random = new Random();
        for (Monster monster : dungeonMonsters.monsters){
            System.out.println("\nYou encountered a "+ monster.getName() + " in the dungeon!");
            try{
                // Check if the hero is dead; if so, print "Game Over" and exit the dungeon
                while (!hero.isDead() && !monster.isDead()) {

                    System.out.println("\nYour Turn! Choose an action:");
                    System.out.println("1 - Attack\n2 - Heal");
        
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    // Handle player's choice of action
                    if (choice == 1) {
                        System.out.println("Choose your attack(case sensetive):");
                        // Display all available attacks for the hero
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
                    // Monster's turn (if still alive)
                    if(monster.getHp() > 0){
                        System.out.println("\nmonster's Turn!");
                        String[] attackNames = monster.attacks.keySet().toArray(new String[0]);
                        int monsterAction = random.nextInt(3);// Randomly choose attack or heal for monster(66% to attack, 33% to heal)

                        if (monsterAction < 2) {
                            monster.attack(hero, attackNames[monsterAction] );
                        }else{
                            monster.heal();
                        }
                    }
                    
                    // Random trap event (30% chance)
                    if (random.nextInt(10) < 3) {
                        System.out.println("\nOh no you were attacked by a trap!");
                        dungeonMonsters.attackWithTrap(hero);
                    }
                    
                    if (hero.isDead()) {
                        System.out.println("\nYou were defeated by the Monster. Game Over.");
                        return false;
                    }
                    if(monster.getHp() > 0)
                        comp.compare(hero, monster);
                }
                System.out.println("\nCongratulations! You defeated the monster!");
                // if the hero defeat a monster, levelup
                if(monster.getName() == "ork" || monster.getName() == "Dragon"){
                    hero.levelUp();
                    hero.levelUp();
                }else{
                    hero.levelUp();
                }
            }catch(Exception e){
                System.out.println("An error occurred: " + e.getMessage());
            }  
        }
        return true;// Hero survived the dungeon, return true
    }
}