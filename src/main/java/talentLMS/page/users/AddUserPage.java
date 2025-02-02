package talentLMS.page.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.entity.User;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.AdminDashboardPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

public class AddUserPage extends BasePage {

    AdminDashboardPage dashboardPage = new AdminDashboardPage();

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
    @FindBy(xpath = "//input[@name ='submit_personal_details']")
    public WebElement addUserSubmitButton;

    public AddUserPage addNewUser(User user) {
        webElementActions.click(dashboardPage.addUserButton)
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
        webElementActions.sendKeys(firstName, RandomUserGenerator.randomFirstName())
                .click(new AddUserPage().addUserSubmitButton);
        return this;
    }
}