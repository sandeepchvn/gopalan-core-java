package exception;

public class StudentCountExceededException extends RuntimeException{

	public StudentCountExceededException(String message) {
		super(message);
	}

}
