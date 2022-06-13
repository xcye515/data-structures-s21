/**
* This program constructs a station object including its name, the waiting riders and trains for south and north directions. It also contains methods simulating the station's behavior
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/
package main;

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	public String name;
	
	/**
	 * This constructor receives a string the name of the station, and it initialize four queues of the waiting riders and trains
	 * @param name String of the stations's name
	 * Runtime: O(1)
	 */
	public Station(String name) {
		this.name = name;
		this.northBoundRiders = new Queue<Rider>(20);
		this.southBoundRiders = new Queue<Rider>(20);
		this.northBoundTrains = new Queue<Train>(20);
		this.southBoundTrains = new Queue<Train>(20);
	}
	
	/**
	 * This method receives a rider object and adds the rider to the station's appropriate waiting rider queue regarding the rider's direction
	 * @param r Rider which we want to add it to the station's appropriate queue of riders
	 * @return boolean value true if the rider is added successfully false otherwise
	 * Runtime: O(1)
	 */
	public boolean addRider(Rider r) { 
		if(r.goingNorth() && this.northBoundRiders.size() <= 20) {
			this.northBoundRiders.enqueue(r);
			return true;
		} 
		if(!r.goingNorth() && this.southBoundRiders.size() <= 20){
			this.southBoundRiders.enqueue(r);
			return true;
		}
		return false;
	}
	
	/**
	 * This method receives a strain object and adds the train to the appropriate station's waiting train queue regarding the train's direction. It gives a string representation of the disembarking passengers at the station
	 * @param t Train which we want to add it to the station's appropriate queue of trains
	 * @return s String that includes that passengers that were removed at this Station
	 * Runtime: O(1)
	 */
	public String addTrain(Train t) {
		t.updateStation(this.name);
		String s = "";
		s += this.name;
		s += " Disembarking Passengers: \n";
		s += t.disembarkPassengers();
		if(t.goingNorth()) {
			this.northBoundTrains.enqueue(t);
		}
		if(!t.goingNorth()) {
			this.southBoundTrains.enqueue(t);
		}
		return s;
	}
	
	/**
	 * This method gets a south-bound train from the queue of south bound trains, and it adds south bound passengers to the train as much as possible
	 * @return t Train object if there exists south bound trains waiting in the station, null if there is no south bound trains in the station
	 * Runtime: O(N) 
	 */
	public Train southBoardTrain(){
		if(this.southBoundTrains.size() == 0) {
			return null;
		}
		Train t = this.southBoundTrains.front();
		this.southBoundTrains.dequeue();
		while(t.hasSpaceForPassengers() && !this.southBoundRiders.isEmpty()) {
			t.addPassenger(this.southBoundRiders.front());
			this.southBoundRiders.dequeue();
		}
		return t;
	}
	
	/**
	 * This method gets a north-bound train from the queue of north bound trains, and it adds north bound passengers to the train as much as possible
	 * @return t Train object if there exists north bound train waiting in the station, null if there is no north bound trains in the station
	 * Runtime: O(N) 
	 */
	public Train northBoardTrain() {
		if(this.northBoundTrains.size() == 0) {
			return null;
		}
		Train t = this.northBoundTrains.front();
		this.northBoundTrains.dequeue();
		while(t.hasSpaceForPassengers() && !this.northBoundRiders.isEmpty()) {
			t.addPassenger(this.northBoundRiders.front());
			this.northBoundRiders.dequeue();
		}
		return t;
	}
	
	/**
	 * This method turns a north-bound train to heading south
	 * Runtime: O(1)
	 */
	public void moveTrainNorthToSouth() {
		Train t = this.northBoundTrains.front();
		this.northBoundTrains.dequeue();
		t.swapDirection();
		this.southBoundTrains.enqueue(t);
	}
	
	/**
	 * This method turns a south-bound train to heading north
	 * Runtime: O(1)
	 */
	public void moveTrainSouthToNorth() {
		Train t = this.southBoundTrains.front();
		this.southBoundTrains.dequeue();
		t.swapDirection();
		this.northBoundTrains.enqueue(t);
	}
	
	/**
	 * This method gives a string representation of the station, giving the number of trains/riders waiting in the station
	 * @return s String representation of the station
	 * Runtime: O(1)
	 */
	@Override
	public String toString() {
		String s = "";
		s += "Station: " + this.name + "\n";
		s += this.northBoundTrains.size() + " north-bound trains waiting\n";
		s += this.southBoundTrains.size() + " south-bound trains waiting\n";
		s += this.northBoundRiders.size() + " north-bound passengers waiting\n";
		s += this.southBoundRiders.size() + " south-bound passengers waiting\n";
		return s;
	}
	
	/**
	 * This method gets the station's name
	 * @return String the name of the station
	 * Runtime: O(1)
	 */
	public String stationName() {
		return this.name;
	}
	
	/**
	 * This method receives an object and compares it with the station
	 * @return result boolean value true if they are equivalent, false otherwise
	 * Runtime: O(1)
	 */
	@Override
	public boolean equals(Object o) {
		boolean result = o.equals(this.name);
		return result;
	}
}
