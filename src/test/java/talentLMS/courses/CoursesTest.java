package talentLMS.courses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;

public class CoursesTest extends BaseTest {

    @BeforeClass
    public void authorization(){
        driver.get("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
    }

    @Test
    public void addCourseTest(){
//        addCoursePage.addCourse(randomCourse);
    }

}