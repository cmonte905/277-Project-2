import java.util.*;
import java.io.*;

/**
 * Class that generates the enemies needed for the game
 */
public class EnemyGenerator {
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<String[]> e = new ArrayList<String[]>();

	/**
	 * Constructor that constructs the enemies coming from the enemy list text
	 * file
	 */
	public EnemyGenerator() {

		Random rand = new Random();
		try {
			Scanner read = new Scanner(new File("EnemyList.txt"));
			while (read.hasNext()) {
				e.add(read.nextLine().split(","));
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file was found");
		}

	}

	/**
	 * Method that returns a random enemy from the arraylist of enemies that
	 * were constructed. They are given random gold drops and and their level
	 * depends on the level of the player
	 * 
	 * @param level
	 * @return a constructed enemy
	 */
	public Enemy generateEnemy(int level) {
		Random rand = new Random();
		itemGenerator items = new itemGenerator();
		int index = rand.nextInt(e.size());

		Enemy en = new Enemy(e.get(index)[0], e.get(index)[1],
				Integer.parseInt(e.get(index)[2]), 1 * level,
				rand.nextInt(10 + 1), items.generateItem());

		return en;
		// return enemyList.get(index);
		// return (Item)itemList.get(randItem);
		// return (Enemy)enemyList.get(index);
	}
}
