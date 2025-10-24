package cat.smap.domain.models.pojos;

import cat.smap.domain.models.core.BaseModel;

import java.util.UUID;

public class UserContact extends BaseModel {

    private final User user;
    private final boolean main;
    private final String contactType;
    private final String contactCategory;
    private final String contactData;

    public UserContact(Long pk, UUID id, User user, boolean main, String contactType,
                       String contactCategory, String contactData
    ) {
        super(pk, id);
        this.user = user;
        this.main = main;
        this.contactType = contactType;
        this.contactCategory = contactCategory;
        this.contactData = contactData;
    }

    public User getUser() {
        return user;
    }

    public boolean isMain() {
        return main;
    }

    public String getContactType() {
        return contactType;
    }

    public String getContactData() {
        return contactData;
    }

    public String getContactCategory() {
        return contactCategory;
    }
}
