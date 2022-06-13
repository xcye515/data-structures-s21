/**
* This is the test method of the DoubleLinkedList class 
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/

package test;

import main.DoubleLinkedList;
import main.Node;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentDLLTest {
	DoubleLinkedList<String> dlltest;
	Node<String> nodetest;
	
	@Test
	void testNodeInit() {
		nodetest = new Node<String>("Bob");
		
		assertEquals("Bob", nodetest.element);
		assertEquals(null, nodetest.prev);
		assertEquals(null, nodetest.next);
	}
	
	@Test
	void testNodeSetElement() {
		nodetest = new Node<String>("Bob");
		nodetest.setElement("Jack");
		
		assertEquals("Jack", nodetest.element);
	}
	
	@Test
	void testNodeSetNext() {
		nodetest = new Node<String>("Bob");
		Node<String> nodetest2 = new Node<String>("Jack");
		nodetest.setNext(nodetest2);
		
		assertEquals(nodetest2, nodetest.next);
	}
	
	@Test
	void testNodeGetNext() {
		nodetest = new Node<String>("Bob");
		Node<String> nodetest2 = new Node<String>("Jack");
		nodetest.setNext(nodetest2);
		
		assertEquals(nodetest2, nodetest.getNext());
	}
	
	@Test
	void testNodeSetPrev() {
		nodetest = new Node<String>("Bob");
		Node<String> nodetest2 = new Node<String>("Jack");
		nodetest.setPrev(nodetest2);
		
		assertEquals(nodetest2, nodetest.prev);
	}
	
	@Test
	void testNodeGetPrev() {
		nodetest = new Node<String>("Bob");
		Node<String> nodetest2 = new Node<String>("Jack");
		nodetest.setPrev(nodetest2);
		
		assertEquals(nodetest2, nodetest.getPrev());
	}
	
	@Test
	void testGetElement() {
		nodetest = new Node<String>("Bob");
		
		assertEquals("Bob", nodetest.getElement());
	}
	
	@Test
	void testToStringNode() {
		nodetest = new Node<String>("Bob");
		
		assertEquals("Bob", nodetest.toString());
		
		nodetest.setElement(null);
		
		assertEquals(null, nodetest.toString());
	}
	
	@Test
	void testDLLInit() {
		dlltest = new DoubleLinkedList<String>();
		
		assertEquals(null, dlltest.first);
		assertEquals(null, dlltest.end);
	}
	
	@Test
	void testGetFirst() {
		dlltest = new DoubleLinkedList<String>();
		
		assertEquals(null, dlltest.getFirst());
		
		dlltest.insert("Bob");
		dlltest.insert("Jack");
		
		assertEquals(dlltest.first, dlltest.getFirst());
	}
	
	@Test
	void testInsert() {
		dlltest = new DoubleLinkedList<String>();
		dlltest.insert("Bob");
		
		assertEquals("Bob", dlltest.end.getElement());
		
		dlltest.insert("Jack");
		
		assertEquals("Jack", dlltest.end.getElement());
	}
	
	@Test
	void testDelete() {
		dlltest = new DoubleLinkedList<String>();
		dlltest.delete("Bob");
		
		assertEquals(null, dlltest.end);
		
		dlltest.insert("Bob");
		dlltest.insert("Jack");
		dlltest.insert("Bob");
		dlltest.delete("Bob");
		
		assertEquals("Jack", dlltest.first.getElement());
		assertEquals(null, dlltest.delete("Sherry"));
		
		dlltest.delete("Bob");
		
		assertEquals("Jack", dlltest.first.getElement());
		assertEquals("Jack", dlltest.end.getElement());
		
		dlltest.delete("Jack");
		
		assertEquals(null, dlltest.first);
		assertEquals(null, dlltest.end);
	}
	
	@Test
	void testGet() {
		dlltest = new DoubleLinkedList<String>();
		dlltest.insert("Bob");
		dlltest.insert("Jack");
		dlltest.insert("Allen");
		
		assertEquals("Bob", dlltest.get("Bob"));
		assertEquals(null, dlltest.get("Sherry"));
	}
	
	@Test
	void testSize() {
		dlltest = new DoubleLinkedList<String>();
		dlltest.insert("Bob");
		dlltest.insert("Jack");
		dlltest.insert("Allen");
		
		assertEquals(3, dlltest.size());
	}
	
	@Test
	void testToStringDLL() {
		dlltest = new DoubleLinkedList<String>();
		dlltest.insert("Bob");
		dlltest.insert("Jack");
		dlltest.insert("Allen");
		
		assertEquals("Bob" + "\n" + "Jack" + "\n" + "Allen" + "\n", dlltest.toString());
	}

}
