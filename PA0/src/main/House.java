/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This class contains a constructor of house and methods that give information about the house
 */

package main;

public class House {
	
	private int rooms;
	private int price;
	private boolean petsAllowed;
	public boolean isAssigned;
	
	/**
	 * Creates a House object with the given number of rooms, price, and whether pets are allowed
	 * @param rooms the number of rooms in the House
	 * @param price the price of the House to be sold
	 * @param petsAllowed whether or not pets are allowed in the House
	 */
	public House(int rooms, int price, boolean petsAllowed) {
		this.rooms = rooms;
		this.price = price;
		this.petsAllowed = petsAllowed;
	}
	
	/**
	 * Returns the number of rooms in this House 
	 * @return an integer representing the number of rooms in this House 
	 */
	public int getRooms() {
		return rooms;
	}
	
	/**
	 * Returns the price of this House to be sold
	 * @return an integer representing the price of this House 
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Returns whether pets are allowed in this House
	 * @return an Boolean value representing whether pets are allowed in this House
	 */
	public boolean petsAllowed() {
		return petsAllowed;
	}
	
	/**
	 * Returns a String representation of this House, including the number of rooms, price, and whether pets are allowed.
	 * @return a String representation of this House 
	 */
	public String toString() {
		return "This house has " + this.getRooms() 
				+ " rooms. It will be sold at price " 
				+ this.getPrice() + " dollars. It will be " 
				+ this.petsAllowed() 
				+ " that pets are allowed in this house.";
	}
}

