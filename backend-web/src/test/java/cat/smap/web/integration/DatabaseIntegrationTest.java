package cat.smap.web.integration;


import cat.smap.domain.models.pojos.User;
import cat.smap.infrastructure.repositories.UserRepository;
import cat.smap.utils.logging.LogChannel;
import cat.smap.utils.logging.SmapLogger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ActiveProfiles("dev")
class DatabaseIntegrationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testConnection() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            SmapLogger.consoleLog(LogChannel.DEBUG, "Connexió a la Base de Dades OK");
            assertFalse(connection.isClosed());
        }
    }

    @Test
    void testCrudUsers() throws Exception {
        int numUsers = userRepository.findAll().size();
        SmapLogger.debugging("testCrudUsers\n\nNúmero d'usuaris " + numUsers);
        if ( numUsers == 0 ) {
            List<User> users = new ArrayList<>();

            users.add(new User(null, null, "smap.startup@gmail.com", "123456"));
            users.add(new User(null, null, "smap.socials@gmail.com", "123456"));
            users.add(new User(null, null, "info@salvadormatagarcia.dev", "123456"));

            SmapLogger.debugging("Creació d'un array amb tres usuaris ");
            SmapLogger.debugging("Intentem inserir els tres usuaris a la BD ");

            users.stream().map((User user) -> userRepository.save(user)).forEach(user -> {});

            SmapLogger.debugging("Intentem inserir els tres usuaris a la BD ");

            int calculate = userRepository.findAll().size();
            SmapLogger.debugging("Torno a mirar el número d'usuaris " + calculate);
        }
    }
}
