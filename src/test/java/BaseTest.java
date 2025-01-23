import com.beust.ah.A;
import demoqa.driver.Driver;
import demoqa.helper.WebElementActions;
import demoqa.page.dashboard.DashboardPage;
import demoqa.page.login.LoginPage;
import demoqa.page.users.AddUserPage;
import demoqa.utils.randomEntityUtils.RandomUserGenerator;
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
