package cat.smap.infrastructure.mappers;

import cat.smap.domain.models.pojos.User;
import cat.smap.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    // Del Service cap al Repository
    UserEntity toEntity(User user);

    // Del Repository cap al Service
    User toDomain(UserEntity entity);

}
