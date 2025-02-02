package talentLMS.utils.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Page {

    USERS("//div[@class='tl-bold-link']/a[normalize-space()= 'Users']"),
    CATEGORIES("//div[@class='tl-bold-link']/a[normalize-space()= 'Categories']"),
    BRANCHES("//div[@class='tl-bold-link']/a[normalize-space()= 'Branches']"),
    USER_TYPES("//div[@class='tl-bold-link']/a[normalize-space()= 'User types']"),
    REPORTS("//div[@class='tl-bold-link']/a[normalize-space()= 'Reports']"),
    COURSES("//div[@class='tl-bold-link']/a[normalize-space()= 'Courses']"),
    GROUPS("//div[@class='tl-bold-link']/a[normalize-space()= 'Groups']"),
    EVENTS_ENGINE("//div[@class='tl-bold-link']/a[normalize-space()= 'Events engine']"),
    IMPORT_EXPORT("//div[@class='tl-bold-link']/a[normalize-space()= 'Import - Export']"),
    ACCOUNT_SETTING("//div[@class='tl-bold-link']/a[normalize-space()= 'Account & Settings']");

    String xPath;

    Page(String xPath) {
        this.xPath = xPath;
    }
}