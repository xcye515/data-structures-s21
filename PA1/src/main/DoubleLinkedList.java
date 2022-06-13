/**
* This program constructs a double linked list data structure that later helps construct the stations on the red line
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Mar 21, 2021
* COSI 21A PA1
*/

package main;

public class DoubleLinkedList<T> {
	public Node<T> first;
	public Node<T> end;
	
	/**
	 * This constructor sets the default first and end nodes to null
	 * Runtime: O(1)
	 */
	public DoubleLinkedList() {
		this.first = null;
		this.end = null;
	}
	
	/**
	 * This method gets the first node in the double linked list
	 * @return the first node in the double linked list
	 * Runtime: O(1)
	 */
	public Node<T> getFirst() {
		return this.first;
	}
	
	/**
	 * This method receives an element and creates a new node with the value of the element, and then it inserts the node to the end of the list
	 * @param element that we want to add to the end of the list
	 * Runtime: O(1)
	 */
	public void insert(T element) {
		Node<T> n = new Node<T>(element);
		if(this.first == null) {
			this.first = n;
			this.end = n;
		} else {
			this.end.setNext(n);
			n.setNext(null);
			n.setPrev(this.end);
			this.end = n;
		}
	}
	
	/**
	 * This method receives a key and deletes the first element from the list that matches the provided key
	 * @param key element that we want to delete from the list
	 * @return key if the element is found in the list and successfully removed, null if the key is not found in the list
	 * Runtime: O(N)
	 */
	public T delete(T key) {
		Node<T> L = this.first;
		while(L != null) {
			if(L.getElement() == key) {
				if(L == this.first) {
					if(L.getNext() != null) {
						L.getNext().setPrev(null);
						this.first = L.getNext();
						return key;
					} else {
						this.first = null;
						this.end = null;
						return key;
					}
				} else if (L == this.end) {
					L.getPrev().setNext(null);
					this.end = L.getPrev();
					return key;
				} else {
					L.getPrev().setNext(L.getNext());
					L.getNext().setPrev(L.getPrev());
					L.setPrev(null);
					L.setNext(null);
					return key;
				}
			}
			L = L.getNext();
			}
		return null;
	}
	
	/**
	 * This method receives a key and gets the first element in the list that matches the provided key
	 * @param key the element that we want to find in the list
	 * @return key if the element is found in the list, null otherwise
	 * Runtime: O(N)
	 */
	public T get(T key) {
		Node<T> L = this.first;
		while(L != null) {
			if(L.getElement().equals(key)) {
				return L.getElement();
			}
			L = L.getNext();
		}
		return null;
	}
	
	/**
	 * This method gives the size of the list, that is the number of nodes in the list
	 * @return num int the number of nodes in the list
	 * Runtime: O(N)
	 */
	public int size() {
		int num = 0;
		Node<T> L = this.first;
		while(L != null) {
			num++;
			L = L.getNext();
		}
		return num;
	}
	
	/**
	 * This method gives the string representation of the double linked list
	 * @return s the string representation of all nodes in the list
	 * Runtime: O(N)
	 */
	@Override
	public String toString() {
		Node<T> L = this.first;
		String s = "";
		while(L != null) {
			s += L.toString() + "\n";
			L = L.getNext();
		}
		return s;
	}
}
