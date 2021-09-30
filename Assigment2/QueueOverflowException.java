package application;

public class QueueOverflowException extends Exception {
	
	public QueueOverflowException() {
		super("The queue is empty");
		
	}
	
	public QueueOverflowException(String message) {
		super(message);
	}

}
