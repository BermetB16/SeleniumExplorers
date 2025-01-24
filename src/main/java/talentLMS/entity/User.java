package talentLMS.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

}
