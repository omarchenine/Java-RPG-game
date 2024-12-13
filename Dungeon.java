class Dungeon {
    private boolean isClosed;
    private char difficulty;
    private String nature;

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
        setClosed(true);  // Using setter to update isClosed
    }

    public void attackWithTrap(Creature target) {
        int trapDamage = 15;
        System.out.println("The dungeon attacks " + target.name + " with a trap for " + trapDamage + " damage!");
        target.hp -= trapDamage;
        if (target.hp <= 0) {
            target.die();
        }
    }

    public void close() {
        System.out.println("The dungeon is now closed. No more adventurers can enter.");
        setClosed(true);  // Using setter to update isClosed
    }
}
