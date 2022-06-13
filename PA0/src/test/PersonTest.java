/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This is the test method of Person class. 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.Person;

class PersonTest {

	// Here we instantiate objects that we will reference in our test cases. 
	// You can and should instantiate additional objects here. 
		
	Person examplePerson = new Person("Example Person", 50, 50000);
	Person adultPerson = new Person("Adult", 50, 50000);
	Person childPerson = new Person("Child", 17, 0);
	
	
	@Test
	void testPersonInit() {
		assertEquals("Example Person", examplePerson.getName());
		assertEquals(50, examplePerson.getAge());
		assertEquals(50000, examplePerson.getSalary());
	}	

	@Test
	void testSpeak() {
		assertEquals("This house does not have enough rooms to accommodate my family. "
				+ "I would like my family to be assigned to a house with more rooms.", 
				adultPerson.speak());
		assertEquals("I want a bigger house!", childPerson.speak());
	}
	
	@Test
	void testToString() {
		assertEquals("This person is Example Person and he/she is 50 years old. "
				+ "His/her salary is 50000 dollars.", 
				examplePerson.toString());
	}

}