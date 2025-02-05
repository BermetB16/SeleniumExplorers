package talentLMS.groups;

import org.testng.Assert;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.groups.GroupsPage;

public class GroupTest extends BaseTest {

//    @Test
//    public void testCreateGroup() {
//        AdminPage adminPage = new AdminPage();
//        GroupsPage groupsPage = new GroupsPage();
//
//        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
//        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
//
//
//        adminPage.clickGroupsBtn();
//        groupsPage.clickAddGroup()
//
//                .enterGroupName("SeleniumExplorers")
//                .enterGroupDescription("Test Description")
//                .clickSaveGroup();
//
//
//        Assert.assertTrue(groupsPage.getCategorySuccessMessage().contains("successfully created"));
//    }
//
//    @Test
//    public void testEditGroup() {
//        AdminPage adminPage = new AdminPage();
//        GroupsPage groupsPage = new GroupsPage();
//        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
//        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
//
//        adminPage.clickGroupsBtn();
//
//
//        groupsPage.clickEditGroup()
//                .enterGroupName("Updated Group Name")
//                .clickSaveGroup();
//
//        Assert.assertTrue(groupsPage.getCategorySuccessMessage().contains("successfully updated"));
//    }

    @Test
    public void testDeleteGroup() {
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));

//        adminDashboardPage.clickGroupsBtn();
//
//        groupsPage.clickDeleteGroup();
//        groupsPage.confirmDelete();
//
//        Assert.assertTrue(groupsPage.getCategorySuccessMessage().contains("successfully deleted"));
    }
}