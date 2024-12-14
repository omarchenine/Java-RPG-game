import java.util.HashMap;

public class Adventurer extends Creature {
    
    private String weapon;

    Adventurer(String name,int hp, float level,HashMap<String,Integer> attacks, String weapon) {
        super(name,hp,level,attacks);
        this.weapon = weapon;
    }
    
	@Override
	void attack(Creature c, String attack){
		if(this.getHp() > 0){
        c.setHp(c.getHp() - ((int) this.getLevel()) * attacks.get(attack));
        System.out.println(this.getName() + " attacks with "+ attack + " using a " + this.weapon);
        if(c.getHp() > 0)
            System.out.println(c.getName() + "'s remaining hp:" + c.getHp());
        else
        System.out.println(c.getName() + "'s hp dropped to 0!");
        }
	}

    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    void levelUp(){
        this.setLevel(this.getLevel() + 0.5);
    }

}
