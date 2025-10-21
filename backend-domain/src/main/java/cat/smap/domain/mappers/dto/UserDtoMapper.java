package cat.smap.domain.mappers.dto;

import org.mapstruct.Mapper;
import cat.smap.application.requests.UserCreateDto;
import cat.smap.domain.models.pojos.User;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    // Del Dto cap al Service
    User toDomain(UserCreateDto dto);




}