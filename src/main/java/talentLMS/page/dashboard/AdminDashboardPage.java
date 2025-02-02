package talentLMS.page.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class AdminDashboardPage extends BasePage {

    @FindBy(xpath = "//div[@id='tl-admin-dashboard']/div[@class='tl-icons-block']/div[@class='tl-icon-label']/div[@class='hidden-phone']/a[contains(text(),'Add course')]")
    public WebElement addCourseButton;

    @FindBy(xpath = "//div[@id='tl-admin-users']//div[@class='hidden-phone']/a[contains(text(),'Add user')]")
    public WebElement addUserButton;

    @FindBy(xpath = "//div[@data-testid='profile-menu-button']")
    public WebElement profileMenuButton;

    @FindBy(xpath = "//a[@data-testid='legacy-menu-item']")
    public WebElement goToLegacyInterfaceButton;

    @FindBy(xpath = "//a[@href=\"https://seleniumexplorers.talentlms.com/category/create\"]")
    public WebElement addCategoryBtn;

    public AdminDashboardPage goToLegacyInterface() {
        webElementActions.moveToElement(profileMenuButton);
        webElementActions.click(goToLegacyInterfaceButton);
        return this;
    }
}