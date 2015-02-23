import java.util.*;
import java.io.*;

public class EnemyGenerator {
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<String[]> e = new ArrayList<String[]>();

	public EnemyGenerator() {

		Random rand = new Random();
		try {
			Scanner read = new Scanner(new File("EnemyList1.txt"));
			while (read.hasNext()) {
				itemGenerator items = new itemGenerator();
				int eGold = rand.nextInt(10) + 1;				
				//String[] enemyInput = read.nextLine().split(",");
				
				
				read.useDelimiter(",");
				String name = read.next();
				String eQuip = read.next();
				String eHP = read.next().trim();
				 
				
				

				Enemy eGenerator = new Enemy(name, eQuip, Integer.parseInt(eHP), 1, eGold, items.generateItem());
				enemyList.add(eGenerator);

			}			
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file was found");
		}

	}

	public Enemy generateEnemy(int level) {
		Random rand = new Random();	
		int index = rand.nextInt(enemyList.size());
		itemGenerator items = new itemGenerator();
		
		//return enemyList.get(index);
		//return (Item)itemList.get(randItem);
		return (Enemy)enemyList.get(index);
	}
}
