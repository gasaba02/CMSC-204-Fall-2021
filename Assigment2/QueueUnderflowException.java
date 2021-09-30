package application;

public class QueueUnderflowException extends Exception {
	
	public QueueUnderflowException() {
		super("The queue is full");
	}
	
	public QueueUnderflowException(String message) {
		super(message);
	}

}
