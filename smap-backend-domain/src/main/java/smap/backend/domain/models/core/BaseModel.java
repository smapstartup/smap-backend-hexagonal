package smap.backend.domain.models.core;

import java.util.UUID;

public class BaseModel {
    private final Long id;
    private final UUID uuid;

    public BaseModel(Long id, UUID uuid) {
        this.id = id;
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }
}
