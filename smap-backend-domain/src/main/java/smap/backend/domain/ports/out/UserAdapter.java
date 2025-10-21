package smap.backend.domain.ports.out;

import smap.backend.domain.models.pojos.User;

import java.util.Optional;

public interface UserAdapter {
    Optional<User> findById(Long id);
    Optional<User> save(User user);
}
