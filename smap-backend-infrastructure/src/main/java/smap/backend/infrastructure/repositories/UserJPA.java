package smap.backend.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smap.backend.infrastructure.entities.UserEntity;

public interface UserJPA extends JpaRepository<UserEntity, Long> {
}
