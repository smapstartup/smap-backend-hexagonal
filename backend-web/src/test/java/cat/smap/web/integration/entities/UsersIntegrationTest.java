package cat.smap.web.integration.entities;

import cat.smap.domain.models.pojos.User;
import cat.smap.domain.ports.out.UserRepository;
import cat.smap.utils.logging.SmapLogger;
import cat.smap.utils.security.PasswordGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
@SpringBootTest
@ActiveProfiles("dev")
class UsersIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * Execució des de terminal
     * mvn test -Dtest=UsersIntegrationTest#testCrudUsers -Diterations=100
     */
    @Test
    void testCrudUsers() {
        int iterations = Integer.parseInt(System.getProperty("iterations", "1"));
        if ( iterations > 1000 ) {
            iterations = 1000;
        }

        SmapLogger.debugging("Executant el testCrudUsers");

        // Testegem la creació de nous usuaris
        createUsers(iterations);
    }

    private void createUsers(int usersNumber) {

        UUID createdBy = UUID.randomUUID();
        List<User> newUsersCreated = new ArrayList<>();

        for ( int i = 1; i <= usersNumber; i++ ) {
            User user = new User(null, null, "smap.user" + i, "123456");
            user.setPassword(PasswordGenerator.generateHashPassword(user.getPassword()));
            user.setCreatedBy(createdBy);
            SmapLogger.debugging("Registrant nou usuari:  " + user.getEmail());
            User saved = userRepository.save(user);
            SmapLogger.debugging("Registrat nou usuari:  " + saved.getId());
            newUsersCreated.add(saved);
        }

        assertEquals(newUsersCreated.size(), usersNumber,
                "El nombre de users registrats i el de users rebuts no coincideix"
        );
    }
}
