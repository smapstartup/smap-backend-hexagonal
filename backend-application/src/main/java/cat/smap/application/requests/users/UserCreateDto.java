package cat.smap.application.requests.users;

import cat.smap.utils.validators.SmapValidations;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class UserCreateDto {

    @NotEmpty
    @Email
    private final String email;

    @NotEmpty
    private final String password;

    @NotEmpty
    private final String username;

    @NotEmpty
    private final String name;

    @NotEmpty
    private final String firstSurname;

    private final UUID createdBy;

    public UserCreateDto(String email, String password, String username, String name, String firstSurname, UUID createdBy) {
        this.email = SmapValidations.validateEmail(email);
        this.password = password;
        this.username = username;
        this.name = name;
        this.firstSurname = firstSurname;
        this.createdBy = createdBy;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getPassword() {
        return password;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }
}
