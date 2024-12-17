import java.util.ArrayList;

class Dungeon {
    private boolean isClosed;  
    private char difficulty;   
    private String nature;     
    ArrayList<Monster> monsters = new ArrayList<>();  // List to store monsters in the dungeon
    ArrayList<Adventurer> adventurers = new ArrayList<>();  // List to store adventurers in the dungeon

    
    public Dungeon(char difficulty, String nature) {
        this.isClosed = false;// Initially, the dungeon is open
        this.difficulty = difficulty;
        this.nature = nature;
    }

    
    public boolean isClosed() {
        return isClosed;
    }

    
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    
    public char getDifficulty() {
        return difficulty;
    }

    
    public void setDifficulty(char difficulty) {
        this.difficulty = difficulty;
    }

    
    public String getNature() {
        return nature;
    }

    
    public void setNature(String nature) {
        this.nature = nature;
    }

    
    public void selfDestroy() {
        System.out.println("The dungeon self-destructs!");
        System.out.println("You cleared the dungeon!");
    }

    // Method for the dungeon to attack the adventurer with a trap, dealing damage based on the dungeon's difficulty
    public void attackWithTrap(Adventurer target) {
        int trapDamage = 0;
        // Set the trap damage based on the dungeon's difficulty
        switch (difficulty) {
            case 'B':  // Difficulty B: less damage
                trapDamage = 15;
                break;
            case 'A':  // Difficulty A: medium damage
                trapDamage = 30;
                break;
            case 'S':  // Difficulty S: more damage
                trapDamage = 45;
                break;
        }
        // Inform the player about the trap and apply the damage to the adventurer's health
        System.out.println("The dungeon attacks " + target.getName() + " with a trap dealing " + trapDamage + " damage!\n");
        target.setHp(target.getHp() - trapDamage);  // Reduce adventurer's HP by trapDamage
    }

    // Method to close the dungeon (no more adventurers can enter)
    public void close() {
        System.out.println("The dungeon is now closed. No more adventurers can enter.");
        setClosed(true);  
    }

    // Method to add a monster to the dungeon (only if the dungeon is not closed)
    void addMonster(Monster m) {
        if (!isClosed) {  
            monsters.add(m);
        }
    }

    // Method to remove a monster from the dungeon
    void removeMonster(Monster m) {
        monsters.remove(m);
    }

    // Method to check if a specific monster is in the dungeon
    boolean searchMonster(Monster m) {
        return monsters.contains(m);  // Return true if the monster is in the dungeon, otherwise false
    }

    // Method to modify a monster's attributes (HP, level, name)
    void modifyMonster(Monster m, int hp, float level, String name) {
        // Loop through all monsters in the dungeon
        for (Monster c : monsters) {
            if (c.equals(m)) {  
                c.setHp(hp);  
                c.setLevel(level);  
                c.setName(name);  
            }
        }
    }

    // Method to add an adventurer to the dungeon (only if the dungeon is not closed)
    void addAdventurer(Adventurer m) {
        if (!isClosed) {  // Ensure the dungeon is open before adding an adventurer
            System.out.println(m.getName() + " is now part of the raid team");  // Inform that the adventurer joined
            adventurers.add(m);  // Add the adventurer to the list
        }
    }

    // Method to remove an adventurer from the dungeon
    void removeAdventurer(Adventurer m) {
        System.out.println(m.getName() + " was removed from the raid team");
        adventurers.remove(m);
    }

    // Method to check if a specific adventurer is in the dungeon
    boolean searchAdventurer(Adventurer m) {
        System.out.println(m.getName() + " is part of the raid team");
        return adventurers.contains(m);
    }

    // Method to modify an adventurer's attributes (HP, level, name)
    void modifyAdventurer(Adventurer m, int hp, float level, String name) {
        
        for (Adventurer c : adventurers) {
            if (c.equals(m)) {  
                c.setHp(hp);  
                c.setLevel(level);
                c.setName(name);
            }
        }
    }

}
