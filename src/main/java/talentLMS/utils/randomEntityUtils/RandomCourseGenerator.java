package talentLMS.utils.randomEntityUtils;

import com.github.javafaker.Faker;
import talentLMS.entity.Course;

import java.util.Locale;

public class RandomCourseGenerator {

    Faker faker = new Faker(new Locale("en"));

    public String randomCourseName() {
        return faker.educator().course();
    }

    public String randomCourseCategory() {
        // Генерация случайного типа курса (например, предметные области)
        String[] courseCategories = {
                "Finance",
                "IT",
                "Medicine",
                "Engineering",
                "Mathematics",
                "Literature",
                "Art",
                "Psychology",
                "Business",
                "Law"
        };
        String courseCategory = courseCategories[faker.number().numberBetween(0, courseCategories.length)];
        return courseCategory;

    }

    public String randomDescription() {
        return faker.lorem().paragraph();
    }

    public Course randomCourse() {
        return new Course(randomCourseName(), randomCourseCategory(), randomDescription());
    }
}
