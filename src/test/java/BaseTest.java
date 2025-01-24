import talentLMS.driver.Driver;
import talentLMS.helper.WebElementActions;
import talentLMS.page.dashboard.DashboardPage;
import talentLMS.page.login.LoginPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    public WebDriver driver;
    WebElementActions webElementActions = new WebElementActions();

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AddUserPage addUserPage = new AddUserPage();
    RandomUserGenerator randomUserGenerator = new RandomUserGenerator();

    @BeforeSuite
    public void beforeSuite(){
        driver = Driver.getDriver();
    }
}
