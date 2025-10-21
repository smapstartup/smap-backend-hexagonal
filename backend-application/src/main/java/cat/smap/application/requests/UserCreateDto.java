package cat.smap.application.requests;

import cat.smap.utils.rules.EmailValidationRules;
import cat.smap.utils.validators.SmapValidations;

public class UserCreateDto {
    private final String email;
    private final String password;

    public UserCreateDto(String email, String password) {
        if (!SmapValidations.validateTargetByPattern(email, EmailValidationRules.SUPERIOR_DOMAIN.getRegex())){
            throw new IllegalArgumentException("L'email no sembla vàlid");
        }
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
