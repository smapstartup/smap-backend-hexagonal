package cat.smap.utils.logging;

public enum LogChannel implements TestsInfo {
    ASSERTS("[ASSERT]", "Asserció de %s", "logs/asserts.log"),
    DEBUG("[DEBUG]", "Informació general", "logs/info.log"),
    INFO("[INFO]", "Informació general", "logs/info.log"),
    WARNING("[WARNING]", "Errors no crítics, deprecated, etc", "logs/warning.log"),
    ERROR("[ERROR]", "Errors crítics del sistema", "logs/errors.log"),
    FT("[FUNCTIONAL-TEST]", "Tests funcionals", "logs/functional-tests.log"),
    UT("[UNIT-TEST]", "Tests unitaris", "logs/unit-tests.log"),
    IT("[INTEGRATION-TEST]", "Tests d'integració", "logs/integration-tests.log"),
    LOG("[LOG]", "Logs generals", "logs/system.log"),
    ISSUES("[ISSUES]", "Bugs, problemes, assumptes a revisar", "logs/system-issues.log"),
    SUCCESS("[SUCCESS]", "Processos escritura, persistencia, altres que acaben en èxit", "logs/success.log"),
    ;

    private final String label;
    private final String summary;
    private final String filename;

    LogChannel(String label, String summary, String filename){
        this.label = label;
        this.summary = summary;
        this.filename = filename;
    }

    @Override
    public String label() {
        return this.label;
    }

    @Override
    public String summary() {
        return this.summary;
    }

    @Override
    public String filename() {
        return this.filename;
    }
}
