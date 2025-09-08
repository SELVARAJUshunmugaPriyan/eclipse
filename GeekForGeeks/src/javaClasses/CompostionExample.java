// Java program to illustrate
// Concept of Composition
package javaClasses;

import java.util.ArrayList;
import java.util.List;

// Room class
class Room
{
	private String name;
	
	// Constructor
	public Room(String name)
	{
		this.setName(name);
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

// house example
class House
{
	private String name;
	private List<Room> rooms;
	
	// Constructor
	public House(String name)
	{
		this.setName(name);
		rooms = new ArrayList<Room>();
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	// Methods
	public void addRoom(Room room)
	{
		rooms.add(room);
	}
	
	public int totalRooms()
	{
		return rooms.size();
	}
}

// Main class : Composition of Room into House
public class CompostionExample {

	public static void main(String[] args) {
		
		House house = new House("Dream House");
		
		// Each room object is composed into house object
		// They cannot exist independently
		house.addRoom(new Room("Living room"));
		house.addRoom(new Room("Bedroom"));
		house.addRoom(new Room("Kitchen"));
		house.addRoom(new Room("Bathroom"));
		
		int r = house.totalRooms();
		System.out.println("Total number of rooms is " + r);
		
		System.out.println("Room names: ");
		for (Room room : house.getRooms())
			System.out.println("- " + room.getName());
	}

}
