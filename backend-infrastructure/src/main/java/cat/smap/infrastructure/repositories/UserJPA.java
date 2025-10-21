package cat.smap.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.smap.infrastructure.entities.UserEntity;

public interface UserJPA extends JpaRepository<UserEntity, Long> {
}
