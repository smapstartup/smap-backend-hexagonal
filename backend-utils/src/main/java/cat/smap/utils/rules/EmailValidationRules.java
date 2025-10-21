package cat.smap.utils.rules;

public enum EmailValidationRules {
    BASIC(
            "Validació d'expressions regulars simples",
            "^(.+)@(\\S+)$",
            """
                    Només comprova la presència del símbol @ a l'adreça de correu electrònic.\s
                    Si n'hi ha, el resultat de la validació retorna "true" (cert), en cas contrari, el resultat\s
                    és "false" (fals ). Tanmateix, aquesta expressió regular no comprova la part\s
                    local ni el domini del correu electrònic.
                   \s"""
    ),

    STRICT(
            "Validació estricta d'expressions regulars",
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" +
                    "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            """
                    Les restriccions següents s'imposen a la part local de l'adreça de correu\s
                    electrònic mitjançant aquesta expressió regular:\s\s
                    
                    * Admet valors numèrics del 0 al 9.\s
                    * Es permeten tant majúscules com minúscules de la a a la z.\s
                    * Es permeten el subratllat “_”, el guionet “-“ i el punt “”.\s
                    * No es permet el punt al principi ni al final de la part local.\s
                    * No es permeten punts consecutius.\s
                    * Per a la part local, es permet un màxim de 64 caràcters.\s\s
                    
                    Les restriccions per a la part de domini en aquesta expressió regular inclouen:\s
                    * Admet valors numèrics del 0 al 9.\s
                    * Permetem majúscules i minúscules de la a a la z.\s
                    * No es permeten guions "-" ni punts "." al principi ni al final de la part del domini.\s
                    * Sense punts consecutius.\s
                    \s"""
    ),

    UNICODE(
            "Expressió regular per a la validació de caràcters no llatins o Correu electrònic Unicode",
            "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@" +
                    "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$",
            """
                    Podem utilitzar aquesta expressió regular per validar adreces de correu electrònic Unicode o\s
                    no llatines per admetre tots els idiomes.
                    \s"""
    ),

    RFC_5322(
            "Expressió regular segons RFC 5322 per a la validació de correus electrònics",
            "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@" +
                    "[a-zA-Z0-9.-]+$",
            """
                    L' RFC 5322 , que és una versió actualitzada de l'RFC 822 , proporciona una\s
                    expressió regular per a la validació de correus electrònics.
                    \s"""
    ),

    SUPERIOR_DOMAIN(
            "Expressió regular per comprovar caràcters al domini de nivell superior",
             "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@" +
                     "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
            """
                    Aquesta expressió regular bàsicament comprova si l'adreça de correu electrònic només té un punt\s
                    i que hi ha un mínim de dos i un màxim de sis caràcters presents al domini de nivell superior.\s
                    \s"""
    ),

    MULTIPLES_PUNTS(
        "Expressió regular per restringir els punts consecutius, finals i inicials",
            "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@" +
                    "[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            """
                    Aquesta expressió regular s'utilitza per restringir els punts consecutius, inicials i finals. \s
                    Per tant, un correu electrònic pot contenir més d'un punt, però no consecutius\s
                    a les parts local i de domini.
                    \s"""
    ),

    OWASP(
            "Expressió regular de validació OWASP",
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            """
                    Aquesta expressió regular la proporciona el repositori d'expressions regulars de\s
                     validació d'OWASP per comprovar la validació del correu electrònic
                    \s"""
    ),

    SPECIAL_GMAIL(
            "Cas especial de Gmail per a correus electrònics",
            "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@" +
                    "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$",
            """
                    Hi ha un cas especial que només s'aplica al domini de Gmail: és el permís per utilitzar\s
                     el caràcter + caràcter a la part local del correu electrònic. Per al domini de Gmail, les dues\s
                      adreces de correu electrònic nom d'usuari+alguna cosa@gmail.com i\s
                       nom d'usuari@gmail.com són iguals.
                    \s"""
    ),

    ;

    private final String description;
    private final String regex;
    private final String summary;


    EmailValidationRules(String description, String regex, String summary) {
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
