package cat.smap.domain.ports.in;

import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.requests.UserToDeleteDto;
import cat.smap.application.requests.UserUpdateDto;
import cat.smap.application.responses.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserUseCase {
    UserResponseDto createUser(UserCreateDto dto);
    UserResponseDto putUser(UserUpdateDto dto);
    UserResponseDto patchUser(UserUpdateDto dto);
    UserResponseDto deleteUser(UserToDeleteDto dto);
    UserResponseDto softDelete(UserToDeleteDto dto);
    UserResponseDto findByUuid(UUID uuid);
    List<UserResponseDto> findAll();
}
