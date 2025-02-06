package talentLMS.page.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.util.List;
import java.util.Random;

public class EditProfileUserPage extends BasePage {

    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    AddUserPage addUserPage = new AddUserPage();

    @FindBy(xpath = "//a[text()='Info']")
    public WebElement infoSection;

    @FindBy(xpath = "//a[text()='Courses']")
    public WebElement coursesSection;

    @FindBy(xpath = "//a[text()='Groups']")
    public WebElement groupsSection;

    @FindBy(xpath = "//a[text()='Branches']")
    public WebElement branchesSection;

    @FindBy(xpath = "//a[text()='Files']")
    public WebElement filesSection;


    public EditProfileUserPage updateInfoOfUsers(String username) {
        webElementActions.click(adminDashboardPage.users);
        webElementActions.click(driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']")));
        addUserPage.firstName.clear();
        addUserPage.lastName.clear();
        webElementActions.sendKeys(addUserPage.firstName, RandomUserGenerator.randomFirstName())
                         .sendKeys(addUserPage.lastName, RandomUserGenerator.randomLastName());
        Select userTypeSelect = new Select(addUserPage.userTypeOptions);
        Select timeZoneSelect = new Select(addUserPage.timeZoneOptions);
        Select languageSelect = new Select(addUserPage.languageOptions);

        List<WebElement> userTypeOptions = userTypeSelect.getOptions();
        List<WebElement> timeZoneOptions = timeZoneSelect.getOptions();
        List<WebElement> languageOptions = languageSelect.getOptions();

        Random random = new Random();
        webElementActions.click(addUserPage.userTypeField);
        userTypeSelect.selectByIndex(random.nextInt(userTypeOptions.size()));
        webElementActions.click(addUserPage.timeZoneField);
        timeZoneSelect.selectByIndex(random.nextInt(timeZoneOptions.size()));
        webElementActions.click(addUserPage.languageField);
        languageSelect.selectByIndex(random.nextInt(languageOptions.size()));

        webElementActions.click(addUserPage.userSubmitButton);
        return this;
    }
}
