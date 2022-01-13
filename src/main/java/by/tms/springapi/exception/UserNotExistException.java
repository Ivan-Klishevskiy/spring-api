package by.tms.springapi.exception;

public class UserNotExistException extends Exception{
    public UserNotExistException(String message) {
        super(message);
    }
}
