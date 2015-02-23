import java.io.*;
import java.util.*;

public class itemGenerator {
	private ArrayList<Item> itemList = new ArrayList();

	// Constructor, reads from the files
	public itemGenerator() {

		try {
			Scanner read = new Scanner(new File("ItemList.txt"));			
			while (read.hasNext()){
				String[] item = read.nextLine().split(",");
						
				Item i = new Item(item[0],Integer.parseInt(item[1]));
				itemList.add(i);
			} 
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}
	}

	public Item generateItem() {
		Random rand = new Random();
 		int randItem = rand.nextInt(itemList.size());
 		return (Item)itemList.get(randItem);
	}

}
