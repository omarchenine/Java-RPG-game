import java.util.Comparator;
import java.util.HashMap;

public class Creature{
    private int hp;
    HashMap<String,Integer> attacks;
    private float level;
    private String name;
    Creature(String name,int hp, float level,HashMap<String,Integer> attacks  ){
        this.name = name;
        this.hp = hp;
        this.attacks = attacks;
        this.level = level;
    }
    int getHp(){
        return hp;
    }
    float getLevel(){
        return level;
    }
    String getName(){
        return name;
    }
    void setHp(int hp){
        this.hp = hp;
    }
    void setLevel(float level){
        this.level = level;
    }
    void setName(String name){
        this.name = name;
    }
    void attack(Creature c, String attack){
        if(hp > 0){
        c.hp -= ((int) level) * attacks.get(attack);
        System.out.println(name + " attacks with "+ attack); //for polymorphism in Adventurer add "using" + weapon
        if(c.hp > 0)
            System.out.println(c.name + "'s remaining hp:" + c.hp);
        else
        System.out.println(c.name + "'s hp dropped to 0!");
        }
    }
    void heal(){
        if(hp > 0){
        hp += 30; 
        System.out.println(name + " healed himself!");
        System.out.println(name + "'s new hp:" + hp);
        }
    }
    boolean isDead(){
        if(hp <= 0){
            System.out.println(name + " Died!");
            return true;
        }
        return false;
    }
    

}
class CreatureComparator implements Comparator<Creature>{
    @Override
    public int compare(Creature adventurer, Creature monster){
       int hpDifference = adventurer.getHp() - monster.getHp();
        if (hpDifference < 0) {
            System.out.println("The monster hp is more than "+ adventurer.getName() + " hp");
        } else if( hpDifference > 0) {
            System.out.println("The monster hp is less than "+ adventurer.getName() + " hp");
        }else{
            System.out.println("The monster hp is equal to "+ adventurer.getName() + " hp");
        }
        return hpDifference;
    }
    
}