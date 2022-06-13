package main;

/**
* This program is the AVLPlayerNode test, testing the functions to do basic AVL tree operations
* Known Bugs: None
*
* @author Xingchen Ye
* xingchenye@brandeis.edu
* Apr 13, 2021
* COSI 21B PA2
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AVLPlayerNodeTest {
	Player mike = new Player("Mike", 1, 2400);
	Player sandra = new Player("Sandra", 2, 2300);
	Player eric = new Player("Eric", 3, 2200);
	Player fred = new Player("Fred", 4, 2100);
	
	Player test = new Player("test", 5, 2222);

	@Test
	void testInsert() {
		AVLPlayerNode idTree = new AVLPlayerNode(mike, mike.getID());
		idTree = idTree.insert(sandra, sandra.getID());
		idTree = idTree.insert(eric, eric.getID());
		assertEquals("((Mike)Sandra(Eric))", idTree.treeString());
		
		idTree = idTree.insert(fred, fred.getID());
		assertEquals("((Mike)Sandra(Eric(Fred)))", idTree.treeString());
	}
	
	@Test
	void testDelete() {
		AVLPlayerNode idTree = new AVLPlayerNode(mike, mike.getID());
		idTree = idTree.insert(sandra, sandra.getID());
		idTree = idTree.insert(eric, eric.getID());
		idTree = idTree.insert(fred, fred.getID());
		
		idTree = idTree.delete(eric.getID());
		assertEquals("((Mike)Sandra(Fred))", idTree.treeString());
	}
	
	@Test
	void testRank() {
		AVLPlayerNode eloTree = new AVLPlayerNode(mike, mike.getELO());
		eloTree = eloTree.insert(sandra, sandra.getELO());
		eloTree = eloTree.insert(eric, eric.getELO());
		eloTree = eloTree.insert(fred, fred.getELO());
		
		assertEquals(1, eloTree.getRank(2400));
		assertEquals(2, eloTree.getRank(2300));
		assertEquals(3, eloTree.getRank(2200));
		
		eloTree = eloTree.insert(test, test.getELO());
		assertEquals(3, eloTree.getRank(2222));
		assertEquals(4, eloTree.getRank(2200));
	}
	
	@Test
	void testElo() {
		AVLPlayerNode idTree = new AVLPlayerNode(mike, mike.getID());
		idTree = idTree.insert(sandra, sandra.getID());
		idTree = idTree.insert(eric, eric.getID());
		idTree = idTree.insert(fred, fred.getID());
		
		assertEquals(2400 ,idTree.getPlayer(1).getELO());
		assertEquals(2300 ,idTree.getPlayer(2).getELO());
	}
	
	
}
