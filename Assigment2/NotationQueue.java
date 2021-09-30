package application;

import java.util.ArrayList;
/**
 * This is a class that simulates a queue
 * @author Germain Asaba
 *
 * @param <T>
 */


public class NotationQueue<T> implements QueueInterface<T>{

	private  int frontIndex;
	private  int rearIndex;
	private static final int DEFAULT_CAPACITY = 100;
	private T[] myQueue;
	private  int maxSize;
	int count;

	/**
	 * This is a default constructor
	 */
	public NotationQueue() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * This is a parameterized constructor
	 * @param size the size of the queue
	 */
	public NotationQueue(int size) {

		@SuppressWarnings("unchecked")
		T[] tempMyQueue = (T[])new Object[size];
		this.myQueue = tempMyQueue;
		maxSize = size;
		frontIndex = 0;
		rearIndex = 0;
		this.count = 0;
	}


	/**
	 * This method checks if the queue is empty
	 * @return returns true if it is empty or false if not
	 */
	@Override
	public boolean isEmpty() {

		return (count == 0);
	}

	/**
	 * This method checks if the queue is full
	 * @return returns true if it is full of false otherwise
	 */
	@Override
	public boolean isFull() {
		if(myQueue.length == count ) {
			return true;
		}
		return false;
	}

	/**
	 * This method removes elements from the queue
	 * @throws throws an exception if the queue is empty
	 * @return returns true if the removal was successful or false otherwise
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T front;
		if(isEmpty()) {

			throw new QueueUnderflowException();
		}
		else {
			if(frontIndex == myQueue.length - 1) {
				front = myQueue[frontIndex];
				myQueue[frontIndex] = null;
				frontIndex = 0;
				count--;
				return front;
			}
			else {
				front = myQueue[frontIndex];
				myQueue[frontIndex] = null;
				frontIndex++;
				count--;
				return front;
			}

		}

	}

	/**
	 * This method keeps track of the size of the queue
	 * @return returns the size of the queue
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * This method adds an element to the queue
	 * @return returns true of the addition was successful
	 * @throws throws an exception if the queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {

		if(isEmpty()) {
			rearIndex = 0;
			frontIndex = 0;
			myQueue[rearIndex] = e;
			count++;
			return true;

		}else if(isFull()) {
			throw new QueueOverflowException();
		}
		else {
			if(rearIndex == myQueue.length - 1 ) {
				rearIndex = 0;
				myQueue[rearIndex] = e;
				count++;
				return true;
			}
			else {
				rearIndex++;
				myQueue[rearIndex] = e;
				count++;
				return true;
			}
		} 


	}

	/**
	 * This method returns a string representation of the queue
	 * @return returns the queue elements in the form of strings
	 */
	@Override
	public String toString() {
		String result = "";
		if(frontIndex <= rearIndex) {
			for(int i = frontIndex; i <= rearIndex; i++) {
				result +=  myQueue[i];

			}
		}
		else {
			for(int i = frontIndex; i < myQueue.length; i++ ) {
				result += myQueue[i];
			}

			for(int i = 0; i <= rearIndex; i++ ) {
				result += myQueue[i];
			}
		}
		return result;

	}

	/**
	 * This method returns a string representation of the queue with the delimiter placed between each element
	 * @param Delimiter this is placed between each element of the queue
	 * @return return the queue as strings with the delimiter placed between each string
	 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		if(frontIndex <= rearIndex) {
			for(int i = frontIndex; i <= rearIndex; i++) {
				if(i == count - 1) {
					result +=  myQueue[i];
				}else {
					result +=  myQueue[i]+ delimiter;
				}

			}
		}
		else {
			for(int i = frontIndex; i < myQueue.length; i++ ) {
				if(i == count - 1 ) {
					result += myQueue[i];
				}
				result += myQueue[i]+ delimiter;
			}

			for(int i = 0; i <= rearIndex; i++ ) {

				result += myQueue[i] + delimiter;
			}
		}
		return result;
	}

	/**
	 * This method fills the queue with elements from an arraylist. First element is
	 * the arraylist is the first elememt in the queue
	 * @param list the arraylist with elements ti fill the queue
	 */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> copyArrayList = new ArrayList<T>();
		for(T data : list) {
			copyArrayList.add(data);
		}
		for(T data : copyArrayList) {
			try {
				enqueue(data);
			} catch (QueueOverflowException e) {
				e.printStackTrace();
			}
		}

	}


}
