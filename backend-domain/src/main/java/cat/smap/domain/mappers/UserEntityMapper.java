package cat.smap.domain.mappers;

import cat.smap.domain.models.pojos.User;
import cat.smap.infrastructure.entities.UserEntity;

public interface UserEntityMapper {
    // Del Repository cap al Service
    User toDomain(UserEntity userEntity);
}
