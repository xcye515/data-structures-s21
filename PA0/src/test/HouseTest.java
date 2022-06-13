/**
 * Xingchen Ye
 * xingchenye@brandeis.edu
 * Feb 15, 2021
 * PA#0
 * Description: This is the test method of House class. 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.House;

class HouseTest {
	
	House house = new House(5, 10000, false);
	
	@Test
	void testHouseInit() {
		assertEquals(5, house.getRooms());
		assertEquals(10000, house.getPrice());
		assertEquals(false, house.petsAllowed());
	}
	
	@Test
	void testToString() {
		assertEquals("This house has 5 rooms. "
				+ "It will be sold at price 10000 dollars. "
				+ "It will be false that pets are allowed in this house.", house.toString());
		
	}

}
