package cat.smap.utils.exceptions;

import java.util.List;

public class FunctionalValidationException extends RuntimeException{

    private final List<Violation> violations;

    public FunctionalValidationException(List<Violation> violations) {
        super();
        this.violations = violations;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public boolean hasViolations() {
        return !violations.isEmpty();
    }
}
