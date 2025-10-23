package cat.smap.application.requests;

import java.util.UUID;

public class UserUpdateDto {
    private final UUID uuid;
    private final String email;
    private final String password;
    private final UUID updatedBy;

    public UserUpdateDto(UUID uuid, String email, String password, UUID updatedBy) {
        this.uuid = uuid;
        this.email = email;
        this.password = password;
        this.updatedBy = updatedBy;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }
}
