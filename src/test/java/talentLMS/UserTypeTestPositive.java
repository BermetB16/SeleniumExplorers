package talentLMS;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.utils.enums.Page;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTypeTestPositive extends BaseTest {
    @BeforeClass
    public void authorization() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
        pageNavigator.switchToPage(Page.USER_TYPES);
    }

    @Test
    public void testSelectUserType() {
        String userType = "Trainer";
        userTypesPage.selectUserType(userType);
        WebElement dropdownElement = driver.findElement(By.id("userTypeDropdown"));
        Select select = new Select(dropdownElement);
        assertEquals(select.getFirstSelectedOption().getText(), userType);
    }

    @Test
    public void testUpdateUserInfo() {
        String username = "testUser";
        userTypesPage.updateInfoOfUsers(username);
        String expectedFirstName = RandomUserGenerator.randomFirstName();
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        assertEquals(firstNameElement.getAttribute("value"), expectedFirstName);
    }

    @Test
    public void testUserTypeDropdownIsDisplayed() {
        WebElement dropdown = driver.findElement(By.id("userTypeDropdown"));
        assertTrue(dropdown.isDisplayed());
    }

    @Test
    public void testNavigateToUserTypesPage() {
        pageNavigator.switchToPage(Page.USER_TYPES);
        assertEquals(driver.getCurrentUrl(), "https://seleniumexplorers.talentlms.com/plus/user_types");
    }

    @Test
    public void testAdminCanSelectAllUserTypes() {
        String[] userTypes = {"Trainer", "Learner", "Admin"};
        WebElement dropdownElement = driver.findElement(By.id("userTypeDropdown"));
        Select select = new Select(dropdownElement);
        for (String userType : userTypes) {
            userTypesPage.selectUserType(userType);
            assertEquals(select.getFirstSelectedOption().getText(), userType);
        }
    }

    @Test
    public void testSaveButtonIsEnabled() {
        WebElement saveButton = driver.findElement(By.id("saveButton"));
        assertTrue(saveButton.isEnabled());
    }

    @Test
    public void testUserSearchFunctionality() {
        String username = "testUser";
        userTypesPage.searchUser(username);
        WebElement searchResult = driver.findElement(By.xpath("//td[contains(text()," +
                " '" + username + "')]"));
        assertTrue(searchResult.isDisplayed());
    }

    @Test
    public void testDefaultUserTypeSelection() {
        WebElement dropdownElement = driver.findElement(By.id("userTypeDropdown"));
        Select select = new Select(dropdownElement);
        assertEquals(select.getFirstSelectedOption().getText(), "Learner");
    }

    @Test
    public void testPageTitle() {
        assertEquals(driver.getTitle(), "User Types - TalentLMS");
    }

    @Test
    public void testLogoutFunctionality() {
        userTypesPage.logout();
        assertEquals(driver.getCurrentUrl(), "https://seleniumexplorers.talentlms.com/plus/login");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



