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
import talentLMS.page.users.AddUserPage;
import talentLMS.utils.randomEntityUtils.RandomCourseGenerator;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.time.Duration;


public  class BasePage {
    public WebDriver driver;
    public WebElementActions webElementActions;
    public RandomUserGenerator randomUserGenerator;
    public RandomCourseGenerator randomCourseGenerator;
    public Actions actions;
    public User user;
    public LoginPage loginPage ;
    public Course course;

    public BasePage() {
        driver = Driver.getDriver();
        webElementActions = new WebElementActions();
        randomUserGenerator = new RandomUserGenerator();
        randomCourseGenerator = new RandomCourseGenerator();
        actions = new Actions(driver,Duration.ofSeconds(10));
        randomUserGenerator.randomUser();
        randomUserGenerator.randomUser();
        loginPage = new LoginPage();
        course = randomCourseGenerator.randomCourse();
        PageFactory.initElements(driver, this);
    }

    }
