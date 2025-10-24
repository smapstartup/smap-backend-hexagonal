package cat.smap.utils.validators;

import cat.smap.utils.rules.EmailValidationRules;

import java.util.regex.Pattern;

public class SmapValidations {

    public static boolean validateTargetByPattern(String target, String pattern) {
        return Pattern.compile(pattern)
                .matcher(target)
                .matches();
    }

    public static String validateEmail(String email) {
        if ( !SmapValidations.validateTargetByPattern(email, EmailValidationRules.SUPERIOR_DOMAIN.getRegex())){
            throw new IllegalArgumentException("L'adreça d'email no sembla vàlida: " + email);
        }
        return email;
    }
}
