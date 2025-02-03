package talentLMS.login;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @BeforeClass
    void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
    }

    @Test
    public void testLogin() {
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));

        assertTrue(webElementActions.isDisplayed(adminDashboardModernPage.profileMenuButton));

        adminDashboardModernPage.logOut();
    }

    @Test
    public void testNegativeLogin() {
        loginPage.doLogin("admin", "admin");

        assertTrue(webElementActions.isDisplayed(loginPage.loginErrorContainer));
        assertEquals(loginPage.loginErrorContainer.getText(), "Your username or password is incorrect. Please try again.");
    }

    @Test
    public void testWithEmptyFields() {
        loginPage.doLogin("", "");

        assertTrue(webElementActions.isDisplayed(loginPage.userNameError));
        assertTrue(webElementActions.isDisplayed(loginPage.passwordError));

        String errorMessage = "This is a required field";

        assertEquals(loginPage.userNameError.getText(), errorMessage);
        assertEquals(loginPage.passwordError.getText(), errorMessage);
    }

    @AfterMethod
    public void tearDown() {
        browserManager.refresh();
    }
}