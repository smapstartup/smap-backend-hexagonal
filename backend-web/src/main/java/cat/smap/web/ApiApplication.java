package cat.smap.web;

import cat.smap.utils.logging.LogChannel;
import cat.smap.utils.logging.SmapLogger;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
@Import({
        cat.smap.application.ApplicationConfig.class,
        cat.smap.infrastructure.InfrastructureConfig.class,
        cat.smap.domain.DomainConfig.class,
        cat.smap.utils.UtilsConfig.class
})
public class ApiApplication {
    private final Environment env;

    public ApiApplication(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        SmapLogger.consoleLog(
                LogChannel.DEBUG,
                """
                \s
                *************************************************\s
                Inicialitzem l'aplicació\s
                Perfil d'execució de l'aplicació: %s
                *************************************************\s
                """.formatted(
                    Arrays.toString(this.env.getActiveProfiles())
                )
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}