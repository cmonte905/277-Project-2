import java.awt.*;
import java.util.*;
import java.io.*;
public class Hero extends Character implements Serializable{

	private ArrayList<Item> items; 
	Point location;
	public Hero(String n, String q, int h, int l, int g) {
		super(n, q, h, l, g);
	}

	public void attack(Character c) {
		
	}
	public Character loadChar(){
		return null;
		
	}
	
	public ArrayList<Item> getItems(Item i){
		return null;
	}
	//not too sure what this does, guessing it adds to the character if there is 
	//enough room, so check that first
	public boolean pickupItem(Item i){
		return true;
	}
	public void removeItem(int index){
		
	}
	public void removeItem(Item i){
		
	}
	public Point getLocation(){
		return location;
	}
	public void setLocation(){
		
	}
	//Null for now, change it something later, most like char values
	public char goNorth(Level l){
		return (java.lang.Character) null;
	}
	public char goSouth(Level l){
		return (java.lang.Character) null;
	}
	public char goEast(Level l){
		return (java.lang.Character) null;
	}
	public char goWest(Level l){
		return (java.lang.Character) null;
	}
	
}
