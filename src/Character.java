import java.io.Serializable;


public abstract class Character implements Serializable {
	private String name;
	private String quip;
	private static int level;
	private int hp;
	private int gold;
	
	public Character(String n, String q, int h, int l, int g){
		this.name = n;
		this.quip = q;
		this.hp = h;
		this.level = l;
		this.gold = g;		
	}
	public abstract void attack(Character c);
	
	public String getName(){
		return name;
	}
	public String getQuip(){
		return quip;
	}
	public int getHp(){
		return hp;
	}
	public int getLevel(){
		return level;
	}
	public int getGold(){
		return gold;
	}	
	public void increaseLevel(){
		
	}
	public void heal(int h){
		
	}
	public void takeDamage(int g){
		
	}
	public void collectGold(int g){
		
	}
	public void display(){
		
	}
}
