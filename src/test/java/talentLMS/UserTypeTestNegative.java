package talentLMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;

import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UserTypeTestNegative extends BaseTest {
    @Test
    public void testSelectInvalidUserType() {
        String invalidUserType = "InvalidType";
        userTypesPage.selectUserType(invalidUserType);
        WebElement dropdownElement = driver.findElement(By.id("userTypeDropdown"));
        Select select = new Select(dropdownElement);
        assertNotEquals(select.getFirstSelectedOption().getText(), invalidUserType);
    }

    @Test
    public void testUpdateUserWithInvalidData() {
        String username = "testUser";
        userTypesPage.updateInfoOfUsers(username, "", ""); // Пустые данные
        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        assertNotEquals(firstNameElement.getAttribute("value"), "");
    }

    @Test
    public void testUserTypeDropdownNotDisplayed() {
        driver.navigate().to("https://seleniumexplorers.talentlms.com/plus/dashboard"); // Другая страница
        List<WebElement> dropdowns = driver.findElements(By.id("userTypeDropdown"));
        assertTrue(dropdowns.isEmpty());
    }

    @Test
    public void testInvalidLogin() {
        loginPage.doLogin("wrongUser", "wrongPass");
        WebElement errorMsg = driver.findElement(By.id("loginError"));
        assertTrue(errorMsg.isDisplayed());
    }

    @Test
    public void testUnauthorizedUserCannotAccessUserTypesPage() {
        loginPage.doLogin("learnerUser", "password");
        driver.navigate().to("https://seleniumexplorers.talentlms.com/plus/user_types");
        assertNotEquals(driver.getCurrentUrl(), "https://seleniumexplorers.talentlms.com/plus/user_types");
    }

    @Test
    public void testSaveButtonDisabledWithoutChanges() {
        WebElement saveButton = driver.findElement(By.id("saveButton"));
        assertFalse(saveButton.isEnabled());
    }

    @Test
    public void testSearchNonExistentUser() {
        String username = "nonExistentUser";
        userTypesPage.searchUser(username);
        List<WebElement> searchResults = driver.findElements(By.xpath("//td[contains(text(), '" + username + "')]"));
        assertTrue(searchResults.isEmpty());
    }

    @Test
    public void testEmptyUserTypeSelection() {
        userTypesPage.selectUserType("");
        WebElement dropdownElement = driver.findElement(By.id("userTypeDropdown"));
        Select select = new Select(dropdownElement);
        assertNotEquals(select.getFirstSelectedOption().getText(), "");
    }

    @Test
    public void testIncorrectPageTitle() {
        assertNotEquals(driver.getTitle(), "Wrong Title");
    }

    @Test
    public void testLogoutRedirectFailure() {
        userTypesPage.logout();
        assertNotEquals(driver.getCurrentUrl(), "https://seleniumexplorers.talentlms.com/plus/dashboard");
    }

}
