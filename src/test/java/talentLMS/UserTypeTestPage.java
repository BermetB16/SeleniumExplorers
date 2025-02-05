package talentLMS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import talentLMS.page.users.UserTypesPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import static org.junit.Assert.assertEquals;

public class UserTypeTestPage {
    private WebDriver driver;
    private UserTypesPage userTypesPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://your.talentlms.instance/admin/users");
        userTypesPage = new UserTypesPage(driver);
    }

    @Test
    public void testSelectUserType() {
        String userType = "Trainer";
        userTypesPage.selectUserType(userType);

        // Проверяем, что значение действительно изменилось
        WebElement dropdownElement = driver.findElement(By.id("userTypeDropdown"));
        Select select = new Select(dropdownElement);
        assertEquals(userType, select.getFirstSelectedOption().getText());
    }

    @Test
    public void testUpdateUserInfo() {
        String username = "testUser";
        userTypesPage.updateInfoOfUsers(username);

        // Получаем сгенерированное имя пользователя
        String expectedFirstName = RandomUserGenerator.randomFirstName();
        WebElement firstNameElement = driver.findElement(By.id("firstName"));

        // Ждем изменения (если нужно, можно добавить WebDriverWait)
        assertEquals(expectedFirstName, firstNameElement.getAttribute("value"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
