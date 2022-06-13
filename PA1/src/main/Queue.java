/**
* This program constructs Queue data structure that later helps construct the waiting riders and waiting trains in a station
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/

package main;

import java.util.NoSuchElementException;

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	/**
	 * This constructor receives the size of the array from which we construct this queue
	 * @param capacity integer the size of the array
	 */
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		this.head = 0;
		this.tail = 0;
		this.numEntries = 0;
	}
	
	/**
	 * This method receives an element that we want to add to the tail of the queue
	 * @param element the element we add to the tail of the queue
	 * Runtime: O(1)
	 */
	public void enqueue(T element) {
		q[tail] = element;
		numEntries++;
		if(tail+1==q.length) {
			tail = 0;
		} else {
			tail++;
		}
	}
	
	/**
	 * This method removes the element at the front of the queue
	 * @throws NoSuchElementException This queue is empty and there is no such element that we could remove
	 * Runtime: O(1)
	 */
	public void dequeue() throws NoSuchElementException{ 
		if(q[head] == null) {
			throw new NoSuchElementException("Empty Queue.");
		}
		q[head] = null;
		numEntries--;
		if(head == q.length - 1) {
			head = 0;
		} else {
			head++;
		}
	}
	
	/**
	 * This method returns the element at the head of the queue
	 * @return front the element at the head of the queue
	 * @throws NoSuchElementException There is no such element at the head of the queue
	 * Runtime: O(1)
	 */
	public T front() throws NoSuchElementException{
		if(q[head] == null) {
			throw new NoSuchElementException("Element cannot be found.");
		}
		T front = q[head];
		return front;
	}
	
	/**
	 * This method returns an integer indicating the number of elements stored in the queue
	 * @return integer the number of entries added to the queue array
	 * Runtime: O(1)
	 */
	public int size() {
		return this.numEntries;
	}
	
	/**
	 * This method returns a boolean value whether if the queue is empty 
	 * @return boolean value true if the queue is empty, else return false
	 * Runtime: O(1)
	 */
	public boolean isEmpty() {
		if(q[head] == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method returns a string representation of the queue class
	 * @return s String representation of all elements stored in the queue
	 * Runtime: O(N)
	 */
	@Override
	public String toString() {
		if(this.q == null) {
			return "";
		}
		String s = "";
		for(int i = 0; i < q.length; i++) {
			s += this.q[i].toString() + "\n";
		}
		return s;
	}
}
