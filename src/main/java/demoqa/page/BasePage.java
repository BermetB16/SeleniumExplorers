package demoqa.page;

import demoqa.driver.Driver;
import demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
   public WebElementActions webElementActions = new WebElementActions();

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
