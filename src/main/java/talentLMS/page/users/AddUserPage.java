package talentLMS.page.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import talentLMS.entity.User;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.util.List;
import java.util.Random;

public class AddUserPage extends BasePage {

    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    @FindBy(css = "div.btn-group > a.btn.btn-primary[href*='/user/create'")
    public WebElement addUserButton;

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@name = 'surname']")
    public WebElement lastName;
    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement email;
    @FindBy(xpath = "//input[@name='login']")
    public WebElement username;
    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement password;
    @FindBy(xpath = "//span[text()='Trainer-Type']/ancestor::a[contains(@class, 'select2-choice')]")
    public WebElement userTypeButton;
    @FindBy(name = "acl_user_type_id")
    public WebElement userTypeOptions;
    @FindBy(xpath = "//input[@name ='submit_personal_details']")
    public WebElement addUserSubmitButton;


    public AddUserPage addNewUser(User user) {
        webElementActions.click(adminDashboardPage.users)
                .click(addUserButton)
                .sendKeys(firstName, user.getFirstName())
                .sendKeys(lastName, user.getLastName())
                .sendKeys(email, user.getEmail())
                .sendKeys(username, user.getUserName())
                .sendKeys(password, RandomUserGenerator.generateStrongPassword(10))
                .click(addUserSubmitButton);
        return this;
    }

    public AddUserPage updateInfoOfUsers(String username) {
        driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']")).click();
        firstName.clear();
        lastName.clear();
        webElementActions.sendKeys(firstName, RandomUserGenerator.randomFirstName())
                .sendKeys(lastName,RandomUserGenerator.randomLastName())
                .click(userTypeOptions);
        Select select = new Select(userTypeOptions);
        // Получаем все доступные опции
        List<WebElement> options = select.getOptions();

        // Генерируем случайный индекс
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());  // Генерирует от 0 до (размер списка - 1)

        // Выбираем случайный элемент
        select.selectByIndex(randomIndex);
//                .click(addUserSubmitButton);
        return this;
    }
}