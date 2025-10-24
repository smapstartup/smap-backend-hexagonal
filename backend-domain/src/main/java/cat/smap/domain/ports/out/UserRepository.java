package cat.smap.domain.ports.out;

import cat.smap.domain.models.pojos.User;

import java.util.List;
import java.util.UUID;

/**
 * Definim per contracte, les accions que el Service li podrà demanar al UserRepository i
 * que aquest, haurà d'implementar per executar-les contra la Base de Dades.
 */
public interface UserRepository {
    // User
    User findById(UUID id);
    User findByPk(Long pk);
    User save(User user);
    List<User> findAll();
    User delete(User user);
    User findByUsername(String username);
}
