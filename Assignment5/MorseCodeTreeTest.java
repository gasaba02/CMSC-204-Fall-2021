import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest{


	MorseCodeTree myTree = new MorseCodeTree();

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

		myTree = null;
	}


	@Test
	public void testSetRoot() {

		String myRoot;

		assertEquals("", myTree.getRoot().getData());
		TreeNode<String> myTreeNode = new TreeNode("Stark");
		myTree.setRoot(myTreeNode);

		myRoot = myTree.getRoot().getData();

		assertEquals("Stark", myRoot);
	}

	@Test
	public void testGetRoot() {

		String root;

		root = myTree.getRoot().getData();

		assertEquals("", root);

	}
	
	@Test
	public void testInsert() {

		myTree.insert(".----", "200");
		String letterFetched = myTree.fetch(".----");

		assertEquals("200", letterFetched);
	}


	@Test
	public void testFetch() {

		String fetched_letter1;
		fetched_letter1 = myTree.fetch("-...");
		assertEquals("b", fetched_letter1);



		String fetched_letter2;
		fetched_letter2 = myTree.fetch("...-");
		assertEquals("v", fetched_letter2);

	}


	@Test
	public void testToArrayList() {
		ArrayList<String> myList = new ArrayList<String>();

		myList = myTree.toArrayList();
		assertEquals("h", myList.get(0));
		assertEquals("s", myList.get(1));
		assertEquals("v", myList.get(2));
		assertEquals("i", myList.get(3));
		assertEquals("f", myList.get(4));
		assertEquals("u", myList.get(5));
		assertEquals("e", myList.get(6));
		assertEquals("l", myList.get(7));
		assertEquals("r", myList.get(8));
		assertEquals("a", myList.get(9));
		assertEquals("p", myList.get(10));
		assertEquals("w", myList.get(11));
		assertEquals("j", myList.get(12));
		
		assertEquals("", myList.get(13));
		
		assertEquals("b", myList.get(14));
		assertEquals("d", myList.get(15));
		assertEquals("x", myList.get(16));
		assertEquals("n", myList.get(17));
		assertEquals("c", myList.get(18));
		assertEquals("k", myList.get(19));
		assertEquals("y", myList.get(20));
		assertEquals("t", myList.get(21));
		assertEquals("z", myList.get(22));
		assertEquals("g", myList.get(23));
		assertEquals("q", myList.get(24));
		assertEquals("m", myList.get(25));
		assertEquals("o", myList.get(26));
		
		for(String i : myList) {
		System.out.println(i);
		}

	}
}

