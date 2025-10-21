package cat.smap.domain.ports.in;

import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.responses.UserResponseDto;

public interface UserUseCase {
    UserResponseDto createUser(UserCreateDto userCreateDto);
    UserResponseDto findById(Long id);
}
