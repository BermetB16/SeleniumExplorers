package talentLMS.page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import talentLMS.driver.Driver;
import talentLMS.helper.BrowserManager;
import talentLMS.helper.WebElementActions;

public class BasePage {

    public static WebDriver driver;
    public Actions actions;
    public static WebElementActions webElementActions;
    public BrowserManager browserManager;

    public BasePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        webElementActions = new WebElementActions(driver, actions);
        browserManager = new BrowserManager();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchUser(String username) {
    }

    public void logout() {
        
    }

    public void updateInfoOfUsers(String username, String s, String s1) {

    }
}