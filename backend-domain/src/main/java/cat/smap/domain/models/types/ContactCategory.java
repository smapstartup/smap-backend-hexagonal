package cat.smap.domain.models.types;

public enum ContactCategory {
    DEFAULT("Contacte general"),
    PERSONAL("Contacte personal"),
    WORKER("Contacte de la feina"),
    OTHER("Altre tipus de contacte"),
    PRIVATE("Contacte privat"),
    ;

    private final String definition;

    ContactCategory(String definition) {
        this.definition = definition;
    }

    public String getDefinition() {
        return definition;
    }
}
