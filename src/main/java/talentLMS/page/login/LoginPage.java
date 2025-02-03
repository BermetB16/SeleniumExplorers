package talentLMS.page.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement loginBtn;

    @FindBy(css = ".login-error-container")
    public WebElement loginErrorContainer;

    @FindBy(xpath = "//div[@data-testid='username-error']")
    public WebElement userNameError;

    @FindBy(xpath = "//label[@data-testid='password-label']/../../following-sibling::div[text() ='This is a required field']")
    public WebElement passwordError;

    public void doLogin(String username, String password) {
        webElementActions.sendKeys(this.username, username)
                .sendKeys(this.password, password)
                .click(loginBtn);
    }
}