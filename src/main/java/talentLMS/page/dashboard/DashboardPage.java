package talentLMS.page.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import talentLMS.driver.Driver;
import talentLMS.entity.User;
import talentLMS.page.BasePage;
import talentLMS.page.users.AddUserPage;

import java.time.Duration;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//div[@id='tl-admin-users']//div[@class='hidden-phone']/a[contains(text(),'Add user')]")
    public WebElement addUserBtn;

    @FindBy(xpath = "//div[@data-testid='profile-menu-button']")
    public WebElement profileMenuBtn;

    @FindBy(xpath = "//a[@data-testid='legacy-menu-item']")
    public WebElement goToLegacyInterfaceBtn;

    public DashboardPage goToLegacyInterface() {
        actions.moveToElement(profileMenuBtn).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(goToLegacyInterfaceBtn));
        webElementActions.click(goToLegacyInterfaceBtn);
        return this;
    }
}

