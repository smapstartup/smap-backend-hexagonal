package cat.smap.domain.services;

import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.requests.UserToDeleteDto;
import cat.smap.application.requests.UserUpdateDto;
import cat.smap.application.responses.UserResponseDto;
import cat.smap.domain.mappers.dto.UserDtoToUserDomainMapper;
import cat.smap.domain.mappers.services.UserServiceMapper;
import cat.smap.domain.models.pojos.User;
import cat.smap.domain.ports.out.UserAdapter;
import cat.smap.domain.ports.in.UserUseCase;
import cat.smap.utils.logging.LogChannel;
import cat.smap.utils.logging.SmapLogger;
import cat.smap.utils.rules.EmailValidationRules;
import cat.smap.utils.security.PasswordGenerator;
import cat.smap.utils.validators.SmapValidations;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserUseCase {

    private final UserDtoToUserDomainMapper userDtoToUserDomainMapper;
    private final UserServiceMapper userServiceMapper;
    private final UserAdapter userAdapter;

    public UserService(
            UserDtoToUserDomainMapper userDtoToUserDomainMapper,
            UserServiceMapper userServiceMapper,
            UserAdapter userAdapter
    ) {
        this.userDtoToUserDomainMapper = userDtoToUserDomainMapper;
        this.userServiceMapper = userServiceMapper;
        this.userAdapter = userAdapter;
    }

    private void validateEmail(String email) {
        if ( !SmapValidations.validateTargetByPattern(email, EmailValidationRules.SUPERIOR_DOMAIN.getRegex())){
            throw new IllegalArgumentException("L'adreça d'email " + email + " no sembla vàlida");
        }
    }

    @Override
    public UserResponseDto createUser(UserCreateDto dto) {
        validateEmail(dto.getEmail());
        String hashedPassword = PasswordGenerator.generateHashPassword(dto.getPassword());
        User user = userDtoToUserDomainMapper.userDtoCreatedToDomain(dto);
        SmapLogger.consoleLog(LogChannel.DEBUG, "Abans del hash: " + user.getUserSignature());
        user.setPassword(hashedPassword);
        SmapLogger.consoleLog(LogChannel.DEBUG, "Després del hash: " + user.getUserSignature());
        User created = userAdapter.save(user);
        return userServiceMapper.userDomainToUserDto(created);
    }

    @Override
    public UserResponseDto putUser(UserUpdateDto dto) {
        return null;
    }

    @Override
    public UserResponseDto patchUser(UserUpdateDto dto) {
        return null;
    }

    @Override
    public List<UserResponseDto> findAll() {
        List<User> users = userAdapter.findAll();
        SmapLogger.consoleLog(LogChannel.DEBUG, "Users trobats: " + users.size());
        return users.stream()
                .map((User user) -> userServiceMapper.userDomainToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findByUuid(UUID uuid) {
        return userServiceMapper.userDomainToUserDto(userAdapter.findByUuid(uuid));
    }

    @Override
    public UserResponseDto deleteUser(UserToDeleteDto dto) {
        User user = userDtoToUserDomainMapper.userDtoSoftDeleteToDomain(dto);
        return userServiceMapper.userDomainToUserDto(userAdapter.delete(user));
    }

    @Override
    public UserResponseDto softDelete(UserToDeleteDto dto) {
        User toSoftDelete = userDtoToUserDomainMapper.userDtoSoftDeleteToDomain(dto);
        toSoftDelete.setDeletedAt(Instant.now());
        return userServiceMapper.userDomainToUserDto(userAdapter.update(toSoftDelete));
    }
}
