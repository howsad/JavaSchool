package sbt.java.terminal;

public class WrongPinException extends PinInputException {
    public WrongPinException() {
    }

    public WrongPinException(String message) {
        super(message);
    }

    public WrongPinException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPinException(Throwable cause) {
        super(cause);
    }
}
