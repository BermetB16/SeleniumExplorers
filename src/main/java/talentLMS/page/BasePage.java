package talentLMS.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import talentLMS.driver.Driver;
import talentLMS.entity.User;
import talentLMS.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import talentLMS.page.dashboard.DashboardPage;
import talentLMS.page.users.AddCategoryPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.page.users.DeleteCategoryPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.time.Duration;


public  class BasePage {
    public WebDriver driver;
    public WebElementActions webElementActions;
    public RandomUserGenerator randomUserGenerator;
    public Actions actions;
    public User user;
    public AddCategoryPage addCategoryPage;
    public DeleteCategoryPage deleteCategoryPage;

    public BasePage() {
        // Инициализация driver
        driver = Driver.getDriver();

        // Инициализация зависимостей
        webElementActions = new WebElementActions();
        randomUserGenerator = new RandomUserGenerator();
        actions = new Actions(driver, Duration.ofSeconds(10));

        // Уберите инициализацию dashboardPage отсюда
        // dashboardPage = new DashboardPage();
        PageFactory.initElements(driver, this);
    }

    }
