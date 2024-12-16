import java.util.HashMap;

public class Monster extends Creature {

    private String type;
    double rageHp;
    
    public Monster(String name, int hp, float level, HashMap<String, Integer> attacks, String type) {
        super(name, hp, level, attacks);  
        this.type = type;  
        this.rageHp = hp / 4;  
    }

    
    public String getType() {
        return type;
    }

    
    public void setType(String type) {
        this.type = type;
    }
    
    // Method that makes the monster enter a "rage" state if its HP falls below the rage threshold
    public void rage() {
        // If the monster's HP is less than or equal to the rage threshold (rageHp)
        if (this.getHp() <= rageHp) {
            System.out.println("Careful, the monster is now enraged");  // Inform the player the monster is enraged
            this.setLevel(this.getLevel() + 1);  // Increase the monster's level by 1, making it stronger
        }
    }
}
