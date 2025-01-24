package talentLMS.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.BasePage;
import talentLMS.page.dashboard.DashboardPage;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    public WebElement username;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement login;


   public DashboardPage doLogin(String username, String password){
       webElementActions.sendKeys(this.username, username)
               .sendKeys(this.password,password)
               .click(login);
       return new DashboardPage();

   }

}
