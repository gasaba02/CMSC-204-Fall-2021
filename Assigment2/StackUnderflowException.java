package application;

public class StackUnderflowException extends Exception {
	
	public StackUnderflowException() {
		super ("The stack is full");
	}
	
	public StackUnderflowException(String message) {
		super(message);
	}

}
