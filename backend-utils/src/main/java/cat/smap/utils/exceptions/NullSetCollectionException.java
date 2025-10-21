package cat.smap.utils.exceptions;

public class NullSetCollectionException extends RuntimeException{
    public NullSetCollectionException() {
        super("L'objecte set, no pot ser null");
    }
}
