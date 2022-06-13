/**
* This is the test method of the Queue class 
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/

package test;

import main.Queue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentQueueTest {
	Queue<String> test;

	String name1 = "Jack";
	String name2 = "Allen";
	public String name3 = "Bob";
	public String name4 = "Lisa";
	public String name5 = "Laura";
	public String name6 = "Sherry";
	
	@Test
	void testQueue() {
		test = new Queue<String>(4);
		assertEquals(0, test.head);
		assertEquals(0, test.tail);
		assertEquals(0, test.numEntries);
	}
	
	@Test
	void testEnqueue() {
		test = new Queue<String>(4);
		test.enqueue("Jack");
		assertEquals("Jack", test.front());
	}
	
	@Test
	void testDequeue() {
		test = new Queue<String>(4);
		test.enqueue("Jack");
		test.enqueue("Allen");
		test.dequeue();
		assertEquals("Allen", test.front());
	}
	
	@Test
	void testFront() {
		test = new Queue<String>(4);
		test.enqueue("Jack");
		test.enqueue("Allen");
		test.enqueue("Bob");
		assertEquals("Jack", test.front());
	}
	
	@Test
	void testSize() {
		test = new Queue<String>(4);
		
		assertEquals(0, test.size());
		
		test.enqueue("Jack");
		test.enqueue("Allen");
		test.enqueue("Bob");
		
		assertEquals(3, test.size());
	}
	
	@Test
	void testToString() {
		test = new Queue<String>(4);
		test.enqueue("Jack");
		test.enqueue("Allen");
		test.enqueue("Bob");
		test.enqueue("Sherry");
		assertEquals("Jack" + "\n" + "Allen" + "\n" + "Bob" + "\n" + "Sherry" + "\n", test.toString());
	}

	
}
