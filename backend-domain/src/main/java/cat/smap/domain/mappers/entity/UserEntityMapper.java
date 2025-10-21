package cat.smap.domain.mappers.entity;

import cat.smap.domain.models.pojos.User;
import cat.smap.infrastructure.entities.UserEntity;

public interface UserEntityMapper {
    // Del Repository cap al Service
    User toDomain(UserEntity entity);
}
