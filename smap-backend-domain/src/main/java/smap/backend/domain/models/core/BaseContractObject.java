package smap.backend.domain.models.core;

import smap.backend.domain.contracts.BaseContract;

import java.time.Instant;
import java.util.UUID;

public abstract class BaseContractObject implements BaseContract {

    private Long id;
    private UUID uuid;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long deletedBy;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public Instant getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public Instant getDeletedAt() {
        return this.deletedAt;
    }

    @Override
    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public Long getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    @Override
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public Long getDeletedBy() {
        return this.deletedBy;
    }

    @Override
    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }
}
