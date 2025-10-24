package cat.smap.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

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

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}