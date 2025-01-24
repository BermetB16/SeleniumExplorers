package talentLMS.page.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.entity.User;
import talentLMS.page.BasePage;
import talentLMS.page.users.AddUserPage;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//a[@href=\"https://seleniumexplorers.talentlms.com/user/create\"]/i")
    public WebElement addUserBtn;

    public AddUserPage addUserPage = new AddUserPage();

    public AddUserPage addNewUser(User user){
        webElementActions.click(addUserBtn);
        webElementActions.sendKeys(addUserPage.firstName, user.getFirstName())
                .sendKeys(addUserPage.lastName, user.getLastName())
                .sendKeys(addUserPage.login, user.getUserName())
                .sendKeys(addUserPage.emailAddress, user.getEmail())
                .sendKeys(addUserPage.password, user.getPassword())
                .click(addUserBtn);
        return new AddUserPage();

    }
}
