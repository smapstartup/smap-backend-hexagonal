package cat.smap.utils.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SmapLogger {

    private static final Logger logger = LoggerFactory.getLogger(SmapLogger.class);

    private String label;
    private String filepath;

    private SmapLogger(LogChannel log, String source){
        this
                .setLabel(log.label())
                .setFilepath(log.filename())
                .writeLog(source);
    }

    public static void consoleLog(LogChannel log, String source){
        new SmapLogger(log, source);
    }

    private void outputTerminal(String output){
        switch (this.getLabel()) {
            case "[WARNING]" -> logger.warn(output);
            case "[INFO]", "[SUCCESS]", "[INTEGRATION-TEST]", "[UNIT-TEST]", "[FUNCTIONAL-TEST]" -> logger.info(output);
            case "[ERROR]" -> logger.error(output);
            case "[LOG]", "[DEBUG]" -> logger.debug(output);
            default -> logger.trace(output);
        }
        if ( this.getLabel().equals("[DEBUG]") ) {
            System.out.println(output);
        }
    }

    private void writeLog(String source){
        try {
            Path path = Paths.get("logs/");
            Files.createDirectories(path);
            String timestamp = java.time.LocalDateTime.now().toString();
            String output = this.getLabel() + " " + timestamp + " " + source;
            try (PrintWriter out = new PrintWriter(new FileWriter(this.getFilepath(), true))) {
                outputTerminal(output);
                out.println(output);
            }
        } catch (IOException e) {
            logger.error("[ERROR] Error escrivint al fitxer de log: {}", this.getFilepath(), e);
        }
    }

    private SmapLogger setFilepath(String filename){
        this.filepath = filename;
        return this;
    }

    private String getFilepath(){
        return this.filepath;
    }

    private SmapLogger setLabel(String label){
        this.label = label;
        return this;
    }

    private String getLabel(){
        return this.label;
    }
}
