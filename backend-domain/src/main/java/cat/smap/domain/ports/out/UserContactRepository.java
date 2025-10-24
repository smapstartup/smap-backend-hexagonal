package cat.smap.domain.ports.out;

import cat.smap.domain.models.pojos.UserContact;
import cat.smap.domain.models.types.ContactType;

import java.util.UUID;

public interface UserContactRepository {
    UserContact findById(UUID id);
    UserContact save(UserContact userContact);
    UserContact delete(UserContact userContact);
    UserContact findByPk(Long pk);
    UserContact findByMain(boolean main);
    UserContact findByContactType(ContactType contactType);
    UserContact findByUserId(UUID userId);
    UserContact findByContactData(String data);
}
