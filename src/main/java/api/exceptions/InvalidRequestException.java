package api.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message, Throwable err) {
        super(message,err);
    }
}
