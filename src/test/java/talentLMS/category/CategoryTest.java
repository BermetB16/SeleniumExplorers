package talentLMS.category;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;

public class CategoryTest extends BaseTest {

    @BeforeClass
    public void authorization(){
        driver.get("https://seleniumexplorers.talentlms.com/plus/login?redirect=%2Fdashboard");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
    }

    @Test
    public void addCategoryTest(){
//        String accountName = ConfigReader.getProperty("accountName");
//        addCategoryPage.addNewCategory(accountName);
    }

    @Test
    public void deleteCategoryTest(){
        String accountName = ConfigReader.getProperty("accountName");
        deleteCategoryPage.deleteCategory(accountName);
    }

    @Test
    public void updateCategoryNameTest(){
        String accountName = ConfigReader.getProperty("accountName");
        addCategoryPage.updateCategory(accountName);
    }
}
