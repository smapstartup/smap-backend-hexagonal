package cat.smap.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name="users",
        uniqueConstraints = {
            @UniqueConstraint(
                name = "uniqueUser",
                columnNames = { "email", "password" }
            )
        }
)
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
