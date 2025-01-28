import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import talentLMS.driver.Driver;
import talentLMS.entity.User;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.login.LoginPage;

import java.time.Duration;

public class UsersTest extends BaseTest{
    @Test
    public void addNewUserTest(){

        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface()
                .addNewUser(randomUser);


    }

    @Test
    public void renameFirstNAme(){
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password")).goToLegacyInterface()
                .updateInfoOfUsers("A. Rockhold");
    }


}
