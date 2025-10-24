package cat.smap.infrastructure.implementacions.users;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.smap.infrastructure.entities.users.UserEntity;

import java.util.UUID;

/**
 * Requerida una interfície que hereti de JpaRepository per poder executar operacions
 * contra la Base de Dades.
 * Aquesta serà emprada pel Repository, per executar les accions definides al adapter.
 */
public interface UserAdapter extends JpaRepository<UserEntity, Long> {
    UserEntity findById(UUID id);
    UserEntity findByPk(Long pk);
    UserEntity findByUsername(String username);
}
