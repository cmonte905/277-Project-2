import java.util.*;
import java.io.*;

public class EnemyGenerator {
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<String[]> e = new ArrayList<String[]>();

	public EnemyGenerator() {

		Random rand = new Random();
		try {
			Scanner read = new Scanner(new File("EnemyList.txt"));
			while (read.hasNext()) {
				itemGenerator items = new itemGenerator();
				int eGold = rand.nextInt(10) + 1;
				e.add(read.nextLine().split(","));
				
				// Enemy eGenerator = new Enemy(name, eQuip,
				// Integer.parseInt(eHP), 1, eGold, items.generateItem());
				// enemyList.add(eGenerator);

			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file was found");
		}

	}

	public Enemy generateEnemy(int level) {
		Random rand = new Random();
		itemGenerator items = new itemGenerator();
		int index = rand.nextInt(e.size());

		  Enemy en = new Enemy(e.get(index)[0], e.get(index)[1], Integer.parseInt(e
				.get(index)[2]), 1 * level, rand.nextInt(10 + 1),
				items.generateItem());
		  
		  return en;
		// return enemyList.get(index);
		// return (Item)itemList.get(randItem);
		// return (Enemy)enemyList.get(index);
	}
}
