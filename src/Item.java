import java.io.Serializable;


public class Item implements Serializable{
	private String name;
	private int goldValue;
	
	public Item(String n, int v){
		this.name = n;
		this.goldValue =v;
	}
	
	public String getName(){
		return name;
	}
	
	public int getValue(){
		return goldValue;
	}
}
