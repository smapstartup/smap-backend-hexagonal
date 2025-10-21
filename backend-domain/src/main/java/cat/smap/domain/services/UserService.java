package cat.smap.domain.services;

import cat.smap.domain.mappers.dto.UserDtoMapper;
import cat.smap.domain.mappers.services.UserServiceMapper;
import cat.smap.domain.models.pojos.User;
import cat.smap.domain.ports.out.UserAdapter;
import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.responses.UserResponseDto;
import cat.smap.domain.ports.in.UserUseCase;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserUseCase {

    private final UserDtoMapper userDtoMapper;
    private final UserServiceMapper userServiceMapper;
    private final UserAdapter userAdapter;

    public UserService(UserDtoMapper userDtoMapper, UserServiceMapper userServiceMapper, UserAdapter userAdapter) {
        this.userDtoMapper = userDtoMapper;
        this.userServiceMapper = userServiceMapper;
        this.userAdapter = userAdapter;
    }

    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        User user = userDtoMapper.toDomain(userCreateDto);
        User created = userAdapter.save(user);
        return userServiceMapper.toDto(created);
    }

    @Override
    public UserResponseDto findById(Long id) {
        User user = userAdapter.findById(id);
        return userServiceMapper.toDto(user);
    }
}
