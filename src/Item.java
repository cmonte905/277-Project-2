import java.io.Serializable;

/**
 * Class in which the items are handled
 */
public class Item implements Serializable {
	private String name;
	private int goldValue;

	/**
	 * Constructor of items
	 * 
	 * @param n
	 *            Name of item
	 * @param v
	 *            Gold have of item
	 */
	public Item(String n, int v) {
		this.name = n;
		this.goldValue = v;
	}

	/**
	 * Method that returns the name of an item
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method that returns the gold value of an item
	 * 
	 * @return
	 */
	public int getValue() {
		return goldValue;
	}
}
