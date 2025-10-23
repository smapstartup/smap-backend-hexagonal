package cat.smap.infrastructure.repositories;

import cat.smap.infrastructure.implementacions.UserJPA;
import cat.smap.infrastructure.mappers.UserEntityMapper;
import cat.smap.domain.models.pojos.User;
import cat.smap.domain.ports.out.UserAdapter;
import cat.smap.infrastructure.entities.UserEntity;
import cat.smap.utils.commons.CommonTools;
import cat.smap.utils.exceptions.NotFoundException;
import cat.smap.utils.logging.LogChannel;
import cat.smap.utils.logging.SmapLogger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements UserAdapter {

    private final UserJPA userJPA;
    private final UserEntityMapper userEntityMapper;

    public UserRepository(UserJPA userJPA, UserEntityMapper userEntityMapper) {
        this.userJPA = userJPA;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User save(User user) {
        try {
            UserEntity toCreate = userEntityMapper.userDomaintoUserEntity(user);
            String textDebug = """
                \s
                ************************************************\s
                UserEntity després del Mapper\s
                Email: %s,\s
                Hash: %s\s
                UUID-SYSTEM: %s\s
                ************************************************\s
                """.formatted(toCreate.getEmail(), toCreate.getPassword(), CommonTools.getUUIDSystem());
            SmapLogger.consoleLog(LogChannel.DEBUG, textDebug);
            UserEntity created = userJPA.save(toCreate);
            return userEntityMapper.userEntityToUserDomain(created);
        } catch ( Exception ex) {
            String textDebug = """
                \s
                ************************************************\s
                No hem pogut crear el nou registre\s
                El procés ha fallat per l'excepció: %s,\s
                Missatge: %s\s
                ************************************************\s
                """.formatted(ex.getLocalizedMessage(), ex.getMessage());
            SmapLogger.consoleLog(LogChannel.DEBUG, textDebug);
            return null;
        }
    }

    private UserEntity findRowByUuid(UUID uuid) {
        return userJPA.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("No hi cap user amb uuid " + uuid));
    }

    @Override
    public User findById(Long id) {
        UserEntity entity = userJPA.findById(id).orElseThrow(
                () -> new NotFoundException("No hi cap user amb id " + id)
        );
        return userEntityMapper.userEntityToUserDomain(entity);
    }

    @Override
    public User findByUuid(UUID uuid) {
        try {
            UserEntity entity = findRowByUuid(uuid);
            return userEntityMapper.userEntityToUserDomain(entity);
        } catch (NotFoundException ex) {
            SmapLogger.consoleLog(LogChannel.ERROR,
                    """
                            No s'ha pogut obtenir l'usuari\s
                            %s
                            """.formatted(ex.getMessage()));
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userJPA.findAll();
        return userEntities.stream()
                .map(userEntityMapper::userEntityToUserDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User update(User user) {
        try {
            UserEntity found = findRowByUuid(user.getUuid());
            UserEntity updated = userJPA.save(found);
            return userEntityMapper.userEntityToUserDomain(updated);
        } catch (NotFoundException ex) {
            SmapLogger.consoleLog(LogChannel.ERROR,
                    """
                            No s'ha pogut actualitzar l'usuari\s
                            %s
                            """.formatted(ex.getMessage()));
            return null;
        } catch (IllegalArgumentException ex) {
            SmapLogger.consoleLog(LogChannel.ERROR,
                    """
                            No s'ha pogut esborrar l'usuari amb UUID: %s\s
                            Hi ha hagut una excepció:\s
                             ## %s ##\s
                            """.formatted(user.getUuid(), ex.getMessage()));
            return null;
        }
    }

    @Override
    public User delete(User user) {
        try {
            UserEntity found = findRowByUuid(user.getUuid());
            userJPA.delete(found);
            userJPA.flush();
            return user;
        } catch (NotFoundException ex) {
            SmapLogger.consoleLog(LogChannel.ERROR,
                    """
                            No s'ha pogut actualitzar l'usuari\s
                            %s
                            """.formatted(ex.getMessage()));
            return null;
        } catch (IllegalArgumentException ex) {
            SmapLogger.consoleLog(LogChannel.ERROR,
                    """
                            No s'ha pogut esborrar l'usuari amb UUID: %s\s
                            Hi ha hagut una excepció:\s
                             ## %s ##\s
                            """.formatted(user.getUuid(), ex.getMessage()));
            return null;
        }
    }
}
