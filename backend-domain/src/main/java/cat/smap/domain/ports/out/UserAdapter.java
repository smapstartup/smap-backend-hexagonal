package cat.smap.domain.ports.out;

import cat.smap.domain.models.pojos.User;

import java.util.Optional;

public interface UserAdapter {
    Optional<User> findById(Long id);
    Optional<User> save(User user);
}
