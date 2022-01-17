package by.tms.springapi.exception.orderException;

public class OrderNotExistException extends Exception{
    public OrderNotExistException(String message) {
        super(message);
    }
}
