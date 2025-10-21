package cat.smap.web;

import cat.smap.utils.logging.LogChannel;
import cat.smap.utils.logging.SmapLogger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("dev")
class ApiApplicationTests {

    @Autowired
    Environment env;

    @Test
    void contextLoads() {
        SmapLogger.consoleLog(LogChannel.DEBUG, ">>> PERFILS ACTIUS: " + Arrays.toString(env.getActiveProfiles()));
        // Smoke test: si aquest test falla, vol dir que el context de Spring no arrenca
        System.out.println("Executant el test de context amb un perfil de " + Arrays.toString(env.getActiveProfiles()));
        assertTrue(true);
    }
}
