import org.testng.annotations.Test;
import talentLMS.entity.User;
import talentLMS.fileUtils.ConfigReader;

public class LoginTest extends BaseTest{
    @Test
    public void testLogin(){
       // User randomUser = randomUserGenerator.randomUser();
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
               // .addNewUser(randomUser);

    }
}
