package talentLMS.base;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import talentLMS.driver.Driver;
import talentLMS.entity.Course;
import talentLMS.entity.User;
import talentLMS.helper.BrowserManager;
import talentLMS.helper.WebElementActions;
import talentLMS.page.base.PageNavigator;
import talentLMS.page.branches.BranchesPage;
import talentLMS.page.courses.AddCoursePage;
import talentLMS.page.courses.CoursePage;
import talentLMS.page.courses.EditCoursePage;
import talentLMS.page.dashboard.modern.AdminDashboardModernPage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.page.groups.GroupsPage;
import talentLMS.page.login.LoginPage;
import talentLMS.page.categories.AddCategoryPage;
import talentLMS.page.reports.coursesReports.CourseInfoReportPage;
import talentLMS.page.reports.coursesReports.CourseReportsPage;
import talentLMS.page.reports.main_reports.ReportsPage;
import talentLMS.page.reports.usersReports.UserReportProgressPage;
import talentLMS.page.reports.usersReports.UserReportsPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.page.categories.DeleteCategoryPage;
import talentLMS.page.users.EditProfileUserPage;
import talentLMS.page.users.UsersPage;
import talentLMS.utils.randomEntityUtils.RandomCourseGenerator;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public abstract class BaseTest {

    public WebDriver driver;
    public Actions actions;
    public WebElementActions webElementActions;
    public BrowserManager browserManager;
    public WebDriverWait wait;

    public LoginPage loginPage = new LoginPage();
    public AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    public AdminDashboardModernPage adminDashboardModernPage = new AdminDashboardModernPage();
    public AddUserPage addUserPage = new AddUserPage();
    public CoursePage coursePage = new CoursePage();
    public EditCoursePage editCoursePage = new EditCoursePage();
    public AddCoursePage addCoursePage = new AddCoursePage();
    public DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();
    public AddCategoryPage addCategoryPage = new AddCategoryPage();
    public EditProfileUserPage profileUserPage = new EditProfileUserPage();
    public UsersPage usersPage = new UsersPage();
    public UserReportProgressPage userReportProgressPage = new UserReportProgressPage();
    public CourseReportsPage courseReportsPage = new CourseReportsPage();
    public CourseInfoReportPage courseInfoReportPage = new CourseInfoReportPage();
    public ReportsPage reportsPage = new ReportsPage();
    public UserReportsPage userReportsPage = new UserReportsPage();
    public PageNavigator pageNavigator = new PageNavigator();
    public GroupsPage groupsPage = new GroupsPage();
    public BranchesPage branchesPage = new BranchesPage();


    public RandomUserGenerator randomUserGenerator = new RandomUserGenerator();
    public User randomUser = randomUserGenerator.randomUser();
    public RandomCourseGenerator randomCourseGenerator = new RandomCourseGenerator();
    public Course randomCourse = randomCourseGenerator.randomCourse();

    @BeforeSuite
    public void beforeSuite() {
        driver = Driver.getDriver();
        actions = new Actions(driver);
        webElementActions = new WebElementActions(driver, actions);
        browserManager = new BrowserManager(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
        driver.quit();
    }
}