/**
* This program constructs a Rider class, including methods related to the rider's ID, starting station and destination, and the direction the rider is heading
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/

package main;

public class Rider {
	public String riderID;
	public String startingSta;
	public String destinaSta;
	public boolean headingNorth;

	/**
	 * This constructor receives this rider's ID, starting station and destination
	 * @param riderID String the ID of the rider
	 * @param startingStation String the rider's starting station
	 * @param destinationStation String the ridere's destination
	 * Runtime: O(N)
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID = riderID;
		this.startingSta = startingStation;
		this.destinaSta = destinationStation;
	}
	
	/**
	 * This method gets the starting destination of the rider
	 * @return String representing the starting station of the rider
	 * Runtime: O(1)
	 */
	public String getStarting() {
		return this.startingSta;
	}
	
	/**
	 * This method gets the destination of the rider
	 * @return String representing the destination of the rider
	 * Runtime: O(1)
	 */
	public String getDestination() {
		return this.destinaSta;
	}
	
	/**
	 * This method gets the ID of the rider
	 * @return String representing the ID of the rider
	 * Runtime: O(1)
	 */
	public String getRiderID() {
		return this.riderID;
	}
	
	/**
	 * This method receives a boolean value and sets the direction (north or south) of the rider
	 * @param b boolean value, true if the rider is heading north, false otherwise
	 * Runtime: O(1)
	 */
	public void setDirection(boolean b) {
		this.headingNorth = b;
	}
	
	/**
	 * This method returns true if the rider is heading north, false if the rider is heading south
	 * @return boolean value true if the rider is heading north, false if the rider is heading south
	 * Runtime: O(1)
	 */
	public boolean goingNorth() {	
		return this.headingNorth;
	}
	
	/**
	 * This method changes the direction of the rider
	 * Runtime: O(1)
	 */
	public void swapDirection() {
		if(this.headingNorth) {
			this.headingNorth = false;
		} else {
			this.headingNorth = true;
		}
	}
	
	/**
	 * This method returns a string representation of the rider
	 * @return String containing the rider's ID, starting station and destination
	 * Runtime: O(1)
	 */
	@Override
	public String toString() {
		String s = riderID + "\n" + startingSta + "\n" + destinaSta;
		return s;
	}
	
	/**
	 * This method receives an object and tests if the object is equivalent with the rider
	 * @return result boolean value is true if they are equivalent, false otherwise
	 */
	@Override
	public boolean equals(Object s) {
		boolean result = s.equals(this.riderID);
		return result;
	}
}
