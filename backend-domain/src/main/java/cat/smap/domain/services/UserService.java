package cat.smap.domain.services;

import org.springframework.stereotype.Service;
import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.responses.UserResponseDto;
import cat.smap.domain.ports.in.UserUseCase;

@Service
public class UserService implements UserUseCase {

    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public UserResponseDto findById(Long id) {
        return null;
    }
}
