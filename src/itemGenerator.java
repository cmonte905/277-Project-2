import java.io.*;
import java.util.*;

public class itemGenerator {
	private ArrayList<Item> itemList = new ArrayList();

	// Constructor, reads from the files
	public itemGenerator() {

		try {
			Scanner read = new Scanner(new File("ItemList1.txt"));
			do {
				read.useDelimiter(",");
				String itemName = read.next();
				System.out.println(itemName);

				String gValue = read.next();
				System.out.println(gValue);
				int value = Integer.parseInt(gValue);
				System.out.println(value);

				// Item i = new Item(itemName, gValue);
				// itemList.add(i);
			} while (read.hasNext());

			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}
	}

	public ArrayList<Item> generateItem() {

		return itemList;
	}

}
