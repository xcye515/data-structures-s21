/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This is the test method of Family class. 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.*;


class FamilyTest {
	Person person1 = new Person("Shirly", 20, 10000);
	Person person2 = new Person("Oliver", 30, 50000);
	Person person3 = new Person("Molly", 29, 30000);
	
	Pet pet1 = new Pet("Max", "Dog", 3);
	
	Family family1 = new Family(1,0);
	Family family2 = new Family(2,1);

	@Test
	void testAddMember() {
		assertEquals(true, family1.addMember(person1));
		assertEquals(false, family1.addMember(person2));
		assertEquals(true, family2.addMember(person2));
		assertEquals(true, family2.addMember(person3));	
	}
	
	@Test
	void testAddPet() {
		assertEquals(false, family1.addPet(pet1));
		assertEquals(true, family2.addPet(pet1));
	}
	
	@Test
	void testGetPeople() {
		family1.addMember(person1);
		assertEquals(person1, family1.getPeople()[0]);
	}
	
	@Test
	void testGetPet() {
		family2.addPet(pet1);
		assertEquals(pet1, family2.getPets()[0]);
	}
	
	@Test
	void testGetBudget() {
		family1.addMember(person1);
		assertEquals(10000, family1.getBudget());
	}
	
	
	@Test
	void testNumberOfPeopleAndPets() {
		assertEquals(1, family1.numberOfPeople());
		assertEquals(2, family2.numberOfPeople());
		assertEquals(0, family1.numberOfPets());
		assertEquals(1, family2.numberOfPets());
	}
	
	@Test
	void testToString() {
		family1.addMember(person1);
		assertEquals("This family has 1 people and 0 pets."
				+ "This person is Shirly and he/she is 20 years old. "
				+ "His/her salary is 10000 dollars."
				, family1.toString());
	}
	
	

}
