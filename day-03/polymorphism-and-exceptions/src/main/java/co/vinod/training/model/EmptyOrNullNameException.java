package co.vinod.training.model;

public class EmptyOrNullNameException extends Exception {
    public EmptyOrNullNameException() {
    }

    public EmptyOrNullNameException(String message) {
        super(message);
    }

    public EmptyOrNullNameException(Throwable cause) {
        super(cause);
    }
}
