import java.io.*;
import java.util.*;

/**
 * Class that handles the generation of items. Reads from a file which has all
 * of the items listed out. The items in the file get generated into the game in
 * this class
 */
public class itemGenerator {
	private ArrayList<Item> itemList = new ArrayList();

	/**
	 * Constructor that reads from the item list text file and places items into
	 * an arraylist
	 */
	public itemGenerator() {

		try {
			Scanner read = new Scanner(new File("ItemList.txt"));
			while (read.hasNext()) {
				String[] item = read.nextLine().split(",");

				Item i = new Item(item[0], Integer.parseInt(item[1]));
				itemList.add(i);
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}
	}

	/**
	 * Method that returns a random item from the item arraylist
	 * 
	 * @return
	 */
	public Item generateItem() {
		Random rand = new Random();
		int randItem = rand.nextInt(itemList.size());
		return (Item) itemList.get(randItem);
	}

}
