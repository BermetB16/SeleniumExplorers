
package talentLMS.page.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

public class UserTypesPage extends BasePage {

    private WebDriver driver;
    AdminDashboardPage dashboardPage;

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name = 'surname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement username;

    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement password;

    @FindBy(xpath = "//select[@name='usertype']")
    public WebElement userTypeDropdown;

    @FindBy(xpath = "//input[@name ='submit_personal_details']")
    public WebElement addUserSubmitButton;

    public UserTypesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.dashboardPage = new AdminDashboardPage(driver);
        PageFactory.initElements(driver, this);
    }

    public UserTypesPage selectUserType(String userType) {
        Select dropdown = new Select(userTypeDropdown);
        dropdown.selectByVisibleText(userType);
        return this;
    }

    public UserTypesPage updateInfoOfUsers(String username) {
        driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']")).click();
        firstName.clear();
        webElementActions.sendKeys(firstName, RandomUserGenerator.randomFirstName())
                .click(addUserSubmitButton);
        return this;
    }
}
