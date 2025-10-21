package smap.backend.domain.mappers;

import smap.backend.domain.models.pojos.User;
import smap.backend.infrastructure.entities.UserEntity;

public interface UserEntityMapper {
    // Del Repository cap al Service
    User toDomain(UserEntity userEntity);
}
