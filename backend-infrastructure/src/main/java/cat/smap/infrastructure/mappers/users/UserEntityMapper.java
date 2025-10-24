package cat.smap.infrastructure.mappers.users;

import cat.smap.domain.models.pojos.User;
import cat.smap.domain.models.pojos.UserContact;
import cat.smap.infrastructure.entities.users.UserContactEntity;
import cat.smap.infrastructure.entities.users.UserEntity;
import jakarta.persistence.OneToMany;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    // Del Service cap al Repository
    UserEntity userDomaintoUserEntity(User user);

    UserContactEntity userContactDomaintoUserContactEntity(UserContact userContact);

    // Del Repository cap al Service
    User userEntityToUserDomain(UserEntity entity);
    UserContact userContactEntityToUserContactDomain(UserContactEntity entity);
}
