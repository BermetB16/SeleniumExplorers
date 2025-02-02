package talentLMS.page.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class AdminDashboardNewInterfacePage extends BasePage {

    @FindBy(xpath = "//div[@data-testid='profile-menu-button']")
    public WebElement profileMenuButton;

    @FindBy(xpath = "//a[@data-testid='legacy-menu-item']")
    public WebElement goToLegacyInterfaceButton;

    public AdminDashboardNewInterfacePage goToLegacyInterface() {
        webElementActions.moveToElement(profileMenuButton)
                .click(goToLegacyInterfaceButton);
        return this;
    }
}