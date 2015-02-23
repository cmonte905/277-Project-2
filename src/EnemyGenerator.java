import java.util.*;
import java.io.*;

public class EnemyGenerator {
	static ArrayList<Enemy> enemyList;
	//ArrayList<String[]> e = new ArrayList<String[]>();
	public EnemyGenerator() {
		
		
	}

	public Enemy generateEnemy(int level) {
		Random rand = new Random();
		int eGold = rand.nextInt(10) + 1;
		
		
		try {
			Scanner read = new Scanner(new File("EnemyList1.txt"));
			while (read.hasNext()) {				

				read.useDelimiter(",");
				String name = read.next();
				String eQuip = read.next();
				String eHP = read.next().trim();
				int enemyHp = Integer.parseInt(eHP);
				
				Character eGenerator = new Enemy(name, eQuip, enemyHp*level,level,eGold);
				enemyList.add((Enemy)eGenerator);
				
				
			}
			System.out.println(enemyList.get(0).getName()+" "+enemyList.get(0).getLevel()+" "+enemyList.get(0).getHp());//TEST
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file was found");
		}
		int index = rand.nextInt(enemyList.size());
		
		return enemyList.get(index);
	}
}
