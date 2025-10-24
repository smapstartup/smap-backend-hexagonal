package cat.smap.infrastructure.repositories.users;

import cat.smap.infrastructure.implementacions.users.UserAdapter;
import cat.smap.infrastructure.mappers.users.UserEntityMapper;
import cat.smap.domain.models.pojos.User;
import cat.smap.domain.ports.out.UserRepository;
import cat.smap.infrastructure.entities.users.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserAdapter userAdapter;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryImpl(UserAdapter userAdapter, UserEntityMapper userEntityMapper) {
        this.userAdapter = userAdapter;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User findByUsername(String username) {
        UserEntity found = userAdapter.findByUsername(username);
        return userEntityMapper.userEntityToUserDomain(found);
    }

    @Override
    public User save(User user) {
        UserEntity toSave = userEntityMapper.userDomaintoUserEntity(user);
        UserEntity saved = userAdapter.save(toSave);
        return userEntityMapper.userEntityToUserDomain(saved);
    }

    @Override
    public User findById(UUID id) {
        UserEntity entity = userAdapter.findById(id);
        return userEntityMapper.userEntityToUserDomain(entity);
    }

    @Override
    public User findByPk(Long pk) {
        UserEntity entity = userAdapter.findByPk(pk);
        return userEntityMapper.userEntityToUserDomain(entity);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userAdapter.findAll();
        return userEntities.stream()
                .map(userEntityMapper::userEntityToUserDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User delete(User user) {
        userAdapter.delete(userEntityMapper.userDomaintoUserEntity(user));
        return user;
    }
}
