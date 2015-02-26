import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * Class in which hero/player gets handled such as movement and attacking
 */
public class Hero extends Character implements Serializable {

	private ArrayList<Item> items = new ArrayList<Item>();
	private Point location;

	/**
	 * Constructs the player's character
	 * 
	 * @param n
	 *            Name that user has selected
	 * @param q
	 *            Quip/quote
	 * @param h
	 *            Health points of the player
	 * @param l
	 *            Level of player
	 * @param g
	 *            Gold that player currently has
	 * @param s
	 *            Position that player is currently in on the map
	 */
	public Hero(String n, String q, int h, int l, int g, Point s) {
		super(n, q, h, l, g);
		this.location = s;
	}

	/**
	 * Abstract method of type character. Attack method where the player deals
	 * damage to the enemy
	 */
	@Override
	public void attack(Character c) {
		Random rd = new Random();
		int damage = rd.nextInt(5 * getLevel() + 1);
		System.out.printf("%s hit a %s for %d damage.%n", getName(),
				c.getName(), damage);
		c.takeDamage(damage);
	}

	/**
	 * Creates character in the main
	 * 
	 * @return null
	 */
	public Character loadChar() {
		return null;
	}

	/**
	 * Returns the array list of items
	 * 
	 * @return items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Gets the size of the array list
	 * 
	 * @return inventory
	 */
	public int getInventory() {
		int inventory = items.size();
		return inventory;
	}

	/**
	 * Checks if there is a health potion in the inventory of the player, if so,
	 * then it will return true and the player will be healed up to max, if
	 * there is no potion, then nothing will happen
	 * 
	 * @return boolean true or false
	 */
	public boolean hasPotion() {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals("Health Potion")) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	/**
	 * Method that checks if the player can hold more items, and if so, will be
	 * added to the arraylist of items, if inventory is full then no item will
	 * be added
	 * 
	 * @param i
	 *            Item that is passed in to add if it can be
	 * @return true or false
	 */
	public boolean pickupItem(Item i) {
		if (items.size() >= 5) {
			return false;
		} else {
			items.add(i);
			return true;
		}

	}

	/**
	 * Method that removes an item in the players inventory by index
	 * 
	 * @param index
	 *            Index of the item that will be removed
	 */
	public void removeItem(int index) {
		items.remove(index);
	}

	/**
	 * Method that removes an item in the arraylist of items belonging to hero
	 * 
	 * @param i
	 *            Item that will be removed
	 */
	public void removeItem(Item i) {
		items.remove(i);
	}

	/**
	 * Method that returns the location player
	 * 
	 * @return
	 */
	Point getLocation() {
		return location;
	}

	/**
	 * Method that sets the location of player
	 * 
	 * @param p
	 *            Location of player
	 */
	void setLocation(Point p) {
		this.location = p;
	}

	/**
	 * Method that makes the player go up in the map
	 * 
	 * @param l
	 *            Current level that player is on
	 * @return temp which has the type value of room location
	 */
	char goNorth(Level l) {
		char temp;
		Point loc = new Point((int) location.getX(), (int) location.getY() - 1);
		if ((temp = l.getRoom(loc)) == 'n') {
			return temp;
		} else {
			setLocation(loc);
			return temp;
		}
	}

	/**
	 * Method that makes the player go down in the map
	 * 
	 * @param l
	 *            Current level that player is on
	 * @return temp which has the type value of room location
	 */
	char goSouth(Level l) {
		char temp;
		Point loc = new Point((int) location.getX(), (int) location.getY() + 1);
		if ((temp = l.getRoom(loc)) == 'n') {
			return temp;
		} else {
			setLocation(loc);
			return temp;
		}
	}

	/**
	 * Method that makes the player go right in the map
	 * 
	 * @param l
	 *            Current level that player is on
	 * @return temp which has the type value of room location
	 */
	char goEast(Level l) {
		char temp;
		Point loc = new Point((int) location.getX() + 1, (int) location.getY());
		if ((temp = l.getRoom(loc)) == 'n') {
			return temp;
		} else {
			setLocation(loc);
			return temp;
		}
	}

	/**
	 * Method that makes the player go left in the map
	 * 
	 * @param l
	 *            Current level that player is on
	 * @return temp which has the type value of room location
	 */
	char goWest(Level l) {
		char temp;
		Point loc = new Point((int) location.getX() - 1, (int) location.getY());
		if ((temp = l.getRoom(loc)) == 'n') {
			return temp;
		} else {
			setLocation(loc);
			return temp;
		}

	}

}
