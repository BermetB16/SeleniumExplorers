import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.fileUtils.ConfigReader;

public class CoursesTest extends BaseTest{

    @BeforeClass
    public void authorization(){
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface();
    }

    @Test
    public void addCourseTest(){
        addCoursePage.addCourse(randomCourse);
    }

}
