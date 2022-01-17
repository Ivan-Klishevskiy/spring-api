package by.tms.springapi.exception.petException;

public class PetAlreadyExistException extends Exception{
    public PetAlreadyExistException(String message) {
        super(message);
    }
}
