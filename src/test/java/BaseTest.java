import org.openqa.selenium.interactions.Actions;
import talentLMS.driver.Driver;
import talentLMS.entity.Course;
import talentLMS.entity.User;
import talentLMS.helper.WebElementActions;
import talentLMS.page.courses.AddCoursePage;
import talentLMS.page.dashboard.DashboardPage;
import talentLMS.page.login.LoginPage;
import talentLMS.page.categories.AddCategoryPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.page.categories.DeleteCategoryPage;
import talentLMS.utils.randomEntityUtils.RandomCourseGenerator;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

    public abstract class BaseTest {
        public WebDriver driver;
        Actions actions;
        WebElementActions webElementActions = new WebElementActions();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        AddUserPage addUserPage = new AddUserPage();
        RandomUserGenerator randomUserGenerator = new RandomUserGenerator();
        User randomUser = randomUserGenerator.randomUser();
        AddCoursePage addCoursePage = new AddCoursePage() ;
        RandomCourseGenerator randomCourseGenerator = new RandomCourseGenerator(); ;
        Course randomCourse  = randomCourseGenerator.randomCourse();
        DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();

        AddCategoryPage addCategoryPage = new AddCategoryPage();

        @BeforeSuite
        public void beforeSuite() {
            driver = Driver.getDriver();
            actions = new Actions(driver);
        }


    }

