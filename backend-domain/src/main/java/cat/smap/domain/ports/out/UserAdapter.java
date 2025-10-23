package cat.smap.domain.ports.out;

import cat.smap.domain.models.pojos.User;

import java.util.List;
import java.util.UUID;

/**
 * Definim per contracte, les accions que el Service li podrà demanar al UserRepository i
 * que aquest, haurà d'implementar per executar-les contra la Base de Dades.
 */
public interface UserAdapter {
    User findById(Long id);
    User findByUuid(UUID uuid);
    User save(User user);
    List<User> findAll();
    User update(User user);
    User delete(User user);
}
