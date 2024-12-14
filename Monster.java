import java.util.HashMap;

public class Monster extends Creature {

	private String type;
	double rageHp;
	
	public Monster(String name,int hp, float level,HashMap<String,Integer> attacks,String type) {
		super(name,hp,level,attacks);
        this.type = type;
		this.rageHp = hp / 4;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void rage(){
		if(this.getHp() <= rageHp){
			System.out.println("Careful the monster is now enraged");
			this.setLevel(this.getLevel() + 1);
		}
	}
	
}
