import java.io.*;
import java.util.*;

public class Enemy extends Character{
	private Item item;
	public Enemy(String n, String q, int h, int l, int g, Item i) {
		super(n, q, h, l, g);
		this.item = i;
	}

	public void attack(Character c) {
		
		
	}
	//returns the item that enemy has dropped, my guess anyways
	public Item getItem(){
		EnemyGenerator eg = new EnemyGenerator();
							
		return item;
	}

}
