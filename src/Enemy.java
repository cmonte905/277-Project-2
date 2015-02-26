import java.io.*;
import java.util.*;

/**
 * Enemy class. Methods that deal with the enemies will be here
 */
public class Enemy extends Character {
	/**
	 * Item that enemies carry on them
	 */
	private Item item;

	/**
	 * Constructs Enemy
	 * 
	 * @param n
	 *            Name of enemy
	 * @param q
	 *            quip/quote
	 * @param h
	 *            health points of enemy
	 * @param l
	 *            level of enemy
	 * @param g
	 *            Gold that enemy is carrying
	 * @param i
	 *            Item that will be dropped if enemy is slain
	 */
	public Enemy(String n, String q, int h, int l, int g, Item i) {
		super(n, q, h, l, g);
		this.item = i;
	}

	/**
	 * Abstract method of type character. Attack method where enemy deals damage
	 * to the player
	 */
	@Override
	public void attack(Character c) {
		Random rand = new Random();
		int damage = rand.nextInt(5 * c.getLevel() + 1);
		System.out.printf("%s hit a %s for %d damage.%n", getName(),
				c.getName(), damage);
		c.takeDamage(damage);
	}

	/**
	 * Returns the item that the enemy is carrying
	 * 
	 * @return Item
	 */
	public Item getItem() {
		return item;
	}
}
