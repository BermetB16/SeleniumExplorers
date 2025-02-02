package talentLMS.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {

    private String courseName;
    private String courseCategoryName;
    private String description;

}