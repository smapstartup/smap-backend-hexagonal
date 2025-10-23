package cat.smap.infrastructure;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("cat.smap.infrastructure")
@EnableJpaRepositories(basePackages = {
        "cat.smap.infrastructure.repositories",
        "cat.smap.infrastructure.implementacions"
})
@EntityScan(basePackages = {
        "cat.smap.infrastructure.entities"
})
public class InfrastructureConfig {
}
