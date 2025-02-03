package talentLMS.utils.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Role {

    ADMIN("tl-administrator-option/a"),
    INSTRUCTOR("tl-instructor-option/a"),
    LEARNER("tl-learner-option/a"),;

    String xPath;

    Role(String xPath) {
        this.xPath = xPath;
    }
}