package cat.smap.web;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "cat.smap.utils",
        "cat.smap.application",
        "cat.smap.domain",
        "cat.smap.infrastructure",
        "cat.smap.web"
})
@EnableJpaRepositories(basePackages = {
        "cat.smap.infrastructure.repositories"
})
@EntityScan(basePackages = {
        "cat.smap.infrastructure.entities"
})
public class ApiApplication {
    private final Environment env;

    public ApiApplication(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
//        SmapLogger.consoleLog(LogChannel.INFO, ">>> PERFILS ACTIUS: " + Arrays.toString(this.env.getActiveProfiles()));
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}