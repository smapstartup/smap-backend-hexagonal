package cat.smap.infrastructure.repositories;

import cat.smap.infrastructure.mappers.UserEntityMapper;
import cat.smap.domain.models.pojos.User;
import cat.smap.domain.ports.out.UserAdapter;
import cat.smap.infrastructure.entities.UserEntity;
import cat.smap.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserAdapter {

    private final UserJPA userJPA;
    private final UserEntityMapper userEntityMapper;

    public UserRepository(UserJPA userJPA, UserEntityMapper userEntityMapper) {
        this.userJPA = userJPA;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User findById(Long id) {
        UserEntity entity = userJPA.findById(id).orElseThrow(
                () -> new NotFoundException("No hi cap user amb id " + id)
        );
        return userEntityMapper.toDomain(entity);
    }

    @Override
    public User save(User user) {
        UserEntity toCreate = userEntityMapper.toEntity(user);
        UserEntity created = userJPA.save(toCreate);
        return userEntityMapper.toDomain(created);
    }
}
