import java.io.*;
import java.util.*;

public class Enemy extends Character {
	private Item item;

	public Enemy(String n, String q, int h, int l, int g, Item i) {
		super(n, q, h, l, g);
		this.item = i;
	}
	@Override
	public void attack(Character c) {
		Random rand = new Random();
		int damage = rand.nextInt(5 * c.getLevel()+1);
		System.out.printf("%s hit a %s for %d damage.%n",getName(),c.getName(),damage);
		c.takeDamage(damage);
	}


	public Item getItem() {
		return item;
	}
}
