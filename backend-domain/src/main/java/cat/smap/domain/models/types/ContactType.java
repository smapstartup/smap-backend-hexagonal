package cat.smap.domain.models.types;

public enum ContactType {

    MAIL("Correu electrònic"),
    PHONE("Telèfon"),
    ;

    private final String description;

    ContactType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
