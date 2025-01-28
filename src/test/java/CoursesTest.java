import org.testng.annotations.Test;
import talentLMS.fileUtils.ConfigReader;

public class CoursesTest extends BaseTest{

    @Test
    public void addCourseTest(){
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface();
        addCoursePage.addCourse(randomCourse);
    }

    @Test
    public void deleteCourse(){
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface();
        addCoursePage.deleteCourse("Binance");

    }

}
