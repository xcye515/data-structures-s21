package main;

/**
* This program constructs a AVLPlayerNode object with three properties and methods that help us to get the properties
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Apr 13, 2021
* COSI 21B PA2
*/

public class AVLPlayerNode{
    private Player data;
    private double value;
    private AVLPlayerNode parent;
    private AVLPlayerNode leftChild;
    private AVLPlayerNode rightChild;
    private int rightWeight;
    private int balanceFactor;
    private int height;
    
    public AVLPlayerNode(Player data,double value){
        this.data = data;
        this.value = value;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.rightWeight = 0;
        this.balanceFactor = 0;
    }
    
    /**
     * These methods returns the new root of the tree after inserting a node containing the received Player object and double value. The tree is also self-balancing after the insertion of the node
     * @param newGuy Player object 
     * @param value the Elo rating/the ID of the player
     * @return AVLPlayerNode the new node of the AVL tree
     */
    public AVLPlayerNode insert(Player newGuy, double value) {
    	AVLPlayerNode node = this.insertNode(newGuy, value);
    	node.updateAll(node); //update the right weights for all nodes in the tree
    	return node;
    }
    
    public AVLPlayerNode insertNode(Player newGuy, double value) {
    	AVLPlayerNode pointer = this;
    	if(value < pointer.value) {
    		if(pointer.leftChild != null) {
    			pointer.leftChild = pointer.leftChild.insertNode(newGuy, value);
    		} else {
    			AVLPlayerNode node = new AVLPlayerNode(newGuy, value);
    			pointer.leftChild = node;
    			node.parent = pointer;
    		}
    	} else if (value > pointer.value) {
    		if(pointer.rightChild != null) {
    			pointer.rightChild = pointer.rightChild.insertNode(newGuy, value);
    		} else {
    			AVLPlayerNode node = new AVLPlayerNode(newGuy, value);
    			pointer.rightChild = node;
    			node.parent = pointer;
    		}
    	} 
    	return this.balanced();
    	}
    
    /**
     * These methods returns the new root of the BST tree after deleting a node of the given value from the tree.
     * @param value the Elo rating/the ID of the player
     * @return AVLPlayerNode the new node of the AVL tree
     */
    public AVLPlayerNode delete(double value) {
    	AVLPlayerNode node = this.deleteNode(value);
    	node.updateAll(node); //update the right weight of all nodes in the tree
    	return node;
    }
    
    public AVLPlayerNode deleteNode(double value){
    	AVLPlayerNode pointer = this.getNode(value);
    	AVLPlayerNode localRoot = null;
    	if(pointer == null) {
    		return null;
    	}
    	if(pointer.rightChild == null && pointer.leftChild == null) { // Case 1: the node has no children
    		if(pointer.parent == null) {
    			return null;
    		} else {
    			localRoot = pointer.parent.parent;
    			if(pointer == pointer.parent.leftChild) {
    				pointer.parent.leftChild = null;
    			} else if(pointer == pointer.parent.rightChild) {
    				pointer.parent.rightChild = null;
    			}
    		}
    	} else if(pointer.leftChild == null && pointer.rightChild != null) { // Case 2.1: the node has one left child
    		if(pointer.parent == null) {
    			return pointer.rightChild;
    		} else {
    			localRoot = pointer.parent;
    			if(pointer == pointer.parent.leftChild) {
    				pointer.parent.leftChild = pointer.rightChild;
    				pointer.rightChild.parent = pointer.parent;
    			} else if(pointer == pointer.parent.rightChild) {
    				pointer.parent.rightChild = pointer.rightChild;
    				pointer.rightChild.parent = pointer.parent;
    			}
    		}
    	} else if (pointer.leftChild != null && pointer.rightChild == null) { // Case 2.2: the node has one right child
    		if(pointer.parent == null) {
    			return pointer.leftChild;
    		} else {
    			localRoot = pointer.parent;
    			if(pointer == pointer.parent.leftChild) {
    				pointer.parent.leftChild = pointer.leftChild;
    				pointer.leftChild.parent = pointer.parent;
    			} else if(pointer == pointer.parent.rightChild) {
    				pointer.parent.rightChild = pointer.leftChild;
    				pointer.leftChild.parent = pointer.parent;
    			}
    		}
    	} else if (pointer.leftChild != null && pointer.rightChild != null) { // Case 3: the node has two children
    		pointer.value = pointer.rightChild.deleteMinimum();
    	}
    	
    	if(localRoot == null) {
    		this.height();
    		return this;
    	} else {
    		return localRoot.balanced();
    	}
    	
    }
    
    /**
     * This method returns the tree node after balancing it
     * @return AVLPlayerNode tree node after balanced
     */
    private AVLPlayerNode balanced() {
    	this.height();
    	int balance = this.balanceFactor();
    	AVLPlayerNode newRoot = null; 
    	if(balance > 1) {
    		if(this.leftChild.balanceFactor() >= 0) {
    			this.rotateRight();
    			newRoot = this.parent; // if the tree rotates, then the root of the tree is updated
    		} else {
    			this.rotateLR();
    			newRoot = this.parent;
    		}
    	} else if(balance < -1) {
    		if(this.rightChild.balanceFactor() <= 0) {
    			this.rotateLeft();
    			newRoot = this.parent;
    		} else {
    			this.rotateRL();
    			newRoot = this.parent;
    		}
    	}
    	if(newRoot == null) {
    		return this;
    	} else {
    		return newRoot;
    	}
    }
    
    
    /**
     * This method deletes the node of the minimum value from the tree, and it returns the minimum value
     * @return double value the minimum value of the tree
     */
    private double deleteMinimum() {
    	AVLPlayerNode p = this;
    	while(p.leftChild != null) {
    		p = p.leftChild;
    	}
    	delete(p.value);
    	return p.value;
    }
    
    private int balanceFactor() {
    	return this.balanceFactor;
    }
    
    /**
     * This method updates the height of the nodes of the tree and returns the height of the root node 
     * @return int value the height of the tree root
     */
    private int height() {
    	int l = -1;
    	int r = -1;
    	if(this.leftChild != null) {
    		l = this.leftChild.height();
    	} 
    	if(this.rightChild != null) {
    		r = this.rightChild.height();
    	} 
    	this.height = Math.max(l,r) + 1;
    	this.balanceFactor = l - r;
    	return this.height;
    }
    
    /**
     * This method rotates a left-heavy tree to right
     */
    private void rotateLeft(){
    	AVLPlayerNode n = this.rightChild;
    	this.rightChild = n.leftChild;
    	if(n.leftChild != null) {
    		n.leftChild.parent = this;
    	}
    	n.parent = this.parent;
    	if(this.parent != null) {
    		if(this.parent.leftChild != null && this == this.parent.leftChild) {
        		this.parent.leftChild = n;
        	} else if(this.parent.rightChild != null && this == this.parent.rightChild) {
        		this.parent.rightChild = n;
        	}
    	}
    	n.leftChild = this;
    	this.parent = n;
    }
    
    /**
     * This method rotates a right-heavy tree to left
     */
    private void rotateRight(){
    	AVLPlayerNode n = this.leftChild;
    	this.leftChild = n.rightChild;
    	if(n.rightChild != null) {
    		n.rightChild.parent = this;
    	}
    	n.parent = this.parent;
    	if(this.parent != null) {
    		if(this.parent.leftChild != null && this == this.parent.leftChild) {
        		this.parent.leftChild = n;
        	} else if(this.parent.rightChild != null && this == this.parent.rightChild) {
        		this.parent.rightChild = n;
        	}
    	}
    	n.rightChild = this;
    	this.parent = n;
    }
    /**
     * This method rotates the left child of a tree root to left, and it rotates the tree root to right
     */
    private void rotateLR(){
    	this.leftChild.rotateLeft();
    	this.rotateRight();
    }
    
    /**
     * This method rotates the right child of a tree root to right, and it rotates the tree root to left
     */
    private void rotateRL() {
    	this.rightChild.rotateRight();
    	this.rotateLeft();
    }
	
    /**
     * This method should return the Player object stored in the node with this.value == value
     * @param value the received elo rating/ID 
     * @return a Player that has the value equals to the received value
     */
    public Player getPlayer(double value){
    	return this.getNode(value).data;
    }
    
    /**
     * This method should return the AVLPlayerNode object such that this.value == value
     * @param value the received elo rating/ID 
     * @return a AVLPlayerNode object that has the value equals to the received value
     */
    private AVLPlayerNode getNode(double value) {
    	AVLPlayerNode a = null;
    	if(this.value == value) {
    		return this;
    	}
    	if(this.value > value) {
    		if(this.leftChild != null) {
    			a = this.leftChild.getNode(value);
    		} 
    	} else if (this.value < value) {
    		if(this.rightChild != null) {
    			a = this.rightChild.getNode(value);
    		} 
    	} 
    	return a;
    }
    
    /**
     * This method returns the rank of the node with this.value == value
     * @param value the value that we want to look for in the tree
     * @return int the rank of the player (ranking its value from from high to low
     */
    public int getRank(double value) {
    	return rank(value,this);
    	
    }
    
    /**
     * This method receives a root node and a value, and it looks for the rank of the value in the tree
     * @param value double the value that we look for in the tree
     * @param node AVLPlayerNode 
     * @return int the number of nodes in its right subtree
     */
    private int rank(double value, AVLPlayerNode node) {
    	if(node == null) {
    		return 0;
    	}
    	if (value > node.value) {
    		return rank(value, node.rightChild);
    	} else if(value < node.value) {
    		return rank(value, node.leftChild) + 1 + numNodes(node.rightChild);
    	} else {
    		return numNodes(node.rightChild) + 1;
    	}
    }
    
    /**
     * This method updates the right weight of all the tree nodes
     */
    private void updateAll(AVLPlayerNode p) {
    	if (this.rightChild != null) {
    		this.rightChild.updateAll(p);;
    	}
    	this.rightWeight = rank(this.value, p) - 1;
    	if (this.leftChild != null) {
    		this.leftChild.updateAll(p);;
    	}
    }
    
    /**
     * This method counts the number of nodes in its subtrees (also containing itself
     * @param node the tree root
     * @return int the number of nodes in its subtrees
     */
    private int numNodes(AVLPlayerNode node) {
    	if(node == null) {
    		return 0;
    	} else {
    		return numNodes(node.leftChild) + numNodes(node.rightChild) + 1;
    	}
    }

    /**
     * This returns a string representation of the tree, which contains the names with parentheses separating subtrees
     * @return s String the string representation of the tree
     */
    public String treeString(){
    	String s = "(";
    	if(this.leftChild != null) {
    		s += this.leftChild.treeString();
    	}
    	s += this.data.getName();
    	if(this.rightChild != null) {
    		s += this.rightChild.treeString();
    	}
    	s += ")";
    	return s;
    }

    /**
     * This returns a string which is the formatted scoreboard in descending order of value
     * @return s representing the formatted scoreboard
     */
    public String scoreboard(){
    	String s = "NAME      ID      SCORE \n";
    	return s + this.reverseInorder() + "\n";
    }
    
    /**
     * This method conduct a reversed inorder traversal of the tree
     * @return
     */
    private String reverseInorder() {
    	String s = "";
    	if(this.rightChild != null) {
    		s = s + this.rightChild.reverseInorder();
    	}
    	s = s + this.data.getName() + "   " + this.data.getID() +  "   " + this.data.getELO() + "\n";
    	if(this.leftChild != null) {
    		s = s + this.leftChild.reverseInorder();
    	}
    	return s;
    }
	
}