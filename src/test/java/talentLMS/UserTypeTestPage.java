package talentLMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.users.UserTypesPage;
import talentLMS.utils.enums.Page;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

public class UserTypeTestPage extends BaseTest {

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

        // Проверяем, что значение действительно изменилось
        WebElement dropdownElement = driver.findElement(By.id("userTypeDropdown"));
        Select select = new Select(dropdownElement);
        assertEquals(select.getFirstSelectedOption().getText(), userType);
    }

    @Test
    public void testUpdateUserInfo() {
        String username = "testUser";
        userTypesPage.updateInfoOfUsers(username);

        // Получаем сгенерированное имя пользователя
        String expectedFirstName = RandomUserGenerator.randomFirstName();
        WebElement firstNameElement = driver.findElement(By.id("firstName"));

        // Ждем изменения (если нужно, можно добавить WebDriverWait)
        assertEquals(firstNameElement.getAttribute("value"), expectedFirstName);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
