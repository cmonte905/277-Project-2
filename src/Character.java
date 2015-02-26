import java.io.Serializable;

/**
 * Abstract class, super class for Enemy and Player
 * 
 */
public abstract class Character implements Serializable {
	private String name;
	private String quip;
	private int level;
	private int hp;
	private int gold;

	/**
	 * Constructor for characters
	 * 
	 * @param n
	 *            Name of character
	 * @param q
	 *            Quote/quips of character
	 * @param h
	 *            Health points of characters
	 * @param l
	 *            Level of character
	 * @param g
	 *            Gold of character
	 */
	public Character(String n, String q, int h, int l, int g) {
		this.name = n;
		this.quip = q;
		this.hp = h;
		this.level = l;
		this.gold = g;
	}

	/**
	 * Attack function of enemies and Player
	 * 
	 * @param c
	 *            Character target
	 */
	public abstract void attack(Character c);

	/**
	 * Method that returns the name of character
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the characters quip
	 * 
	 * @return quip
	 */
	public String getQuip() {
		return quip;
	}

	/**
	 * Gets the current health of the character
	 * 
	 * @return Health points
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Gets the current level of character
	 * 
	 * @return Level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Gets the amount of gold the character has
	 * 
	 * @return
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Increases the level of the player
	 */
	public void increaseLevel() {
		level++;
	}

	/**
	 * Increases the health of characters
	 * 
	 * @param h
	 *            How much player will be healed for
	 */
	public void heal(int h) {
		hp += h;
	}

	/**
	 * Decreases the health points of character
	 * 
	 * @param h
	 *            Damage taken
	 */
	public void takeDamage(int h) {
		hp -= h;
	}

	/**
	 * Adds gold to the players total gold count
	 * 
	 * @param g
	 *            Gold dropped by enemies
	 */
	public void collectGold(int g) {
		gold += g;
	}

	/**
	 * Displays the status of the player
	 */
	public void display() {
		System.out.println("Name: " + name + "\nHealth Points: " + hp
				+ " \nLevel: " + level + "\nGold: " + gold);
	}
}
