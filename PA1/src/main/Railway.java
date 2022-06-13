/**
* This program constructs a railway object including all the stations on the railway and the list containing all the station names
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/
package main;

public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	
	/**
	 * This constructor creates a railway object by initializing a double-linked list and a string array
	 * Runtime: O(1)
	 */
	public Railway() {
		this.railway = new DoubleLinkedList<Station>();
		this.stationNames = new String[18];
	}
	
	/**
	 * This method receives a station object and adds it to the end of the double linked list, and it also adds its name to the array of names
	 * @param s station which we want to add to the railway
	 * Runtime: O(N) 
	 */
	public void addStation(Station s) {
		this.railway.insert(s);
		if(stationNames[0] == null) {
			stationNames[0] = s.stationName();
		} else {
			int count = 0;
			while(count < this.stationNames.length && stationNames[count] != null) {
				count++;
			}
			stationNames[count] = s.stationName();
		}
	}
	
	/**
	 * This method receives a rider object and adds it to the appropriate station on the railway 
	 * @param r rider object which we want to add to the railway
	 * Runtime: O(N)
	 */
	public void addRider(Rider r) {
		this.setRiderDirection(r);
		Station s = new Station(r.getStarting());
		s = this.railway.get(s);
		s.addRider(r);
	}
	
	/**
	 * This method receives a train object and adds it to the appropriate station on the railway 
	 * @param t train object which we want to add to the railway
	 * Runtime: O(N)
	 */
	public void addTrain(Train t) {
		Station s = new Station(t.getStation());
		s = this.railway.get(s);
		s.addTrain(t);
	}
	
	/**
	 * This method receives a rider object and sets the rider's direction according to the order of stations in the double linked list
	 * @param r rider for which we set the direction according to its starting station and destination
	 * Runtime: O(N)
	 */
	public void setRiderDirection(Rider r) {
		String start = r.getStarting();
		String dest = r.getDestination();
		int s = 0;
		int d = 0;
		for(int i = 0; i < this.stationNames.length; i++) {
			if(start.equals(stationNames[i])) {
				s = i;
			}
			if(dest.equals(stationNames[i])) {
				d = i;
			}
		}
		if(d - s > 0) {
			r.setDirection(false);
		} else {
			r.setDirection(true);
		}
	}
	
	/**
	 * This method simulates one turn of the operation of the railway. That is, for all stations on the railway, it sends the appropriate trains with appropriate riders to the next station in their direction. This method returns a string log including status of all stations.
	 * @return log String status of each station on the railway
	 * Runtime: O(N^2)
	 */
	public String simulate() {
		String log = "";
		Node<Station> L = this.railway.getFirst();
		while(L != null) {
			Station current = L.getElement();
			log += current.toString() + "\n";
			Station southernmost = new Station("Braintree");
			Station northernmost = new Station("Alewife");
			if(current.equals(southernmost)) {
				if (!current.northBoundTrains.isEmpty()) {
					Train t = current.northBoardTrain();
					Station north = L.prev.getElement();
					log += north.addTrain(t) + t.toString() + "\n";
				}
				if(!current.southBoundTrains.isEmpty()) {
					current.moveTrainSouthToNorth();
				}
			} else if (current.equals(northernmost)) {
				if (!current.southBoundTrains.isEmpty()) {
					Train t = current.southBoardTrain();
					Station south = L.next.getElement();
					log += south.addTrain(t) + t.toString() + "\n";
				}
				if(!current.northBoundTrains.isEmpty()) {
					current.moveTrainNorthToSouth();
				}
			} else {
				if(!current.northBoundTrains.isEmpty()) {
					Train t = current.northBoardTrain();
					Station north = L.prev.getElement();
					log += north.addTrain(t) + t.toString() + "\n";
				}
				if(!current.southBoundTrains.isEmpty()) {
					Train t = current.southBoardTrain();
					Station south = L.next.getElement();
					log += south.addTrain(t) + t.toString() + "\n";
				}
			}
			L = L.next;
		}
		return log;
	}
	
	/**
	 * This method gives a string representation of the railway, containing the status of all stations on it
	 * @return s String representation of the railway
	 * Runtime: O(N)
	 */
	@Override
	public String toString() {
		return this.railway.toString();
	}
}
