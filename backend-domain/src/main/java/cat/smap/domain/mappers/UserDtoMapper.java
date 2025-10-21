package cat.smap.domain.mappers;

import org.mapstruct.Mapper;
import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.responses.UserResponseDto;
import cat.smap.domain.models.pojos.User;
import cat.smap.infrastructure.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    // Del Controller cap al Service
    User toDomain(UserCreateDto userCreateDto);

    // Del Service cap al Repository
    UserEntity toEntity(User user);

    // Del Service cap al Controller
    UserResponseDto toResponseDto(User user);
}