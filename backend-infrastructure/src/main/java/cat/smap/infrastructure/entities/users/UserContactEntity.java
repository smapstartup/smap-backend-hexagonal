package cat.smap.infrastructure.entities.users;

import cat.smap.infrastructure.entities.BaseEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
        name="users_contact",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uniqueUserContact",
                        columnNames = { "user_id", "contact_type", "contact_category", "main", "contact_data" }
                )
        }
)

public class UserContactEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "contact_type", nullable = false)
    private String contactType;

    @Column(name = "contact_category", nullable = false)
    private String contactCategory;

    @Column(nullable = false)
    private boolean main;

    @Column(name = "contact_data", nullable = false)
    private String contactData;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getContactType() {
        return contactType;
    }

    public String getContactCategory() {
        return contactCategory;
    }

    public void setContactCategory(String contactCategory) {
        this.contactCategory = contactCategory;
    }

    public boolean isMain() {
        return main;
    }

    public String getContactData() {
        return contactData;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public void setContactData(String contactData) {
        this.contactData = contactData;
    }
}
