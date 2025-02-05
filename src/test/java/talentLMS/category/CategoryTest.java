package talentLMS.category;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.utils.enums.Page;

import java.time.Duration;

public class CategoryTest extends BaseTest {
    private String categoryName;
    private int categoryPrice;

    @BeforeClass
    public void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
        pageNavigator.switchToPage(Page.CATEGORIES);
        categoryName= "Samon";
        categoryPrice= 10;
    }

    @Test
    public void addCategoryTest(){
        addCategoryPage.addNewCategory(categoryName, categoryPrice);
        Assert.assertTrue(addCategoryPage.getCategorySuccessMessage().contains("Success! New category created."));
        System.out.println("Success!!!");
    }

    @Test
    public void addEmptyCategoryTest(){
        addCategoryPage.addNewCategory("", 0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOf(addCategoryPage.errorNameRequired));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "'Name' is required";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message text does not match");
    }

    @Test
    public void deleteCategoryTest(){
        deleteCategoryPage.deleteCategory(categoryName);
        Assert.assertFalse(deleteCategoryPage.isCategoryPresent(categoryName), "Category should not be present after deletion");
    }

    @Test
    public void editCategoryNameTest(){
        addCategoryPage.editCategory(categoryName);
        Assert.assertTrue(addCategoryPage.getCategorySuccessUpdateMessage().contains("Category updated successfully"));
    }
}
