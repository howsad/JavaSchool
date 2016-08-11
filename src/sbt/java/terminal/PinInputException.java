package sbt.java.terminal;

public class PinInputException extends Exception {

    public PinInputException() {
    }

    public PinInputException(String message) {
        super(message);
    }

    public PinInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public PinInputException(Throwable cause) {
        super(cause);
    }
}
