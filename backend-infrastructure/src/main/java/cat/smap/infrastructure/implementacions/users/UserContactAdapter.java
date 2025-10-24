package cat.smap.infrastructure.implementacions.users;

import cat.smap.domain.models.types.ContactType;
import cat.smap.infrastructure.entities.users.UserContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserContactAdapter extends JpaRepository<UserContactEntity, Long> {
    UserContactEntity findByPk(Long pk);
    UserContactEntity findByUserId(UUID userId);
    UserContactEntity findByContactType(ContactType contactType);
    UserContactEntity findByMain(boolean main);
    UserContactEntity findByContactData(String data);
}
