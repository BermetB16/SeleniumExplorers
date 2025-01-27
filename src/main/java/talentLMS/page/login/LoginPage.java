package talentLMS.page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import talentLMS.page.BasePage;
import talentLMS.page.dashboard.DashboardPage;

import java.time.Duration;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    public WebElement username;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement login;

    @FindBy(xpath = "//p[@class='login-error-container']")
    public WebElement loginErrorContainer;

    @FindBy(xpath = "//div[@data-testid='username-error']")
    public WebElement userNameError;




   public DashboardPage doLogin(String username, String password){
       webElementActions.sendKeys(this.username, username)
               .sendKeys(this.password,password)
               .click(login);
       return new DashboardPage();

   }

public void testNegativeLogin() {
  webElementActions.sendKeys(this.username,"sdsdsdcsdsd")
                    .sendKeys(this.password,"sdcsdc@gamil.com")
                    .click(login);
    String wrongLoginText = loginErrorContainer.getText();
    Assert.assertEquals(wrongLoginText,"Your username or password is incorrect. Please try again.");



}

public void testWithEmptyParametersLogin(){
    webElementActions.sendKeys(this.username,"")
            .sendKeys(this.password,"")
            .click(login);
    String requiredField = userNameError.getText();
    Assert.assertEquals(requiredField,"This is a required field");

}



}
