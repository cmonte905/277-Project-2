import java.awt.*;
import java.io.*;
import java.util.*;

public class Level implements Serializable {
	private char[][] level = new char[4][4];

	public Level() {

	}

	public void generateLevel(int levelNum) throws FileNotFoundException {
		String fileName = "level" + levelNum + ".txt";
		Scanner read = new Scanner(new File(fileName));
		String[] line;

		for (int i = 0; i < 4; i++) {
			line = read.nextLine().split("\\s+");
			for (int j = 0; j < line.length; j++) {
				level[i][j] = line[j].charAt(0);
			}
			/*
			 * for(String e: line){ System.out.print(e); } System.out.println();
			 */
		}
	}

	public char getRoom(Point p) {
		return 0;

	}

	public void displayMap() {// Point p as parameter
		System.out.println("-----------");
		for (int i = 0; i < 4; i++) {	
			System.out.print("| ");
			for (int j = 0; j < 4; j++) {
				System.out.print(level[i][j] + " ");

			}
			System.out.print("| \n");
		}
		System.out.println("-----------");
	}

	public Point findStartLocation() {
		return null;

	}

}
