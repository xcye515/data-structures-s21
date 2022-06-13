/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This class contains a constructor of person and methods that give information about the person
 */
package main;
public class Person {
	
	private String name;
	private int age;
	private int salary;
	
	/**
	 * Creates a Person object with the given name, age, and salary
	 * @param name the name of the Person to be created
	 * @param age the age of the Person to be created
	 * @param salary the salary of the Person to be created
	 */
	public Person(String name, int age, int salary) {
		//TODO: Implement the constructor
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	/**
	 * Returns the name of this Person 
	 * @return a String representing the name of this Person
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the age of this Person
	 * @return an integer representing the age of this Person
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Returns the salary of this Person
	 * @return an integer representing the salary of this Person
	 */
	public int getSalary() {
		return salary;
	}
	
	/**
	 * Returns the string said by this Person when they speak
	 * @return String representation of what this Person says
	 */
	public String speak() {
		if (this.getAge() > 18) { 
			return "This house does not have enough rooms to accommodate my family. I would like my family to be assigned to a house with more rooms.";
		} else {
			return "I want a bigger house!";
		}
	}
	
	/**
	 * Returns a String representation of this Person, including his/her name, age and salary.
	 * @return a String representation of this Person 
	 */
	public String toString() {
		return "This person is " + this.getName() + " and he/she is " + this.getAge() + " years old. His/her salary is " + this.getSalary() + " dollars.";
	}
}
