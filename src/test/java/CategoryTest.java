import org.testng.annotations.Test;
import talentLMS.fileUtils.ConfigReader;

public class CategoryTest extends BaseTest{

    @Test
    public void addCategoryTest(){
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface();
        String accountName = ConfigReader.getProperty("accountName");

        // Вызываем метод для добавления новой категории с передачей accountName
        dashboardPage.addNewCategory(accountName);
    }

    @Test
    public void deleteCategoryTest(){
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"))
                .goToLegacyInterface();
        String accountName = ConfigReader.getProperty("accountName");
        dashboardPage.deleteCategory(accountName);
    }
}
