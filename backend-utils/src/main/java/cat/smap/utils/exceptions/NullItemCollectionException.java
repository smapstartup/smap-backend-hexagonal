package cat.smap.utils.exceptions;

public class NullItemCollectionException extends RuntimeException {
    public NullItemCollectionException(String collection) {
        super("L'objecte ítem no pot ser null en fase de persistència dins la col·lecció: " + collection);
    }
}
