package cat.smap.utils.exceptions;

import java.util.Objects;

public class DuplicateRegisterException extends RuntimeException {
    public DuplicateRegisterException(String message) {
        super(Objects.requireNonNullElse(message, "Error de dades duplicades."));
    }
}
