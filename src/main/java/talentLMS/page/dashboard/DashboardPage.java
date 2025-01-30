package talentLMS.page.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import talentLMS.page.BasePage;

import java.time.Duration;

public class DashboardPage extends BasePage {
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


    public DashboardPage goToLegacyInterface() {
        actions.moveToElement(profileMenuButton).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(goToLegacyInterfaceButton));
        webElementActions.click(goToLegacyInterfaceButton);
        return this;
    }
    public void switchToPage(String page){
        driver.findElement(By.xpath("//div[@class='tl-bold-Link']/a[normalize-space(='" + page +"']"))
                .click();
    }








}

