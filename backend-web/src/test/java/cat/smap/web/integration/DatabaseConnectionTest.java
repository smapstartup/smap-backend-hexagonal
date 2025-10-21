package cat.smap.web.integration;


import cat.smap.utils.logging.LogChannel;
import cat.smap.utils.logging.SmapLogger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ActiveProfiles("dev")
class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void testConnection() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            SmapLogger.consoleLog(LogChannel.INFO, "Connexió a la Base de Dades OK");
            assertFalse(connection.isClosed());
        }
    }
}
