import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.helper.WebElementActions;
import talentLMS.page.AdminPage;
import talentLMS.page.groups.GroupsPage;
import talentLMS.page.login.LoginPage;

import java.time.Duration;



public class GroupTest extends BaseTest {


    @Test
    public void testCreateGroup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AdminPage adminPage = new AdminPage();
        GroupsPage groupsPage = new GroupsPage();



        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface();


       adminPage.clickGroupsBtn();
       groupsPage.clickAddGroup()

               .enterGroupName("SeleniumExplorers")
                .enterGroupDescription("Test Description")
                .clickSaveGroup();


        Assert.assertTrue(groupsPage.getSuccessMessage().contains("successfully created"));
    }

    @Test
    public void testEditGroup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AdminPage adminPage = new AdminPage();
        GroupsPage groupsPage = new GroupsPage();
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface();

        adminPage.clickGroupsBtn();


        groupsPage.clickEditGroup()
                .enterGroupName("Updated Group Name")
                .clickSaveGroup();

        Assert.assertTrue(groupsPage.getSuccessMessage().contains("successfully updated"));
    }

    @Test
    public void testDeleteGroup() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AdminPage adminPage = new AdminPage();
        GroupsPage groupsPage = new GroupsPage();
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface();

        adminPage.clickGroupsBtn();

        groupsPage.clickDeleteGroup();
           groupsPage.confirmDelete();

           Assert.assertTrue(groupsPage.getSuccessMessage().contains("successfully deleted"));
    }
}