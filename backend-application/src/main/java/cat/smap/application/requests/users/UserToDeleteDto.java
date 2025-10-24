package cat.smap.application.requests.users;

import java.util.UUID;

public class UserToDeleteDto {
    private final UUID id;
    private final UUID deletedBy;

    public UserToDeleteDto(UUID id, UUID deletedBy) {
        this.id = id;
        this.deletedBy = deletedBy;
    }

    public UUID getId() {
        return id;
    }

    public UUID getDeletedBy() {
        return deletedBy;
    }
}
