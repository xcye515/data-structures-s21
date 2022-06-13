/**
* This program constructs a train object including properties such as the maximum capacity of the train, passengers, and its direction and current station. It also contains methods related to the train's behavior.
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/

package main;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	public String currentSta;
	public boolean goingNorth;
	
	/**
	 * This constructor receives a string indicating the train's current station and an int indicating the direction of the train, and it initializes the passengers array and sets the default number of passengers on the train to zero
	 * @param currentStation String the name of the current station of the train
	 * @param direction int 1 if the train is going south 0 if the train is going north
	 * Runtime: O(1)
	 */
	public Train(String currentStation, int direction) {
		this.currentSta = currentStation;
		if(direction == 0) {
			this.goingNorth = true;
		} else if (direction == 1){
			this.goingNorth = false; 
		}
		this.passengers = new Rider[TOTAL_PASSENGERS];
		this.passengerIndex = 0;
	}
	
	/**
	 * This method gets the direction of the train 
	 * @return boolean value true if the train is going north, false otherwise
	 * Runtime: O(1)
	 */
	public boolean goingNorth() {
		return this.goingNorth;
	}
	
	/**
	 * This method swap the direction of the train
	 * Runtime: O(1)
	 */
	public void swapDirection() {
		if(this.goingNorth) {
			this.goingNorth = false;
		} else {
			this.goingNorth = true;
		}
	}
	
	/**
	 * This method gives the string representation of all the current passengers on the train from the passengers' array
	 * @return s String the string representation of all the current passengers on the train
	 * Runtime: O(N)
	 */
	public String currentPassengers() {
		String s = "";
		for(int i = 0; i < TOTAL_PASSENGERS; i++) {
			if(this.passengers[i] != null) {
				s += this.passengers[i].getRiderID() + ", " + this.passengers[i].getDestination() + "\n";
			}
		}
		return s;
	}
	
	/**
	 * This method receives a rider object and adds it to the train's passengers' array, and it returns a boolean value indicating if the rider is added successfully or not
	 * @param r Rider that we want to add to the train
	 * @return boolean value true if the rider is appropriate to be added to the train and is sucessfully added, false otherwise
	 * Runtime: O(N)
	 */
	public boolean addPassenger(Rider r) {
		if(r.startingSta.equals(this.currentSta)) {
			if(r.goingNorth() == this.goingNorth) {
				if(this.hasSpaceForPassengers()) {
					for(int i = 0; i < TOTAL_PASSENGERS; i++) {
						if(this.passengers[i] == null) {
							this.passengers[i] = r;
							this.passengerIndex++;
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * This method gives a boolean value indicating if the train has space for new passengers
	 * @return boolean value true if the train is not full, false if the train is full and has no space for new passengers
	 * Runtime: O(1)
	 */
	public boolean hasSpaceForPassengers() {
		if(passengerIndex <= 10) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method removes passengers who will get off the train when the train arrives their destination, and it returns the string representation of all the disembarked passengers 
	 * @return s String representing all the passengers who will get off the train at the current station
	 * Runtime: O(1)
	 */
	public String disembarkPassengers() {
		String s = "";
		for(int i = 0; i < TOTAL_PASSENGERS; i++) {
			if(this.passengers[i] != null) {
				if(this.passengers[i].getDestination().equals(this.currentSta)) {
					s += this.passengers[i].getRiderID() + "\n";
					this.passengers[i] = null;
					this.passengerIndex--;
				}
			}
		}
		return s;
	}
	
	/**
	 * This method updates the current station of the string with the string received
	 * @param s String the new current station name that we want to update to this train
	 * Runtime: O(1)
	 */
	public void updateStation(String s) {
		this.currentSta = s;
	}
	
	/**
	 * This method gets the string of current station name 
	 * @return String the name of the current station of the train
	 * Runtime: O(1)
	 */
	public String getStation() {
		return this.currentSta;
	}
	
	/**
	 * This method returns the string representation of the train, including its direction, disembarking passengers, passengers on the train, and the current station
	 * @return String representation of the train
	 * Runtime: O(1)
	 */
	@Override
	public String toString() {
		String direction;
		if(this.goingNorth()) {
			direction = "Northbound";
		} else {
			direction = "Southbound";
		}
		String s = "Direction: " + direction + "\n";
		s += "Passengers: \n" + this.currentPassengers();
		s += "Current station: " + this.currentSta + "\n";
		return s;
	}
}
