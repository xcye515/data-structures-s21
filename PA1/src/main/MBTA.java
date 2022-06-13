/**
* This program constructs a MBTA object that reads the stations on the red line, riders, and trains from given files. It initializes the trains, riders, stations, and a railway object based on the given files. Then, it runs the simulation of the MBTA.
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/

package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	/**
	 * This main method first initializes a railway object and calls methods to initialize the stations, riders, and trains from the given files. Then it calls the runSimulation() method to simulate several turns of MBTA operation based on the given TIMES constant
	 * @param args string array read from the console
	 * @throws FileNotFoundException is thrown if the file is not found
	 * Runtime: O(N^2)
	 */
	public static void main(String[] args) throws FileNotFoundException {
		r = new Railway();
		initStations("redLine.txt");
		initRiders("riders.txt");
		initTrains("trains.txt");
		runSimulation();
	}
	
	/**
	 * This method runs simulation using an int constant TIMES and simulate() method from the railway class. It prints the log to the system's console
	 * Runtime: O(N^2)
	 */
	public static void runSimulation() {
		System.out.println("INITIATED RED LINE\n");
		System.out.print(r.toString());
		System.out.println("BEGINNING RED LINE SIMULATION\n");
		int count = 1;
		while(count <= TIMES) {
			System.out.println(" ------ " + count + " ------ \n");
			String log = r.simulate();
			System.out.println(log);
			count++;
		}
	}
	
	/**
	 * This method receives a string of the input file name and constructs trains object from it. Then it adds the train objects to the railway and the appropriate station on the railway
	 * @param trainsFile String the name of the file which the scanner object read
	 * @throws FileNotFoundException is thrown if the file is not found
	 * Runtime: O(N)
	 */
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		File trains = new File(trainsFile);
		Scanner readTrains = new Scanner(trains);
		while(readTrains.hasNextLine()) {
			String currSta = readTrains.nextLine();
			int direction = Integer.parseInt(readTrains.nextLine());
			Train train = new Train(currSta, direction);
			r.addTrain(train);
		}
		readTrains.close();
	}
	
	/**
	 * This method receives a string of the input file name and construct rider objects by reading the file. Then it adds the rider objects to the railway and the appropriate station on the railway
	 * @param ridersFile String the name of the file which the scanner object read
	 * @throws FileNotFoundException is thrown if the file is not found
	 * Runtime: O(N)
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException{
		File riders = new File(ridersFile);
		Scanner readRiders = new Scanner(riders);
		while(readRiders.hasNextLine()) {
			String id = readRiders.nextLine();
			String start = readRiders.nextLine();
			String end = readRiders.nextLine();
			Rider rider = new Rider(id, start, end);
			r.addRider(rider);
			System.out.println();
		}
		readRiders.close();
	}
	
	/**
	 * This method receives a string of the input file name and construct station objects by reading the file. Then it adds the station objects to the railway.
	 * @param stationsFile String the name of the file which the scanner object read
	 * @throws FileNotFoundException is thrown if the file is not found
	 * Runtime: O(N)
	 */
	public static void initStations(String stationsFile) throws FileNotFoundException {
		File stations = new File(stationsFile);
		Scanner readStas = new Scanner(stations);
		while(readStas.hasNextLine()) {
			Station station = new Station(readStas.nextLine());
			r.addStation(station);
		}
		readStas.close();
	}
}
