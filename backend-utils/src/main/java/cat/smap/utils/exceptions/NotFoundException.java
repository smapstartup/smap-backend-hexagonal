package cat.smap.utils.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String resource) {
        super("No hem trobat cap referència de " + resource);
    }
}
