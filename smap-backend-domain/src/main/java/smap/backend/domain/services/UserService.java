package smap.backend.domain.services;

import org.springframework.stereotype.Service;
import smap.backend.application.requests.UserCreateDto;
import smap.backend.application.responses.UserResponseDto;
import smap.backend.domain.ports.in.UserUseCase;

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
