package talentLMS.dashboard;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;

import static org.testng.Assert.assertTrue;

public class AdminDashboardTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
    }

    @Test
    public void adminDashboardPage() {
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.users));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.courses));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.categories));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.groups));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.branches));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.events));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.userTypes));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.importExport));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.reports));
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.accountSettings));
    }

    @Test
    public void testAddUser() {
        webElementActions.click(adminDashboardPage.usersAddUserLink);
        assertTrue(webElementActions.isDisplayed(adminDashboardPage.users));
    }
}