import java.util.HashMap;

public class Adventurer extends Creature {
    
    private String weapon;

    Adventurer(String name, int hp, float level, HashMap<String, Integer> attacks, String weapon) {
        super(name, hp, level, attacks);  // Call the superclass (Creature) constructor
        this.weapon = weapon;
    }
    
    // Override the attack method from the Creature class to define how the adventurer attacks
    @Override
    void attack(Creature c, String attack) {
        if (this.getHp() > 0) {  // Check if the adventurer is still alive
            // Perform the attack on the creature 'c' and reduce its HP based on the adventurer's level and attack power
            c.setHp(c.getHp() - ((int) this.getLevel()) * attacks.get(attack));  
            // Print the attack details (which attack was used and the weapon)
            System.out.println(this.getName() + " attacks with " + attack + " using a " + this.weapon + "\n");  
            if (c.getHp() > 0) {  // If the monster is still alive after the attack
                System.out.println(c.getName() + "'s remaining hp: " + c.getHp());  // Print the monster's remaining HP
            } else {
                System.out.println(c.getName() + "'s hp dropped to 0!");  // If the monster's HP is 0 or below, it's dead
            }
        }
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    // Method to level up the adventurer, increasing their level by 0.5
    void levelUp() {
        this.setLevel(this.getLevel() + 0.5);  // Increase the level by 0.5
    }

}
