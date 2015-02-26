import java.awt.Point;
import java.io.*;
import java.util.*;

public class mainGame {
	private static File characterDat = new File("character.dat");
	private static int x;
	private static int y;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		boolean gameState = true;
		Scanner in = new Scanner(System.in);
		mainGame mg = new mainGame();
		Point p = null;
		x = 0;
		y = 3;
		Level l = null;
		Hero hero = null;
		if (characterDat.exists()) {
			try {
				ObjectInputStream intoFile = new ObjectInputStream(
						new FileInputStream(characterDat));
				hero = (Hero) intoFile.readObject();
				intoFile.close();
				/*System.out.println("TESTLINE PLEASE IGNORE\nNAME: "
						+ player.getName() + "\nHEALTH: " + player.getHp()
						+ "\nLEVEL: " + player.getLevel() + "\nGOLD: "
						+ player.getGold());*/
			} catch (IOException e) {
				System.out.println("Can not read file. [character]");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not find the class!");
			}
			l = new Level();
			l.generateLevel(hero.getLevel());
		}
		else{
			System.out.println("What is your name hero?");
			String name = in.next();
			l = new Level();
			hero = new Hero(name, "meh", 20, 1, 0, p);
			l.generateLevel(1);
		}
		
		

		

		hero.setLocation(l.findStartLocation());
		l.displayMap(hero.getLocation());

		while (gameState) {
			System.out.println("Where would you like to move?");
			System.out.println("1: NORTH");
			System.out.println("2: EAST");
			System.out.println("3: SOUTH");
			System.out.println("4: WEST");
			System.out.println("5: Display status");
			int userDir = checkInt(1, 5);

			char room;
			switch (userDir) {
			case 1:
				if (y == 0) {
					System.out.println("You can't move that way!");
					y = 0;
					break;
				} else {
					hero.setLocation(new Point(x, y--));
					room = hero.goNorth(l);
					mg.checkPosition(room, hero, l);
					break;
				}

			case 2:
				if (x == 3) {
					System.out.println("You can't move that way!");
					x = 2;
				} else {
					hero.setLocation(new Point(x++, y));
					room = hero.goEast(l);
					mg.checkPosition(room, hero, l);
				}
				break;

			case 3:
				if (y == 3) {
					System.out.println("You can't move that way!");
					y = 3;
				} else {
					hero.setLocation(new Point(x, y++));
					room = hero.goSouth(l);
					mg.checkPosition(room, hero, l);
				}
				break;
			case 4:
				if (x == 0) {
					System.out.println("You can't move that way!");
					x = 0;
				} else {
					hero.setLocation(new Point(x--, y));
					room = hero.goWest(l);
					mg.checkPosition(room, hero, l);
					break;
				}
				case 5: hero.display();
				break;
			}
			
			hero.setLocation(new Point(x, y));
			l.displayMap(new Point(x, y));
		}
	}
	/**
	 * LoadChar writes the users character in to the dat file
	 * @param player
	 * @param map
	 * @return
	 */
	static Hero loadChar(Hero player, Level map) {
		Scanner in = new Scanner(System.in);

		Point m = map.findStartLocation();
		;

		if (characterDat.exists()) {
			try {
				ObjectInputStream intoFile = new ObjectInputStream(
						new FileInputStream(characterDat));
				player = (Hero) intoFile.readObject();
				in.close();
				System.out.println("TESTLINE PLEASE IGNORE\nNAME: "
						+ player.getName() + "\nHEALTH: " + player.getHp()
						+ "\nLEVEL: " + player.getLevel() + "\nGOLD: "
						+ player.getGold());
			} catch (IOException e) {
				System.out.println("Can not read file. [character]");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not find the class!");
			}
		} else {
			System.out.println("No save located!\nCreating a new save .....");
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(characterDat));
				out.writeObject(player);
				out.close();
			} catch (IOException e) {
				System.out.println("Error processing the save.");
			}
		}
		return player;
	}

	public static void combat(Hero player, Enemy enemy) {
		Scanner in = new Scanner(System.in);
		while (enemy.getHp() > 0) {
			System.out.println("\nLevel " + enemy.getLevel() + " "
					+ enemy.getName() + " has " + enemy.getHp() + " health.");
			System.out.println("You have " + player.getHp() + " health.");
			System.out
					.println("What do you do?\n1. Fight\n2. Run\n3. Health Potion");
			int dec = checkInt(1, 3);

			if (dec == 1) {
				player.attack(enemy);
				if (enemy.getHp() > 0) {
					enemy.attack(player);
				}
				if (player.getHp() <= 0) {
					System.out
							.println("You died!\nGame Over.\n(Save will be deleted!)");
					characterDat.delete();
					System.exit(0);
				}
				if (enemy.getHp() <= 0) {
					System.out
							.println(enemy.getName()
									+ " has been defeated!\nPlayer has collected "
									+ enemy.getGold() + " gold from "
									+ enemy.getName());
					player.collectGold(enemy.getGold());

					if (!player.pickupItem(enemy.getItem())) {
						System.out.println("Too many items in inventory");
					} else {
						System.out.println("Player has gotten a "
								+ enemy.getItem().getName()
								+ " from the corpse.");
						/*
						 * char sell = in.next().charAt(0); Item eItem =
						 * enemy.getItem(); if (sell == 'y' || sell == 'Y') {
						 * player.collectGold(eItem.getValue());
						 * System.out.println(player.getName() + " receives " +
						 * eItem.getValue() + " peices of gold"); } else {
						 * System.out.println(player.getName() + " has found a "
						 * + enemy.getItem().getName()); player.getItems(); }
						 */
					}
					break;
				}

			}

			else if (dec == 2) {
				System.out.println("You run away!");
				break;
			}

			else if (dec == 3) {
				if (player.hasPotion()) {
					player.heal(((20 * player.getLevel()) - player.getHp()));
					
					
					for(Item i: player.getItems()){
						if(i.getName().equals("Health Potion"))
							player.removeItem(i);
						break;
					}

				} else {
					System.out.println("No health potion in inventory");

				}
			}
		}

	}

	public static int checkInt(int low, int high) {
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;
		while (!valid) {
			if (in.hasNextInt()) {
				validNum = in.nextInt();
				if (validNum >= low && validNum <= high) {
					valid = true;
				} else {
					System.out.println("Invalid input, please try again ");
				}
			} else {
				// clear buffer of junk input
				try{
					in.next();
				}catch(NoSuchElementException i){
					System.out.println(" ..........");
				}
				
				System.out.println("Invalid input! Please try again! ");
			}
		}
		return validNum;
	}

	void checkPosition(char room, Hero player, Level map)
			throws FileNotFoundException {

		switch (room) {

		case 'm':
			Enemy enemy = new EnemyGenerator().generateEnemy(player.getLevel());
			System.out.print("You ran into " + enemy.getName()
					+ "!\nPrepare to fight!");
			combat(player, enemy);

			break;
		case 'i':
			Item item = new itemGenerator().generateItem();
			if (player.getInventory() >= 5) {
				System.out.println("Your bags are too full for "
						+ item.getName() + ".");

			} else {
				player.pickupItem(item);
				System.out.println("You picked up " + item.getName() + ".");
			}
			break;
		case 'f':
			//mainGame mg = new mainGame();
			//mg.loadChar(player, map);
			System.out.println(room);
			System.out.println(player.getLevel());
			player.increaseLevel();

			System.out.println(player.getLevel() + " is players level");
			map.generateLevel(player.getLevel());
			x = 0;
			y = 3;
			player.setLocation(map.findStartLocation());
			map.displayMap(player.getLocation());
			map.getRoom(new Point(x, y));
			
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream(characterDat));
				out.writeObject(player);
				out.close();
			} catch (IOException e) {
				System.out.println("Error processing the save.");
			}
			break;
		case 's':
			if (player.getInventory() < 0) {
				System.out.println("There are no items in your inventory");
			} else {
				System.out
						.println("This is your inventory. Which one would you like to sell?");
				for (int i = 0; i < player.getInventory(); i++) {
					System.out.printf("%d. %s%n", (i + 1), player.getItems()
							.get(i).getName());
				}
				System.out.println("6: none");
				int sellItem = checkInt(1, 5);
				if (sellItem <= 5) {
					player.collectGold(player.getItems().get(sellItem-1).getValue());
					player.removeItem(sellItem-1);
				}

				break;
			}
		}
	}
}
