package talentLMS.page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import talentLMS.driver.Driver;
import talentLMS.helper.BrowserManager;
import talentLMS.helper.WebElementActions;

public class BasePage {

    public WebDriver driver;
    public Actions actions;
    public WebElementActions webElementActions;
    public BrowserManager browserManager;

    public BasePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        webElementActions = new WebElementActions(driver, actions);
        browserManager = new BrowserManager(driver);
    }
}