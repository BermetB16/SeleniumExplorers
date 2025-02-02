import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import talentLMS.fileUtils.ConfigReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @BeforeTest
    void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
    }

    @Test
    public void testLogin() {
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));

        assertTrue(webElementActions.isDisplayed(adminDashboardNewInterfacePage.profileMenuButton));
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

        assertEquals(loginPage.userNameError.getText(), "This is a required field");
        assertEquals(loginPage.passwordError.getText(), "This is a required field");
    }

    @AfterMethod
    public void tearDown() {
        browserManager.back();
    }
}