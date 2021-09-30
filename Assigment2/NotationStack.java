package application;

import java.util.ArrayList;
/**
 * This is generic stack data structure class
 * @author Germain Asaba
 *
 * @param <T>
 */

public class NotationStack<T> implements StackInterface<T> {

	private T[] myStack;
	private int stackTop;
	int stackSize;
	private static final int DEFAULT_SIZE = 100;
	int size;


	/**
	 * Default constructor
	 */
	public NotationStack() {
		this(DEFAULT_SIZE);
	}

	/**
	 * Parameterized constructor
	 * @param initialSize the size of the stack
	 */
	public NotationStack(int initialSize) {
		@SuppressWarnings("unchecked")
		T[] tempStackNotation = (T[]) new Object[initialSize];
		myStack = tempStackNotation;
		stackSize = initialSize;
		stackTop = -1;
		size = 0;
	}

	/**
	 * This method checks if the stack is empty
	 * @return returns true if the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		if(stackTop == -1) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks of the stack is full 
	 * @return returns true if the stack is full
	 */
	@Override
	public boolean isFull() {
		if(myStack.length == size) {
			return true;
		}
		return false;
	}

	/**
	 * This method removes whatever element is at the top of the stack
	 * @return returns the element that was removed
	 * @throws StackUnderflowException throws an exception if the stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()) {
			T top = myStack[stackTop];
			myStack[stackTop] = null;
			stackTop--;
			size--;
			return top;

		}

		throw new StackUnderflowException();
	}

	/**
	 * This method checks whatever element is at the top of the stack
	 * @return The element at the top of the stack
	 * @throws StackUnderflowException throws an exception if the stack is empty  
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(!isEmpty()) {
			return myStack[stackTop];
		}
		throw new StackUnderflowException();
	}

	/**
	 * This method keeps trackof  the size of the stack
	 * @return returns the size of the stack
	 */
	@Override
	public int size() {
		
		return size;
	}

	/**
	 * This method adds an element to the top of the stack
	 * @param e the element that is to be added to the stack
	 * @return returns true if the element was added to the stack
	 * @throws StackOverflowException throws an exception if the stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(!isFull()) {
			myStack[stackTop + 1] = e;
			stackTop++;
			size++;
			return true;
		}

		throw new StackOverflowException();
	}
	
	/**
	 * This method puts all the elements in the stack in a String format
	 * @return returns the elements in the stack in a String format
	 */
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < size; i++) {
			result += myStack[i];
		}
		
		return result;
		
	}

	/**
	 * This method puts all the elements in the stack in a String format and 
	 * puts a delimiter between each element
	 * @return returns the elements in the stack in a String format with the
	 * delimiter between each element
	 * @return returns the elements
	 * 
	 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for(int i = 0; i < size; i++) {
			if(i == (size - 1)) {
				result += myStack[i];
			}else {
			result += myStack[i] + delimiter;
			}
		}
		
		return result;
	}

	/**
	 * This method fills the stack with elements of an Arraylist. 
	 * The first element of the Arraylist is the bottom of the stack
	 * @param the Arraylist
	 */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> copyArrayList = new ArrayList<T>();
		for(T data: list ) {
			copyArrayList.add(data);
		}
		for(T data:copyArrayList ) {
			try {
				push(data);
			} catch (StackOverflowException e) {
		
				e.printStackTrace();
			}
		
		}

	}

}
