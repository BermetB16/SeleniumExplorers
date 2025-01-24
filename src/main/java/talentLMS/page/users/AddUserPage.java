package talentLMS.page.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.BasePage;

public class AddUserPage extends BasePage {
    @FindBy(name = "name")
    public WebElement firstName;

    @FindBy(name = "surname")
    public WebElement lastName;

    @FindBy(name = "email")
    public WebElement emailAddress;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "login")
    public WebElement login;

    @FindBy(name = "submit_personal_details")
    public WebElement addUserBtn;


}
