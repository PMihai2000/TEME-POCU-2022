package Exceptions;

public class PMCheckedException extends Throwable{
    public PMCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PMCheckedException() {
    }
}
