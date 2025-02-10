package talentLMS.base;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import talentLMS.driver.Driver;
import talentLMS.entity.Course;
import talentLMS.entity.User;
import talentLMS.helper.BrowserManager;
import talentLMS.helper.WebElementActions;
import talentLMS.page.base.PageNavigator;
import talentLMS.page.courses.AddCoursePage;
import talentLMS.page.dashboard.modern.AdminDashboardModernPage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.page.groups.GroupsPage;
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
    public Actions actions;
    public WebElementActions webElementActions;
    public BrowserManager browserManager;

    public LoginPage loginPage = new LoginPage();
    public AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    public AdminDashboardModernPage adminDashboardModernPage = new AdminDashboardModernPage();
    public AddUserPage addUserPage = new AddUserPage();
    public AddCoursePage addCoursePage = new AddCoursePage();
    public DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();
    public AddCategoryPage addCategoryPage = new AddCategoryPage();

    public RandomUserGenerator randomUserGenerator = new RandomUserGenerator();
    public User randomUser = randomUserGenerator.randomUser();
    public RandomCourseGenerator randomCourseGenerator = new RandomCourseGenerator();
    public Course randomCourse = randomCourseGenerator.randomCourse();
    public GroupsPage groupsPage =new GroupsPage();

    public PageNavigator pageNavigator=new PageNavigator();


    @BeforeSuite
    public void beforeSuite() {
        driver = Driver.getDriver();
        actions = new Actions(driver);
        webElementActions = new WebElementActions(driver, actions);
        browserManager = new BrowserManager(driver);

    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
        driver.quit();
    }
}