package smap.backend.domain.ports.in;

import smap.backend.application.requests.UserCreateDto;
import smap.backend.application.responses.UserResponseDto;

public interface UserUseCase {
    UserResponseDto createUser(UserCreateDto userCreateDto);
    UserResponseDto findById(Long id);
}
