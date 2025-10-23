package cat.smap.application.requests;


import java.util.UUID;

public class UserRequestDto {
    private final UUID uuid;
    private final String email;
    private final String password;

    public UserRequestDto(UUID uuid, String email, String password) {
        this.uuid = uuid;
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
