import java.awt.Point;
import java.io.*;
import java.util.*;
public class mainGame {
	
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		mainGame mg = new mainGame();
		mg.loadChar();
		Level l = new Level();
		l.generateLevel(1);
		l.displayMap();
		EnemyGenerator eL = new EnemyGenerator();
		System.out.println(eL.generateEnemy(1).getName());
		Scanner in = new Scanner(System.in);
		System.out.println("Where would you like to move?");
		System.out.println("1: NORTH");
		System.out.println("2: EAST");
		System.out.println("3: SOUTH");
		System.out.println("4: WEST");
		
		try{
			
		}catch(InputMismatchException i){
			
		}
		
		
		
		//itemGenerator ig = new itemGenerator();

		EnemyGenerator eg = new EnemyGenerator();
		//((EnemyGenerator) eg).generateEnemy(1);
		//System.out.println(eg.generateEnemy(1));
		
	}
	public static Character loadChar(){
		Character player = null;
		String name, phrase;
		
		File chardat = new File("character.dat");
		if(chardat.exists()){
			try{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(chardat));
				player = (Hero) in.readObject();
				in.close();
				System.out.println("From your last save \nNAME: "+player.getName()+"\nHEALTH: "+player.getHp()+"\nLEVEL: "+player.getLevel()+"\nGOLD: "+player.getGold());
			}catch(IOException e){
				System.out.println("Can not read file.");
			}catch(ClassNotFoundException e){
				System.out.println("Could not find the class!");
			}
		}
		else{
			System.out.println("No save located!\nCreating a new Character...\nWhat is your name?");
			name = in.nextLine();
			System.out.println("What is your catchphrase?");
			phrase = in.nextLine();
			player = new Hero(name,phrase,25,1,0);//Default values
			try{
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(chardat));
				out.writeObject(player);
				out.close();
			}catch(IOException e){
				System.out.println("Error processing the save.");
			}
		}
		return player;
	}

}
