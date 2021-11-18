import java.util.ArrayList;
/**
 * This is a morsecode tree class which is used to convert morse code to english
 * @author Germain Asaba
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private String myFetchedLetter;
	private TreeNode<String> root;


	/**
	 * This is a constructor that calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * This method returns a reference to the root
	 * @return The reference of the root
	 */
	@Override
	public TreeNode<String> getRoot() {

		return this.root;
	}

	/**
	 * This method sets the root of the morsecode tree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;

	}

	/**
	 * This method adds an element to the correct position on the tree using its code by 
	 * calling the recursive add method
	 * @param code The code of the element to be added
	 * @param result The result of the the added code
	 * 
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	/**
	 * This is a recursive method that adds an element to the correct tree based on the code
	 * @param root The root of the tree for this addNode instance
	 * @param code The code for this addNode instance
	 * @param letter The data of the added node
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.equals(".")) {
				root.leftChild = new TreeNode<String>(letter);
			}
			else if(code.equals("-")) {
				root.rightChild = new TreeNode<String>(letter);
			}
			return;
		}else {
			if(code.substring(0, 1).equals(".")) {
				addNode(root.leftChild, code.substring(1), letter);
			}
			else {
				addNode(root.rightChild, code.substring(1), letter);
			}
		}

	}

	/**
	 * This method fetches the data on the tree based on the code by calling the fetchNode method
	 * @param code The code of the data being fetched
	 * @return The sting that matches the code
	 */
	@Override
	public String fetch(String code) {
		String myLetter;
		myLetter = fetchNode(root, code);

		return myLetter;
	}

	/**
	 * The is a recursive method that fetches the data of the tree node that matches with the code
	 * @param root The root of the tree for this addNode instance
	 * @param code The code for this addNode instance
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1) {
			if(code.equals(".")) {
				myFetchedLetter = root.leftChild.getData();
			}
			else if(code.equals("-")) {
				myFetchedLetter = root.rightChild.getData();
			}
		}
		else {
			if(code.substring(0, 1).equals(".")) {
				fetchNode(root.leftChild, code.substring(1));
			}
			else {
				fetchNode(root.rightChild, code.substring(1));
			}
		}

		return myFetchedLetter;
	}


	/**
	 * This method builds the tree by inserting the nodes to each level based on the code.
	 */
	@Override
	public void buildTree() {
		root = new TreeNode<String>("");
		//level one
		insert(".", "e");
		insert("-", "t");
		//level two
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		//level three
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		//level four
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q"); 

	}

	/**
	 * This is a recursive method that puts the elements into an array in (inorder)
	 * @param root The root of the tree
	 * @param list The arraylist where all the elements will be put into
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			LNRoutputTraversal(root.leftChild, list);
			list.add(root.getData());

			LNRoutputTraversal(root.rightChild, list);
		}

	}

	/**
	 * This methods calls the recursive LNRoutputTraversal to traverse the tree and put 
	 * all the elements of the tree in an array
	 * @return returns the arraylist of all the elements from the tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> myArrayList = new ArrayList<>();

		LNRoutputTraversal(root, myArrayList);
		return myArrayList;
	}



	/**
	 * This method is not supported in the morsecode tree
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method is not supported in the morsecode tree
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}






}
