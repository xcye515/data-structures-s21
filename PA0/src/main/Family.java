/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This class contains a constructor of family and methods that give information about the family
 */

package main;

public class Family {
	
	private Person[] familyMembers;
	private Pet[] familyPets;
	public boolean isAssigned;
	public int isAssignedTo;
	
	/**
	 * Creates a Family object with the given number of humans and the number of pets
	 * @param humans the number of Person objects in the Family
	 * @param pets the number of Pet objects in the Family
	 */
	public Family(int humans, int pets) {
		familyMembers = new Person[humans];
		familyPets = new Pet[pets];
	}
	
	/**
	 * Returns the people in this Family 
	 * @return an array of Person objects representing the people in this Family
	 */
	public Person[] getPeople() {
		return familyMembers;
	}
	
	/**
	 * Returns the pets in this Family 
	 * @return an array of Pet objects representing the pets in this Family
	 */
	public Pet[] getPets() {
		return familyPets;
	}
	
	/**
	 * Returns the budget of this Family 
	 * @return an integer representing the budget of this Family
	 */
	public int getBudget() {
		int budget = 0;
		Person p;
		for(int i = 0; i < familyMembers.length; i++) {
			p = familyMembers[i];
			budget = budget + p.getSalary();
		}
		return budget;
	}
	
	/**
	 * Returns the total number of people in this Family 
	 * @return an integer representing the total number of people in this Family 
	 */
	public int numberOfPeople() {
		return familyMembers.length;
	}
	
	/**
	 * Returns the total number of pets in this Family 
	 * @return an integer representing the total number of pets in this Family 
	 */
	public int numberOfPets() {
		return familyPets.length;
	}	
	
	/**
	 * Returns true if the person p was added to the family successfully and false otherwise
	 * @param p the person who will be added to this Family
	 * @return an boolean value whether the person was added to the family successfully
	 */
	public boolean addMember(Person p){
		if(familyMembers[0] == null) {
			familyMembers[0] = p;
			return true;
		}
		int i = 0;
		while(i < familyMembers.length - 1) {
			if(familyMembers[i + 1] == null) {
				familyMembers[i + 1] = p;
				return true;
			}
			i++;
		}
		return false;
	}
	
	/**
	 * Returns true if the pet p was added to the family successfully and false otherwise
	 * @param p the pet who will be added to this Family
	 * @return an boolean value whether the pet was added to the family successfully
	 */
	public boolean addPet(Pet p) {
		if(familyPets.length == 0) {
			return false;
		}
		if(familyPets[0] == null) {
			familyPets[0] = p;
			return true;
		}
		int i = 0;
		while(i < familyPets.length - 1) {
			if(familyPets[i + 1] == null) {
				familyPets[i + 1] = p;
				return true;
			}
			i++;
		}
		return false;
	}
	
	/**
	 * Returns a String representation of this Family, including all the people and pets in it
	 * @return a String representation of this Family 
	 */
	public String toString() {
		String s = "This family has "  + this.numberOfPeople() + " people and " + this.numberOfPets() + " pets.";
		for(int i = 0; i < familyMembers.length; i++) {
			 s = s + familyMembers[i].toString();
		}
		for(int i = 0; i < familyPets.length; i++) {
			 s = s + familyPets[i].toString();
		}
		return s;
	}
	
}

