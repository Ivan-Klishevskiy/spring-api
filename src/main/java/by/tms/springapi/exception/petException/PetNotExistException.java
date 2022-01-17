package by.tms.springapi.exception.petException;

public class PetNotExistException extends Exception{
    public PetNotExistException(String message) {
        super(message);
    }
}
