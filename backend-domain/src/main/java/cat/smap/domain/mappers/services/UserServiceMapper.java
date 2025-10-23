package cat.smap.domain.mappers.services;

import cat.smap.application.responses.UserResponseDto;
import cat.smap.domain.models.pojos.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {
    // Del Service cap al Controller
    UserResponseDto userDomainToUserDto(User model);
}
