package talentLMS.page.dashboard.modern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class AdminDashboardModernPage extends BasePage {

    @FindBy(xpath = "//div[@data-testid='profile-menu-button']")
    public WebElement profileMenuButton;

    @FindBy(xpath = "//a[@data-testid='legacy-menu-item']")
    public WebElement legacyInterfaceBtn;

    @FindBy(xpath = "//a[@data-testid='logout-menu-item']")
    public WebElement logOutButton;

    public AdminDashboardModernPage goToLegacyInterface() {
        webElementActions.moveToElement(profileMenuButton)
                .click(legacyInterfaceBtn);
        return this;
    }

    public AdminDashboardModernPage logOut() {
        webElementActions.moveToElement(profileMenuButton)
                .click(logOutButton);
        return this;
    }
}