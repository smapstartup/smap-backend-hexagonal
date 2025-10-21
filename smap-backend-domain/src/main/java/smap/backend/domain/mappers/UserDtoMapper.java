package smap.backend.domain.mappers;

import org.mapstruct.Mapper;
import smap.backend.application.requests.UserCreateDto;
import smap.backend.application.responses.UserResponseDto;
import smap.backend.domain.models.pojos.User;
import smap.backend.infrastructure.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    // Del Controller cap al Service
    User toDomain(UserCreateDto userCreateDto);

    // Del Service cap al Repository
    UserEntity toEntity(User user);

    // Del Service cap al Controller
    UserResponseDto toResponseDto(User user);
}