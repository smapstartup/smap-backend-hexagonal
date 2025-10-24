package cat.smap.domain.ports.in;

import cat.smap.application.requests.users.UserCreateDto;
import cat.smap.application.requests.users.UserToDeleteDto;
import cat.smap.application.requests.users.UserUpdateDto;
import cat.smap.application.responses.users.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserUseCase {
    UserResponseDto createUser(UserCreateDto dto);
    UserResponseDto putUser(UserUpdateDto dto);
    UserResponseDto patchUser(UserUpdateDto dto);
    UserResponseDto deleteUser(UserToDeleteDto dto);
    UserResponseDto softDelete(UserToDeleteDto dto);
    UserResponseDto findById(UUID id);
    List<UserResponseDto> findAll();
}
