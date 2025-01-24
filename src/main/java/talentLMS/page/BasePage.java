package talentLMS.page;

import org.openqa.selenium.WebDriver;
import talentLMS.driver.Driver;
import talentLMS.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import talentLMS.page.users.AddUserPage;


public abstract class BasePage {
   public WebElementActions webElementActions = new WebElementActions();
    public WebDriver driver;


    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
