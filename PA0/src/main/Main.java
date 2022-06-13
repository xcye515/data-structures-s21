/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This is the main method of family assignment task. 
 */

package main;
import java.io.*;
import java.util.Scanner;


public class Main {
	
	public static Family[] f;
	public static House[] h;
	public static boolean[][] assignments;

	/**
	 * In this main method, two scanners are created to read files familyUnibts.txt and housingUnits.txt
	 * Then, by calling two methods each of which has a scanner as parameter, families and houses are created
	 * Then, there is an algorithm that assigns families to homes
	 * Finally, display all the assignments
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanFamily = new Scanner(new File("familyUnits.txt"));
		createFamilies(scanFamily);
		Scanner scanHouse = new Scanner(new File("housingUnits.txt"));
		createHomes(scanHouse);
		assignFamiliesToHomes();
		displayAssignments();
		for(int i = 0; i < f.length; i++) {
			checkAssignment(i); //check assignment for each family index
		}
		}
	
	/**
	 * Use a scanner from the main method to read the text and create families
	 * @param s a scanner
	 * @void no return
	 */
	public static void createFamilies(Scanner s) {
		f = new Family[s.nextInt()];
		int count = 0;
		while(count < f.length) {
			int numberOfPeople = s.nextInt();
			int numberOfPets = s.nextInt();
			s.nextLine();
			Family family = new Family(numberOfPeople, numberOfPets); 
			for(int i = 0; i < numberOfPeople; i++) { 
				Person person = new Person(s.next(),s.nextInt(),s.nextInt());
				if(!family.addMember(person)) {
					System.out.println("More People Than Expected.");
				}
			}
			for(int i = 0; i < numberOfPets; i++) {
				Pet pet = new Pet(s.next(),s.next(),s.nextInt());
				if(family.addPet(pet) == false) {
					System.out.println("More Pets Than Expected.");
				}
			}
			family.isAssigned = false;
			f[count] = family;
			count = count + 1;
		}
	}
	
	
	/**
	 * Use a scanner from the main method to read the text and create houses
	 * @param s a scanner
	 * @void no return
	 */
	public static void createHomes(Scanner s) {
		h = new House[s.nextInt()];
		int count = 0;
		while(count < h.length) {
			s.nextLine();
			int numberOfRooms = s.nextInt();
			int price = s.nextInt();
			boolean petsAllowed = Boolean.parseBoolean(s.next());
			House house = new House(numberOfRooms, price, petsAllowed);
			house.isAssigned = false;
			h[count] = house;
			count = count + 1;
		}
	}
	
	
	/**
	 * Assign families to the first house that can accommodates them
	 * @void no return
	 */
	public static void assignFamiliesToHomes() {
		assignments = new boolean[f.length][h.length];
		for(int i = 0; i < f.length; i++) {
			Family family = f[i];
			for(int j = 0; j < h.length; j++) {
				House house = h[j];
				if(family.isAssigned || house.isAssigned) {
					assignments[i][j] = false;
					continue;
				} 
				if(family.getPets() != null && !house.petsAllowed()) {
					assignments[i][j] = false;
					continue;
				}
				if (family.numberOfPeople() <= house.getRooms()&&family.getBudget() >= house.getPrice()){
					assignments[i][j] = true;
					family.isAssigned = true;
					family.isAssignedTo = j;
					house.isAssigned = true;
					continue;
				}
				assignments[i][j] = false;
			}
		}
	}
	
	/**
	 * Print and display the assignment of houses
	 * @void no return
	 */
	public static void displayAssignments() {
		for(int i = 0; i < f.length; i++) {
			Family family = f[i];
			if(!family.isAssigned){
				System.out.println("The family with index " + i 
						+ " is not assigned to a home. "
						+ "\nThe specific information is given below");
				System.out.println(family.toString());
				System.out.print("\r\n");
			}else{
				House house = h[family.isAssignedTo];
				System.out.println("The family with index " + i 
						+ " is assigned to the house with index " 
						+ family.isAssignedTo + 
						". \nThe specific information is given below:");
				System.out.println(family.toString());
				System.out.println(house.toString());
				System.out.print("\r\n");
			}
		}
	}
	
	/**
	 * Print and display the assignment of houses
	 * @param familyIndex an integer of an array of the families
	 * @void no return
	 */
	public static void checkAssignment(int familyIndex) {
		Family family = f[familyIndex];
		int count = 0;
		for(int j = 0; j < h.length; j++) {
			if(assignments[familyIndex][j]) {
				count++;
			}
		}
		if(count > 1) {
			System.out.println("Family assigned to more than one house.");
		}
		if(count == 1) {
			House house = h[family.isAssignedTo];
			if(house.getRooms() > family.numberOfPeople()) {
				for(Person people: family.getPeople()) {
					people.speak();
				}
			if(family.getPets() != null && !house.petsAllowed()) {
				for(Pet pets: family.getPets()) {
					pets.makeSound();
				}
			}
			if(house.getPrice() > family.getBudget()) {
				System.out.println("House over budget.");
			}
		}
		}
	}
}

