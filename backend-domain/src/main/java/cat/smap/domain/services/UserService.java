package cat.smap.domain.services;

import cat.smap.application.requests.users.UserCreateDto;
import cat.smap.application.requests.users.UserToDeleteDto;
import cat.smap.application.requests.users.UserUpdateDto;
import cat.smap.application.responses.users.UserResponseDto;
import cat.smap.domain.mappers.dto.UserDtoToUserDomainMapper;
import cat.smap.domain.mappers.services.UserServiceMapper;
import cat.smap.domain.models.pojos.User;
import cat.smap.domain.models.pojos.UserContact;
import cat.smap.domain.models.types.ContactCategory;
import cat.smap.domain.models.types.ContactType;
import cat.smap.domain.ports.out.UserContactRepository;
import cat.smap.domain.ports.out.UserRepository;
import cat.smap.domain.ports.in.UserUseCase;
import cat.smap.utils.exceptions.DuplicateRegisterException;
import cat.smap.utils.security.PasswordGenerator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserUseCase {

    private final UserDtoToUserDomainMapper userDtoToUserDomainMapper;
    private final UserServiceMapper userServiceMapper;
    private final UserRepository userRepository;
    private final UserContactRepository userContactRepository;

    public UserService(
            UserDtoToUserDomainMapper userDtoToUserDomainMapper,
            UserServiceMapper userServiceMapper,
            UserRepository userRepository,
            UserContactRepository userContactRepository
    ) {
        this.userDtoToUserDomainMapper = userDtoToUserDomainMapper;
        this.userServiceMapper = userServiceMapper;
        this.userRepository = userRepository;
        this.userContactRepository = userContactRepository;
    }

    @Transactional
    @Override
    public UserResponseDto createUser(UserCreateDto dto) {
        User exists = userRepository.findByUsername(dto.getUsername());
        if (exists != null) {
            String error = "Ja existeix un registre d'usuari amb aquest username. " +
                    "Has oblidat la teva contrasenya?";
            throw new DuplicateRegisterException(error);
        }
        String hashedPassword = PasswordGenerator.generateHashPassword(dto.getPassword());
        User user = userDtoToUserDomainMapper.userDtoCreatedToDomain(dto);
        user.setPassword(hashedPassword);
        User created = userRepository.save(user);
        UserContact contact = new UserContact(
                null,
                null,
                created,
                true,
                ContactType.MAIL.getDescription(),
                ContactCategory.DEFAULT.getDefinition(),
                user.getEmail()
        );
        UserContact contactSaved = userContactRepository.save(contact);
        created.setEmail(contactSaved.getContactData());
        return userServiceMapper.userDomainToUserDto(created);
    }

    @Override
    public UserResponseDto putUser(UserUpdateDto dto) {
        User user = userRepository.findById(dto.getId());
        User updated = userRepository.save(user);
        return userServiceMapper.userDomainToUserDto(updated);
    }

    @Override
    public UserResponseDto patchUser(UserUpdateDto dto) {
        User user = userRepository.findById(dto.getId());
        if ( dto.getEmail() != null ) {
            user.setEmail(dto.getEmail());
        }
        User updated = userRepository.save(user);
        return userServiceMapper.userDomainToUserDto(updated);
    }

    @Override
    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userServiceMapper::userDomainToUserDto)
                .toList();
    }

    @Override
    public UserResponseDto findById(UUID id) {
        return userServiceMapper.userDomainToUserDto(userRepository.findById(id));
    }

    @Override
    public UserResponseDto deleteUser(UserToDeleteDto dto) {
        User user = userDtoToUserDomainMapper.userDtoSoftDeleteToDomain(dto);
        return userServiceMapper.userDomainToUserDto(userRepository.delete(user));
    }

    @Override
    @Transactional
    public UserResponseDto softDelete(UserToDeleteDto dto) {
        User user = userRepository.findById(dto.getId());
        user.setDeletedBy(dto.getDeletedBy());
        user.setDeletedAt(Instant.now());
        User softDeleted = userRepository.save(user);
        return userServiceMapper.userDomainToUserDto(softDeleted);
    }
}
