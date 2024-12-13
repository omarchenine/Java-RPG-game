import java.util.HashMap;
import java.util.Scanner;

public class Adventurer extends Creature {
    
    private String weapon;
    static int kill = 0;
    private HashMap<String, Integer> Abilities;

    public Adventurer() {
        this.weapon = "Sword";
        Abilities = new HashMap<String, Integer>();
        Abilities.put("fireball", 50);
        Abilities.put("magicTrick", 40);
        Abilities.put("powerSmash", 20);
        Abilities.put("stap", 5);
        
        super.hp = 100;
        super.attack = 20;
        super.level = 1;
        super.name = "Hero";
    }

    // Method to choose an ability
    public int chooseAbility() {
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Available abilities:");
        for (String ability : Abilities.keySet()) {
            System.out.println(ability + ": " + Abilities.get(ability));
        }

        
        System.out.print("Choose an ability: ");
        String chosenAbility = scanner.nextLine();

        
        if (Abilities.containsKey(chosenAbility)) {
            
            int abilityValue = Abilities.get(chosenAbility);

            
            Abilities.remove(chosenAbility);

            
            return abilityValue;
        } else {
            System.out.println("Ability not found!");
            return 0;
        }
    }
}
