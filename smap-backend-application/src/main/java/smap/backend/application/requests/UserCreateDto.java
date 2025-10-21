package smap.backend.application.requests;

import smap.backend.utils.rules.EmailValidationRules;
import smap.backend.utils.validators.SmapValidations;

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
