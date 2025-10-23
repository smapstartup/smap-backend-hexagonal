package cat.smap.application.responses;

import java.util.UUID;

public class UserResponseDto {
    private final UUID uuid;
    private final String email;

    public UserResponseDto(UUID uuid, String email) {
        this.uuid = uuid;
        this.email = email;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }
}
