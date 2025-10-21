package cat.smap.utils.rules;

public enum GenericValidationRules {
    ZIP_CODE(
            "Expressió regular per a la validació de codis postals espanyols",
            "^(?:0[1-9]\\d{3}|[1-4]\\d{4}|5[0-2]\\d{3})$",
            """
                    Aquesta expressió regular validarà codis postals compresos entre: 01000 i 52999, per 
                    adequar-nos al territori de la península ibèrica.
                    \s"""
    ),
    ;

    private final String description;
    private final String regex;
    private final String summary;


    GenericValidationRules(String description, String regex, String summary) {
        this.description = description;
        this.regex = regex;
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public String getRegex() {
        return regex;
    }

    public String getSummary() {
        return summary;
    }
}
