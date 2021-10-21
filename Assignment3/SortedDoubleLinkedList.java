import java.util.Comparator;

import java.util.ListIterator;

/**
 * This class is a generic sorted linked list class that extends the basic linked list class
 * @author Germain Asaba
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T>  extends BasicDoubleLinkedList<T>{

	private Comparator myComparator;

	/**
	 * This is a parameterized constructor
	 * @param comparator2 This is the comparator to compare elements
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {

		super();
		this.myComparator = comparator2;


	}

	/**
	 * This method adds a specified element in the correct position in the sorted linked list
	 * @param data data of the element to be added
	 * @return returns the added element
	 */

	@SuppressWarnings("unchecked")
	public SortedDoubleLinkedList<T> add(T data){
		Node tempNode = new Node(data);
		Node pointer = head;


		if (size == 0) {
			head = tempNode;
			tail = tempNode;
			size++;
			return this;
		}

		else if (myComparator.compare(head.data, data) > 0) {
			tempNode.next = head;
			head.prev = tempNode;
			head = tempNode;
			size++;
			return this;
		}
		else if (myComparator.compare(tail.data, data) < 0 ) {
			tempNode.prev = tail;
			tail.next = tempNode;
			tail = tempNode;
			size++;
			return this;
		}
		while(pointer.next != null) {
			if(myComparator.compare(pointer.next.data, data) > 0) {
				tempNode.next = pointer.next;
				pointer.next.prev = tempNode;
				tempNode.prev = pointer;
				pointer.next = tempNode;
				size++;
				return this;
			}
			pointer = pointer.next;
		}



		return this;

	}

	/**
	 * This method is invalid for a sorted link list so it throws an exception with the appropriate message
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{

		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}


	/**
	 * This method is invalid for a sorted link list so it throws an exception with the appropriate message
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{

		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * This method implements the iterator by calling the super class iterator method
	 */
	public ListIterator<T> iterator() {

		return super.iterator();
	}

	/**
	 * This method implements the remove function by calling the super class remove method
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator ){
		super.remove(data, comparator);
		return this;

	}
}
