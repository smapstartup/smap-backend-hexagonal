package cat.smap.infrastructure.entities;

import cat.smap.utils.commons.CommonTools;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @Column(nullable = false, unique = true, updatable = false, columnDefinition = "uuid")
    @UuidGenerator
    private UUID id;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long id) {
        this.pk = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID uuid) {
        this.id = uuid;
    }

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "created_by", nullable = false, updatable = false)
    private UUID createdBy;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "updated_by", nullable = false)
    private UUID updatedBy;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Column(name = "deleted_by")
    private UUID deletedBy;
    
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    
    public Instant getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }
    
    public UUID getCreatedBy() {
        return createdBy;
    }
    
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Instant getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedBy(UUID createdBy) {
        this.updatedBy = createdBy;
    }
    
    public UUID getUpdatedBy() {
        return updatedBy;
    }
    
    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    public Instant getDeletedAt() {
        return deletedAt;
    }
    
    public void setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
    }
    
    public UUID getDeletedBy() {
        return deletedBy;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
        if( this.createdBy == null ) {
            setCreatedBy(CommonTools.getUUIDSystem());
        }
        setUpdatedBy(this.createdBy);
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
        if( this.updatedBy == null ) {
            setUpdatedBy(CommonTools.getUUIDSystem());
        }
    }

    @PreRemove
    protected void onDelete() {
        this.deletedAt = Instant.now();
        if( this.deletedBy == null ) {
            setDeletedBy(CommonTools.getUUIDSystem());
        }
    }
}
