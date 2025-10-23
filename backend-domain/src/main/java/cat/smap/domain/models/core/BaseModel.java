package cat.smap.domain.models.core;

import java.time.Instant;
import java.util.UUID;

public class BaseModel {
    private final Long id;
    private final UUID uuid;
    private Instant createdAt;
    private UUID createdBy;
    private Instant updatedAt;
    private UUID updatedBy;
    private Instant deletedAt;
    private UUID deletedBy;

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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public BaseModel setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public BaseModel setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public BaseModel setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public BaseModel setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public BaseModel setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    public UUID getDeletedBy() {
        return deletedBy;
    }

    public BaseModel setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
        return this;
    }
}
