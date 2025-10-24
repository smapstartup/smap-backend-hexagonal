package cat.smap.domain.mappers.dto;

import cat.smap.application.requests.users.UserCreateDto;
import cat.smap.application.requests.users.UserRequestDto;
import cat.smap.application.requests.users.UserToDeleteDto;
import cat.smap.application.requests.users.UserUpdateDto;
import org.mapstruct.Mapper;
import cat.smap.domain.models.pojos.User;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserDtoToUserDomainMapper {

    User userDtoCreatedToDomain(UserCreateDto userCreateDto);

    User userDtoRequestToDomain(UserRequestDto dto);

    @Mapping(target = "email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User userDtoPatchToDomain(UserUpdateDto dto);

    User userDtoPutToDomain(UserUpdateDto dto);

    User userDtoSoftDeleteToDomain(UserToDeleteDto dto);
}