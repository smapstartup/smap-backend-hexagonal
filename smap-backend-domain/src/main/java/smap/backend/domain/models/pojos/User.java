package smap.backend.domain.models.pojos;

import smap.backend.domain.models.core.BaseModel;

import java.util.UUID;

public class User extends BaseModel {

    private final String email;
    private final String password;

    public User(Long id, UUID uuid, String email, String password) {
        super(id, uuid);
        this.email = email;
        this.password = password;
    }
}
