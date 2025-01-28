import org.openqa.selenium.interactions.Actions;
import talentLMS.driver.Driver;
import talentLMS.entity.User;
import talentLMS.helper.WebElementActions;
import talentLMS.page.BasePage;
import talentLMS.page.dashboard.DashboardPage;
import talentLMS.page.groups.GroupsPage;
import talentLMS.page.login.LoginPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

    public abstract class BaseTest {
        public WebDriver driver;
        WebElementActions webElementActions;
        LoginPage loginPage;
        DashboardPage dashboardPage;
        AddUserPage addUserPage;
        RandomUserGenerator randomUserGenerator;
        Actions actions;
        User randomUser;

        @BeforeSuite
        public void beforeSuite() {
            driver = Driver.getDriver();
            webElementActions = new WebElementActions();
            loginPage = new LoginPage();
            dashboardPage = new DashboardPage();
            addUserPage = new AddUserPage();
            randomUserGenerator = new RandomUserGenerator();
            actions = new Actions(driver);
            randomUser = randomUserGenerator.randomUser();
            GroupsPage groupsPage=new GroupsPage();


        }


    }

