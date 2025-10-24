package cat.smap.application.requests.users;

import java.util.UUID;

public class UserUpdateDto {
    private final UUID id;
    private final String email;
    private final UUID updatedBy;

    public UserUpdateDto(UUID id, String email, UUID updatedBy) {
        this.id = id;
        this.email = email;
        this.updatedBy = updatedBy;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }
}
