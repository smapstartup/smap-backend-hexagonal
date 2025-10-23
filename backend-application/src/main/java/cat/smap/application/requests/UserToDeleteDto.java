package cat.smap.application.requests;

import java.util.UUID;

public class UserToDeleteDto {
    private final UUID uuid;
    private final UUID deletedBy;

    public UserToDeleteDto(UUID uuid, UUID deletedBy) {
        this.uuid = uuid;
        this.deletedBy = deletedBy;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UUID getDeletedBy() {
        return deletedBy;
    }
}
