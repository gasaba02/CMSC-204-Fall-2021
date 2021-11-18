/**
 * This class is the tree node class that creates a nodes for the tree
 * @author Germain Asaba
 *
 * @param <T>
 */
public class TreeNode <T>{

	T data;
	TreeNode<T> rightChild;
	TreeNode<T> leftChild;
	
	/**
	 * Constructor to create a new tree with left and right children set to null
	 * and data set to data
	 * @param data This is the data to be stored in the tree node
	 */
	public TreeNode(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/**
	 *
	 * Constructor for making deep copy
	 * @param node Node to make a copy of
	 */
	public TreeNode(TreeNode<T> node) {
	
		new TreeNode<T>(node);
	}

	/**
	 * This method gets the data within the tree nod
	 * @return the data within the tree node
	 */
	public T getData() {
		return data;
	}

	/**
	 * This method sets the data with then tree node
	 * @param data The data to be set
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
