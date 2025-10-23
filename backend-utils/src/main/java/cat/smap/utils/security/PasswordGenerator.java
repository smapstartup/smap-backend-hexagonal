package cat.smap.utils.security;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class PasswordGenerator {

    private static final Argon2PasswordEncoder ENCODER =
            new Argon2PasswordEncoder(16, 32, 2, 65536, 3);

    /**
     * Genera el hash segur d'una contrasenya en text pla.
     */
    public static String generateHashPassword(String rawPassword) {
        return ENCODER.encode(rawPassword);
    }

    /**
     * Valida una contrasenya comparant-la amb el hash guardat.
     */
    public static boolean validatePassword(String rawPassword, String storedHash) {
        return ENCODER.matches(rawPassword, storedHash);
    }
}
