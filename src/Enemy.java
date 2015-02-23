import java.io.*;
import java.util.*;

public class Enemy extends Character{
	private Item item;
	public Enemy(String n, String q, int h, int l, int g) {
		super(n, q, h, l, g);
		
	}

	public void attack(Character c) {
		
		
	}
	//returns the item that enemy has dropped, my guess anyways
	public Item getItem(){
		return item;
	}

}
