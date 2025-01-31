package talentLMS.page;


import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import talentLMS.driver.Driver;
import talentLMS.entity.Course;
import talentLMS.entity.User;
import talentLMS.helper.WebElementActions;
import talentLMS.page.categories.AddCategoryPage;
import talentLMS.page.categories.DeleteCategoryPage;
import talentLMS.page.courses.AddCoursePage;
import talentLMS.page.dashboard.DashboardPage;
import talentLMS.utils.randomEntityUtils.RandomCourseGenerator;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.time.Duration;


public  class BasePage {
    public WebDriver driver;
    public Actions actions;
    public DashboardPage dashboardPage = new DashboardPage();
    public AddCategoryPage addCategoryPage = new AddCategoryPage();
    public WebElementActions webElementActions = new WebElementActions();
    public AddCoursePage addCoursePage = new AddCoursePage();
    public RandomCourseGenerator randomCourseGenerator = new RandomCourseGenerator();
    public RandomUserGenerator randomUserGenerator = new RandomUserGenerator();
    public User randomUser = randomUserGenerator.randomUser();
    public Course randomCourse = randomCourseGenerator.randomCourse();
    public DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();




    public BasePage() {
        driver = Driver.getDriver();
        actions = new Actions(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    }
