package smap.backend.domain.contracts;

import java.time.Instant;
import java.util.UUID;

public interface BaseContract {

    Long getId();
    void setId(Long id);

    UUID getUuid();
    void setUuid(UUID uuid);

    Instant getCreatedAt();
    void setCreatedAt(Instant createdAt);

    Instant getUpdatedAt();
    void setUpdatedAt(Instant updatedAt);

    Instant getDeletedAt();
    void setDeletedAt(Instant deletedAt);

    Long getCreatedBy();
    void setCreatedBy(Long createdBy);

    Long getUpdatedBy();
    void setUpdatedBy(Long updatedBy);

    Long getDeletedBy();
    void setDeletedBy(Long deletedBy);

}
