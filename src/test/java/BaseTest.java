import org.openqa.selenium.interactions.Actions;
import talentLMS.driver.Driver;
import talentLMS.entity.Course;
import talentLMS.entity.User;
import talentLMS.helper.BrowserManager;
import talentLMS.helper.WebElementActions;
import talentLMS.page.courses.AddCoursePage;
import talentLMS.page.dashboard.AdminDashboardNewInterfacePage;
import talentLMS.page.dashboard.AdminDashboardPage;
import talentLMS.page.login.LoginPage;
import talentLMS.page.categories.AddCategoryPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.page.categories.DeleteCategoryPage;
import talentLMS.utils.randomEntityUtils.RandomCourseGenerator;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {

    WebDriver driver;
    Actions actions;
    WebElementActions webElementActions;
    BrowserManager browserManager;

    LoginPage loginPage = new LoginPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    AdminDashboardNewInterfacePage adminDashboardNewInterfacePage = new AdminDashboardNewInterfacePage();
    AddUserPage addUserPage = new AddUserPage();
    AddCoursePage addCoursePage = new AddCoursePage();
    DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();
    AddCategoryPage addCategoryPage = new AddCategoryPage();

    RandomUserGenerator randomUserGenerator = new RandomUserGenerator();
    User randomUser = randomUserGenerator.randomUser();
    RandomCourseGenerator randomCourseGenerator = new RandomCourseGenerator();
    Course randomCourse = randomCourseGenerator.randomCourse();

    @BeforeSuite
    public void beforeSuite() {
        driver = Driver.getDriver();
        actions = new Actions(driver);
        webElementActions = new WebElementActions(driver, actions);
        browserManager = new BrowserManager(driver);
    }
}