package cat.smap.application.responses;

import java.util.UUID;

public class UserResponseDto {
    private final Long id;
    private final UUID uuid;
    private final String email;

    public UserResponseDto(Long id, UUID uuid, String email) {
        this.id = id;
        this.uuid = uuid;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }
}
