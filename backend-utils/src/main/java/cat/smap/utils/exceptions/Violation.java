package cat.smap.utils.exceptions;

public record Violation(
        String field,
        String value,
        String message,
        String debugMessage
) {}
