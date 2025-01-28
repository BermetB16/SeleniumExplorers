package talentLMS.page.dashboard;

import org.openqa.selenium.By;
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
    public WebElement addUserButton;

    @FindBy(xpath = "//div[@data-testid='profile-menu-button']")
    public WebElement profileMenuButton;

    @FindBy(xpath = "//a[@data-testid='legacy-menu-item']")
    public WebElement goToLegacyInterfaceButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[@href = \"https://seleniumexplorers.talentlms.com/user/index/gridPref:reset\"]")
    public WebElement usersButton;

//    @FindBy(xpath = "//tr[@role='row']/td/a/span[text()='B. Welch']")
//    public WebElement userInfo;

    @FindBy(xpath = "//input[@type='text' and @name='name']")
    public WebElement firstNameField;



    public AddUserPage addNewUser(User user) {
        webElementActions.click(addUserButton);
        webElementActions.sendKeys(new AddUserPage().firstName, user.getFirstName())
                .sendKeys(new AddUserPage().lastName, user.getLastName())
                .sendKeys(new AddUserPage().email, user.getEmail())
                .sendKeys(new AddUserPage().username, user.getUserName())
                .sendKeys(new AddUserPage().password, AddUserPage.generateStrongPassword(30))
                .click(new AddUserPage().addUserButton);
        return new AddUserPage();
    }

    public AddUserPage updateInfoOfUsers(String username){
        webElementActions.click(usersButton);
        driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']")).click();
        firstNameField.clear();
        webElementActions.sendKeys(firstNameField,randomUserGenerator.randomFirstName()).click(new AddUserPage().addUserButton);
        return new AddUserPage();


    }






    public DashboardPage goToLegacyInterface() {
        actions.moveToElement(profileMenuButton).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(goToLegacyInterfaceButton));
        webElementActions.click(goToLegacyInterfaceButton);
        return this;
    }
}

