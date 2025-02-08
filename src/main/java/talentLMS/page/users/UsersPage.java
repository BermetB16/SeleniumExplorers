package talentLMS.page.users;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import talentLMS.entity.User;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.page.reports.usersReports.UserReportProgressPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class UsersPage extends BasePage {

    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    Random random = new Random();
    AddUserPage addUserPage = new AddUserPage();


    @FindBy(css = "div.btn-group > a.btn.btn-primary[href*='/user/create'")
    public WebElement addUserButton;

    @FindBy(xpath = "//a[@class='btn active' and text()='Profile']")
    public WebElement profileButton;

    @FindBy(xpath ="//a[@class='btn active' and text()='Progress']")
    public WebElement progressButton;

    @FindBy(xpath = "//a[@class='btn active' and text()='Infographic']")
    public WebElement infographicButton;

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis' and contains(text(), 'Home')]")
    public WebElement headHomeField;

    public UserReportProgressPage goToReports() {
        webElementActions.click(adminDashboardPage.users);
        List<WebElement> reportsList = driver.findElements(By.xpath("//i[@title='Reports']"));
        if (reportsList.isEmpty()) {
            throw new NoSuchElementException("No 'Reports' elements found.");
        }
        int randomIndex = random.nextInt(reportsList.size());
        WebElement randomReport = reportsList.get(randomIndex);
        try {
            webElementActions.scrollToElement(randomReport).jsClick(randomReport);
            return new UserReportProgressPage();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on 'Reports': " + e.getMessage(), e);
        }
    }



    public void logIntoAccount() {
        webElementActions.click(adminDashboardPage.users);
        List<WebElement> accountsList = driver.findElements(By.xpath("//i[@title='Log into account']"));
        if (accountsList.isEmpty()) {
            throw new NoSuchElementException("No 'Log into account' elements found."); // Выбрасываем исключение
        }
        int randomIndex = random.nextInt(accountsList.size());
        WebElement randomAccount = accountsList.get(randomIndex);
        try {
            webElementActions.scrollToElement(randomAccount).jsClick(randomAccount);
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on the account: " + e.getMessage(), e);
        }
    }



    public EditProfileUserPage goToEdit() {
        webElementActions.click(adminDashboardPage.users);
        List<WebElement> editsList = driver.findElements(By.xpath("//i[@title='Edit']"));
        if (editsList.isEmpty()) {
            throw new NoSuchElementException("No 'Edit' elements found."); // Выбрасываем исключение
        }
        int randomIndex = random.nextInt(editsList.size());
        WebElement randomEdit = editsList.get(randomIndex);
        try {
            webElementActions.scrollToElement(randomEdit).jsClick(randomEdit);
            return new EditProfileUserPage();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on 'Edit': " + e.getMessage(), e);
        }
    }



    public AddUserPage addNewUser(User user) {
        webElementActions.click(adminDashboardPage.users)
                .click(addUserButton)
                .sendKeys(addUserPage.firstName, user.getFirstName())
                .sendKeys(addUserPage.lastName, user.getLastName())
                .sendKeys(addUserPage.email, user.getEmail())
                .sendKeys(addUserPage.username, user.getUserName())
                .sendKeys(addUserPage.password, RandomUserGenerator.generateStrongPassword(10))
                .click(addUserPage.userSubmitButton);
        return new AddUserPage();
    }
}
