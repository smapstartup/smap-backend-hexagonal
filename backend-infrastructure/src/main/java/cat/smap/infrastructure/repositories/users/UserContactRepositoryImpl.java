package cat.smap.infrastructure.repositories.users;

import cat.smap.domain.models.pojos.UserContact;
import cat.smap.domain.models.types.ContactType;
import cat.smap.domain.ports.out.UserContactRepository;
import cat.smap.infrastructure.entities.users.UserContactEntity;
import cat.smap.infrastructure.implementacions.users.UserContactAdapter;
import cat.smap.infrastructure.mappers.users.UserEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserContactRepositoryImpl implements UserContactRepository {

    private final UserContactAdapter userContactAdapter;
    private final UserEntityMapper userEntityMapper;

    public UserContactRepositoryImpl(UserContactAdapter userContactAdapter, UserEntityMapper userEntityMapper) {
        this.userContactAdapter = userContactAdapter;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public UserContact findById(UUID id) {
        return null;
    }

    @Override
    public UserContact save(UserContact userContact) {
        UserContactEntity toSave = userEntityMapper.userContactDomaintoUserContactEntity(userContact);
        UserContactEntity saved = userContactAdapter.save(toSave);
        return userEntityMapper.userContactEntityToUserContactDomain(saved);
    }

    @Override
    public UserContact delete(UserContact userContact) {
        return null;
    }

    @Override
    public UserContact findByPk(Long pk) {
        return null;
    }

    @Override
    public UserContact findByMain(boolean main) {
        return null;
    }

    @Override
    public UserContact findByContactType(ContactType contactType) {
        return null;
    }

    @Override
    public UserContact findByUserId(UUID userId) {
        return null;
    }

    @Override
    public UserContact findByContactData(String data) {
        UserContactEntity contact = userContactAdapter.findByContactData(data);
        return userEntityMapper.userContactEntityToUserContactDomain(contact);
    }
}
