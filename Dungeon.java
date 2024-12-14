import java.util.ArrayList;

class Dungeon {
    private boolean isClosed;
    private char difficulty;
    private String nature;
    ArrayList<Monster> monsters = new ArrayList<>();
    ArrayList<Adventurer> adventurers = new ArrayList<>();

    public Dungeon(char difficulty, String nature) {
        this.isClosed = false;
        this.difficulty = difficulty;
        this.nature = nature;
    }

    // Getter and Setter for isClosed
    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    // Getter and Setter for difficulty
    public char getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(char difficulty) {
        this.difficulty = difficulty;
    }

    // Getter and Setter for nature
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

    public void attackWithTrap(Adventurer target) { 
        int trapDamage = 0;
        switch (difficulty) {
            case 'B':
                trapDamage = 15; 
                break;
            case 'A':
                trapDamage = 30;   
                break;
            case 'S':
                trapDamage = 45;
                break;

        }
        System.out.println("The dungeon attacks " + target.getName() + " with a trap dealing " + trapDamage + " damage!");
        target.setHp(target.getHp()  - trapDamage);
        
    }

    public void close() {
        System.out.println("The dungeon is now closed. No more adventurers can enter.");
        setClosed(true);  // Using setter to update isClosed
    }
    void addMonster(Monster m){
        if (!isClosed) {
            monsters.add(m);
        }
    }
    void removeMonster(Monster m){
        monsters.remove(m);
    }
    boolean searchMonster(Monster m){
        return monsters.contains(m);
    }
    void modifyMonster(Monster m, int hp,float level,String name ){
        for (Monster c : monsters) {
            if(c.equals(m)){
                c.setHp(hp);
                c.setLevel(level);
                c.setName(name);
            }
        }
    }
    void addAdventurer(Adventurer m){
        if (!isClosed) {
            System.out.println(m.getName() + " is now part of the raid team");
            adventurers.add(m);
        }
    }
    void removeAdventurer(Adventurer m){
        System.out.println(m.getName() + " was removed from the raid team");
        adventurers.remove(m);
    }
    boolean searchAdventurer(Adventurer m){
        System.out.println(m.getName() + " is part of the raid team");
        return adventurers.contains(m);
    }
    void modifyAdventurer(Adventurer m, int hp,float level,String name ){
        for (Adventurer c : adventurers) {
            if(c.equals(m)){
                c.setHp(hp);
                c.setLevel(level);
                c.setName(name);
            }
        }
    }

}
