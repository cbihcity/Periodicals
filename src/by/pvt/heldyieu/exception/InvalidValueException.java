package by.pvt.heldyieu.exception;

public class InvalidValueException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidValueException() {
		super();
	}

	public InvalidValueException(final String message) {
		super(message);
	}
	
	public InvalidValueException(final String message, String value) {
		super(message+"Некорректный параметр : " + value);
	}
}
