import java.awt.*;
import java.util.*;
import java.io.*;

public class Hero extends Character implements Serializable {

	private ArrayList<Item> items = new ArrayList<Item>();

	Point location;

	public Hero(String n, String q, int h, int l, int g, Point s) {
		super(n, q, h, l, g);
		this.location = s;
	}

	@Override
	public void attack(Character c) {
		Random rd = new Random();
		int damage = rd.nextInt(5 * getLevel() + 1);
		System.out.printf("%s hit a %s for %d damage.%n", getName(),
				c.getName(), damage);
		c.takeDamage(damage);
	}

	public Character loadChar() {
		return null;
	}

	public ArrayList<Item> getItems() {
		return items;

	}

	public int getInventory() {
		int inventory = items.size();
		return inventory;
	}

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

	// not too sure what this does, guessing it adds to the character if there
	// is
	// enough room, so check that first
	public boolean pickupItem(Item i) {
		if (items.size() >= 5) {
			return false;
		} else {
			items.add(i);
			return true;
		}

	}

	public void removeItem(int index) {
		items.remove(index);
	}

	public void removeItem(Item i) {
		items.remove(i);
	}

	Point getLocation() {
		return location;
	}

	void setLocation(Point p) {
		this.location = p;
	}

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
