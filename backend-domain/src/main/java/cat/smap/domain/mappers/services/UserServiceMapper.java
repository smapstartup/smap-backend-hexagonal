package cat.smap.domain.mappers.services;

import cat.smap.application.responses.UserResponseDto;
import cat.smap.domain.models.pojos.User;
import cat.smap.infrastructure.entities.UserEntity;

public interface UserServiceMapper {
    // Del Service cap al Controller
    UserResponseDto toDto(User model);

    // Del Service cap al Repository
    UserEntity toEntity(User model);
}
