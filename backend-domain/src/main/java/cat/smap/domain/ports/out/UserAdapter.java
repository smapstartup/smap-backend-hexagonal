package cat.smap.domain.ports.out;

import cat.smap.domain.models.pojos.User;

/**
 * Definim per contracte, les accions que el Service li podrà demanar al UserRepository i
 * que aquest, haurà d'implementar per executar-les contra la Base de Dades.
 */
public interface UserAdapter {
    User findById(Long id);
    User save(User user);
}
