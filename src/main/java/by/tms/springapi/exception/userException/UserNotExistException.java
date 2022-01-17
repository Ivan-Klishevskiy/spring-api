package by.tms.springapi.exception.userException;

public class UserNotExistException extends Exception{
    public UserNotExistException(String message) {
        super(message);
    }
}
