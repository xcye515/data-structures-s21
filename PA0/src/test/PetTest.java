/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This is the test method of Pet class. 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.Pet;

class PetTest {
	Pet dog = new Pet("Charlie", "Dog", 8);
	Pet cat = new Pet("Max", "Cat", 12);
	Pet fox = new Pet("Oscar", "Fox", 10);

	@Test
	void testPetInit() {
		assertEquals("Charlie", dog.getName());
		assertEquals("Dog", dog.getSpecies());
		assertEquals(8, dog.getAge());
	}
	
	@Test
	void testMakeSound() {
		assertEquals("bark!", dog.makeSound());
		assertEquals("meow!", cat.makeSound());
		assertEquals("squak!", fox.makeSound());
	}
	
	@Test
	void testToString() {
		assertEquals("This pet is Charlie and it's a Dog of 8 years old. ", dog.toString());
	}
	
}
