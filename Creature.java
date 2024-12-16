import java.util.Comparator;
import java.util.HashMap;

public class Creature {
    private int hp;  
    HashMap<String, Integer> attacks;  
    private double level;  
    private String name;  

    Creature(String name, int hp, double level, HashMap<String, Integer> attacks) {
        this.name = name;
        this.hp = hp;
        this.attacks = attacks;
        this.level = level;
    }

    
    int getHp() {
        return hp;
    }

    
    double getLevel() {
        return level;
    }

    
    String getName() {
        return name;
    }

    
    void setHp(int hp) {
        this.hp = hp;
    }

    
    void setLevel(double level) {
        this.level = level;
    }

    
    void setName(String name) {
        this.name = name;
    }

    // Method to make the creature attack another creature with a specific attack type
    void attack(Creature c, String attack) {
        if (hp > 0) {  // Check if the creature is alive
            // Decrease the health of the target creature based on attack damage
            c.hp -= ((int) level) * attacks.get(attack); 
            System.out.println(name + " attacks with " + attack); // Output the attack being used
            // Check if the attacked creature is still alive and print the result
            if (c.hp > 0) {
                System.out.println(c.name + "'s remaining hp: " + c.hp);
            } else {
                System.out.println(c.name + "'s hp dropped to 0!");
            }
        }
    }

    // Method for the creature to heal itself, increasing hp
    void heal() {
        if (hp > 0) {  // Creature must be alive to heal
            hp += 30;  // Increase hp by 30
            System.out.println(name + " healed himself!");
            System.out.println(name + "'s new hp: " + hp);
        }
    }

    // Method to check if the creature is dead
    boolean isDead() {
        if (hp <= 0) {  
            System.out.println(name + " Died!");
            return true;
        }
        return false;
    }
}

// Comparator class to compare creatures based on their hp
class CreatureComparator implements Comparator<Creature> {
    @Override
    public int compare(Creature adventurer, Creature monster) {
        // Compare the hp of the two creatures
        int hpDifference = adventurer.getHp() - monster.getHp();

        // Output comparison result based on hp values
        if (hpDifference < 0) {
            System.out.println("The monster hp is more than " + adventurer.getName() + " hp");
        } else if (hpDifference > 0) {
            System.out.println("The monster hp is less than " + adventurer.getName() + " hp");
        } else {
            System.out.println("The monster hp is equal to " + adventurer.getName() + " hp");
        }

        return hpDifference;
    }
}
