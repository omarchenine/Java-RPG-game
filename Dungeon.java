class Dungeon {
    private boolean isClosed;
    private char difficulty;
    private String nature;

    public Dungeon(char difficulty, String nature) {
        this.isClosed = false;
        this.difficulty = difficulty;
        this.nature = nature;
    }

    public void selfDestroy() {
        System.out.println("The dungeon self-destructs!");
        isClosed = true;
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
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }
}