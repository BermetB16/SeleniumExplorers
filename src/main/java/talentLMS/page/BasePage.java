package talentLMS.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import talentLMS.driver.Driver;
import talentLMS.entity.Course;
import talentLMS.entity.User;
import talentLMS.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import talentLMS.page.dashboard.DashboardPage;
<<<<<<< HEAD
import talentLMS.page.login.LoginPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.utils.randomEntityUtils.RandomCourseGenerator;
=======
import talentLMS.page.users.AddCategoryPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.page.users.DeleteCategoryPage;
>>>>>>> 6e268cc0fec98e189791bb587c0d65575f8a87c8
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.time.Duration;


public  class BasePage {
    public WebDriver driver;
    public WebElementActions webElementActions;
    public RandomUserGenerator randomUserGenerator;
    public RandomCourseGenerator randomCourseGenerator;
    public Actions actions;
    public User user;
<<<<<<< HEAD
    public LoginPage loginPage ;
    public Course course;
=======
    public AddCategoryPage addCategoryPage;
>>>>>>> 6e268cc0fec98e189791bb587c0d65575f8a87c8

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
