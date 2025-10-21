package cat.smap.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.smap.infrastructure.entities.UserEntity;

/**
 * Requerida una interfície que hereti de JpaRepository per poder executar operacions
 * contra la Base de Dades.
 * Aquesta serà emprada pel Repository, per executar les accions definides al adapter.
 */
public interface UserJPA extends JpaRepository<UserEntity, Long> {}
