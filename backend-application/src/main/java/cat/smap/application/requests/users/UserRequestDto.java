package cat.smap.application.requests.users;


import java.util.UUID;

public class UserRequestDto {
    private final UUID id;
    private final String username;
    private final String password;

    public UserRequestDto(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
