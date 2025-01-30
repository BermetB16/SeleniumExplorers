package talentLMS.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import talentLMS.driver.Driver;
import talentLMS.entity.Course;
import talentLMS.entity.User;
import talentLMS.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import talentLMS.page.dashboard.DashboardPage;
import talentLMS.page.login.LoginPage;
import talentLMS.utils.randomEntityUtils.RandomCourseGenerator;
import talentLMS.page.categories.AddCategoryPage;
import talentLMS.page.categories.DeleteCategoryPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.time.Duration;


public  class BasePage {
    public WebDriver driver;
    public WebElementActions webElementActions = new WebElementActions();;
    public RandomUserGenerator randomUserGenerator = new RandomUserGenerator();
    public RandomCourseGenerator randomCourseGenerator = new RandomCourseGenerator();
    public Actions actions ;
    public User user = randomUserGenerator.randomUser();
    public LoginPage loginPage = new LoginPage() ;
    public Course course = randomCourseGenerator.randomCourse();
    public AddCategoryPage addCategoryPage = new AddCategoryPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();




    public BasePage() {
        driver = Driver.getDriver();
        actions = new Actions(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    }
