/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This class contains a constructor of pet and methods that give information about the pet
 */

package main;

public class Pet {
	
	private String name;
	private String species;
	private int age;
	
	/**
	 * Creates a Pet object with the given name, species, and age
	 * @param name the name of the Pet to be created
	 * @param species the species of the Pet to be created
	 * @param age the age of the Pet to be created
	 */
	public Pet(String name, String species, int age) {
		//TODO: Implement the constructor
		this.name = name;
		this.species = species;
		this.age = age;
	}
	
	/**
	 * Returns the name of this Pet 
	 * @return a String representing the name of this Pet
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the species of this Pet 
	 * @return a String representing the species of this Pet
	 */
	public String getSpecies() {
		return species;
	}
		
	/**
	 * Returns the age of this Pet 
	 * @return an integer representing the age of this Pet
	 */
	public int getAge() {
		return age;
	}
	
	
	/**
	 * Returns the sound made by this Pet
	 * @return String representation of the sound this Pet makes
	 */
	public String makeSound() {
		if(species == "Cat") {
			return "meow!";			
		} else if (species == "Dog") {
			return "bark!";
		} else {
			return "squak!";
		}
	}
	
	/**
	 * Returns a String representation of this Pet, including its name, species, and age.
	 * @return a String representation of this Pet 
	 */
	@Override
	public String toString() {
		return "This pet is " + this.getName() + " and it's a " + this.getSpecies() + " of " + this.getAge() + " years old. ";
	}
}

