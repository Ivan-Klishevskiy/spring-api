package by.tms.springapi.exception.orderException;

public class OrderAlreadyExistException extends Exception{
    public OrderAlreadyExistException(String message) {
        super(message);
    }
}
