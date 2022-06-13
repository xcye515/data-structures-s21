/**
* This program constructs Node data structure that later helps construct the stations on the red line
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/

package main;

public class Node<T> {
	public Node<T> prev;
	public Node<T> next;
	public T element;
	
	/**
	 * This constructor receives an element that will be stored in the value of the node, and it sets the pointer fields to null
	 * @param element the value of the node
	 * Runtime: O(1)
	 */
	public Node(T element) {
		this.element = element;
		this.prev = null;
		this.next = null;
	}
	
	/**
	 * This method receives an element and sets the value of the node to it
	 * @param element the value that we want to update on the node
	 * Runtime: O(1)
	 */
	public void setElement(T element) {
		this.element = element;
	}
	
	/**
	 * This method receives a node object and sets the next pointer point to it
	 * @param next the node that the next pointer points to it
	 * Runtime: O(1)
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * This method receives a node object and sets the prev pointer point to it
	 * @param prev the node that the prev pointer points to it
	 * Runtime: O(1)
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	/**
	 * This method gets the node that the next pointer points to
	 * @return the node that the next pointer points to
	 * Runtime: O(1)
	 */
	public Node<T> getNext() {
		return this.next;
	}
	
	/**
	 * This method gets the node that the prev pointer points to
	 * @return the node that the prev pointer points to
	 * Runtime: O(1)
	 */
	public Node<T> getPrev() {
		return this.prev;
	}
	
	/**
	 * This method gets the value stored in the node
	 * @return the value of the node
	 * Runtime: O(1)
	 */
	public T getElement() {
		return this.element;
	}
	
	/**
	 * This method gives a string representation of the node
	 * @return String the string representation of the value of the node
	 * Runtime: O(1) or depends on the method element.toString()
	 */
	@Override
	public String toString() {
		if(this.element == null) {
			return null;
		}
		return this.element.toString();
	}

}
