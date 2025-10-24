package cat.smap.utils.exceptions;

import java.util.Objects;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(Objects.requireNonNullElse(message, "Dades no trobades"));
    }
}
