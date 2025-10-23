package cat.smap.domain.mappers.dto;

import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.requests.UserRequestDto;
import cat.smap.application.requests.UserToDeleteDto;
import cat.smap.application.requests.UserUpdateDto;
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