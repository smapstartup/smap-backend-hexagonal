package cat.smap.domain.models.pojos;

import cat.smap.domain.models.core.BaseModel;

import java.util.UUID;

public class User extends BaseModel {

    private final String email;
    private String password;

    public User(Long id, UUID uuid, String email, String password) {
        super(id, uuid);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUserSignature(){
        return """
                \s
                *****************************************\s
                Checking dades del user:\s
                Email: %s,\s
                RawPassword: %s\s
                *****************************************\s
                """.formatted(this.getEmail(), this.getPassword());
    }
}
