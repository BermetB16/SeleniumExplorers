import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.driver.Driver;
import talentLMS.entity.User;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.login.LoginPage;

import java.time.Duration;

public class UsersTest extends BaseTest {

    @BeforeClass
    public void authorization() {
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
    }

    @Test
    public void addNewUserTest() {
        addUserPage.addNewUser(randomUser);
    }

    @Test
    public void renameFirstNAme() {
        addUserPage.updateInfoOfUsers("A. Rockhold");
    }


}
