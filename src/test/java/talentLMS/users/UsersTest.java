package talentLMS.users;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;

public class UsersTest extends BaseTest {

    @BeforeClass
    public void authorization() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
    }

//    @Test
//    public void addNewUserTest() {
//        addUserPage.addNewUser(randomUser);
//    }

    @Test
    public void renameFirstNAme() {
        addUserPage.updateInfoOfUsers("A. Rockhold");
    }


}