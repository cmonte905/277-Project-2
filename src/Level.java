import java.awt.*;
import java.io.*;
import java.util.*;

public class Level implements Serializable {
	private char[][] level;

	/**
	 * Constructs the 4 x 4 array in which the player will move through the
	 * level
	 */
	public Level() {
		this.level = new char[4][4];
	}

	/**
	 * Method that creates the level by printing out the level. The level
	 * changes depending on the level of the player.
	 * 
	 * @param levelNum
	 *            Level of the player
	 * @throws FileNotFoundException
	 */
	public void generateLevel(int levelNum) throws FileNotFoundException {
		String fileName = "level" + levelNum + ".txt";
		Scanner read = new Scanner(new File(fileName));
		String[] line;

		for (int i = 0; i < 4; i++) {
			line = read.nextLine().split("\\s+");
			for (int j = 0; j < line.length; j++) {
				level[i][j] = line[j].charAt(0);
			}
		}
	}

	/**
	 * Method that gets the room type in which the player is currently in
	 * 
	 * @param p
	 *            Current location of the player
	 * @return Char that represents the room the player is in
	 */
	public char getRoom(Point p) {
		char room;
		room = level[p.y][p.x];
		return room;
	}

	/**
	 * Method that prints onto the console the map and the location of the
	 * player
	 * 
	 * @param p
	 *            Location of the player, needed to print out the * for thier
	 *            location
	 */
	public void displayMap(Point p) {// Point p as parameter
		System.out.println("-----------");
		for (int i = 0; i < 4; i++) {
			System.out.print("| ");
			for (int j = 0; j < 4; j++) {
				if (p.getX() == j && p.getY() == i) {
					System.out.print("* ");
				} else
					System.out.print(level[i][j] + " ");

			}
			System.out.print("| \n");
		}
		System.out.println("-----------");

	}

	/**
	 * Method that searches for the starting point of the level and returns that
	 * location
	 * 
	 * @return Point of the starting point
	 */
	public Point findStartLocation() {
		if (level[0].length < 1) {
			System.out.println("Level not yet genereated!");
			return new Point(0, 0);
		}
		for (int i = 0; i < level.length; i++) {
			for (int ii = 0; ii < level[i].length; ii++) {
				if (level[i][ii] == 's') {
					return new Point(ii, i);
				}
			}
		}
		return new Point(0, 0);
	}

}
