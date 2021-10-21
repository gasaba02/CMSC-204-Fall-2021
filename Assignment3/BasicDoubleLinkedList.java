import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * This is a generic doubly linked list class with an inner node and iterator class
 * @author Germain Asaba
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

	Node head;
	Node tail;
	int size;

	/**
	 * This is an inner node class for the doubly linked list
	 * @author Germain Asaba
	 *
	 */
	class Node{
		T data;
		Node next;
		Node prev;

		/**
		 * This is the parameterized constructor for the inner node class
		 * @param data This is the data for the node when it's created
		 */
		@SuppressWarnings("unused")
		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data + "";
		}
	}

	/**
	 * This is the default contructor that sets the head and tail to null the the size of the list to 0
	 */
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}


	/**
	 * This method keeps track of the size using the variable size
	 * @return Returns the size of the list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This method adds an element to the front of the list
	 * @param data The data for the node added
	 * @return returns a reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node myNode = new Node(data);

		if(size == 0) {
			head = myNode;
			tail = myNode;
			size++;
		} else {
			head.prev = myNode;
			myNode.next = head;
			head.prev = myNode;
			head = myNode;
			size++;
		}
		return this;

	}

	/**
	 * This method adds an element the end of the list
	 * @param data The data of the node added
	 * @return returns a reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){

		Node my2nNode = new Node(data);
		if(size == 0) {
			head = my2nNode;
			tail = my2nNode;
			head.prev = null;
			tail.next = null;
			size++;
		}
		else {
			tail.next = my2nNode;
			my2nNode.prev = tail;
			tail = my2nNode;
			tail.next = null;
			size++;
		}

		return this;

	}


	/**
	 * This method gets the first element in the list
	 * @return Returns the first elemet in the lsit
	 */
	public T getFirst() {

		return head.data;
	}

	/**
	 * This method gets the last element in the list
	 * @return Returns the last element in the list
	 */
	public T getLast() {

		return tail.data;

	}

	/**
	 * This method uses and inner class that implements ListIterator and has methods the methods of hasNext(), next(), hasPrevious() and previous()
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{

		/**
		 * This is an iterator class that implements ListIterator
		 * @author Germain Asaba
		 *
		 */
		class myIterator implements ListIterator{

			Node current = head;
			Node last = tail;


			/**
			 * This method checks the list if it has a next element
			 */
			@Override
			public boolean hasNext() {
				return current != null;
			}

			/**
			 * This method iterates to the next element in the list
			 * @throws NoSuchElementException Throws NoSuchElementException if it's at the end of the list
			 */
			@Override
			public Object next() throws NoSuchElementException {
				T data;
				if(hasNext()) {
					data = current.data;
					current = current.next;
					return data;
				}
				throw new NoSuchElementException();
			}

			/**
			 * This method checks if there is a previous element in the list
			 */
			@Override
			public boolean hasPrevious() {
				boolean result = last != null;
				return  result;
			}

			/**
			 * This method iterates to the previous element in the list
			 * @throws NoSuchElementException Throws NoSuchElementException if it's at the start of the list
			 */
			@Override
			public Object previous() throws NoSuchElementException {
				T data;
				if(hasPrevious()) {
					data = last.data;
					last = last.prev;
					return data;
				}
				throw new NoSuchElementException();
			}

			@Override
			public int nextIndex() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();

			}

			@Override
			public int previousIndex() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();

			}

			@Override
			public void remove() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();

			}

			@Override
			public void set(Object e) throws UnsupportedOperationException {
				throw new UnsupportedOperationException();

			}

			@Override
			public void add(Object e) throws UnsupportedOperationException {
				throw new UnsupportedOperationException();

			}

		}
		return new myIterator();

	}

	/**
	 * This method removes the first instance of a target data from the list
	 * @param targetData The target data of the node to be removed
	 * @param comparator The comparator that checks equality of the elements
	 * @return Returns the data element of null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node tempNode = head;

		if(comparator.compare(targetData, head.data) == 0) {
			head = head.next;
			head.prev = null;
			size--;
			return null;
		}
		else if(comparator.compare(targetData, tail.data) == 0) {
			tail = tail.prev;
			tail.next = null;
			size--;
			return null;
		}

		while(tempNode != null) {
			if(comparator.compare(targetData, tempNode.data) == 0) {
				tempNode.next.prev = tempNode.prev;
				tempNode.prev.next = tempNode.next;
				size--;

			}
			tempNode = tempNode.next;
		}

		return this;

	}

	/**
	 * This method removes and returns the first element of the list
	 * @return Returns the first element or null
	 */
	public T retrieveFirstElement() {
		if(head == null) {
			return null;
		}
		Node tempNode = head;
		head = head.next;
		T data = head.prev.data;
		head.prev = null;
		size--;
		return data;

	}

	/**
	 * This method removes and returns the last element of the list
	 * @return Returns the last element of the list or null
	 */
	public T retrieveLastElement() {
		if(tail == null) {
			return null;
		}
		Node tempNode = tail;
		tail = tail.prev;
		T data = tail.next.data;
		tail.next = null;
		size--;
		return data;

	}

	/**
	 * This method puts the elements from start to end of the list in an array list
	 * @return Returns the array list with the elements
	 */
	public ArrayList<T> toArrayList(){

		ArrayList<T> myArrayList = new ArrayList<>();
		Node temp = head;
		while(temp != null) {
			myArrayList.add(temp.data);
			temp = temp.next;
		}
		return myArrayList;

	}



}
