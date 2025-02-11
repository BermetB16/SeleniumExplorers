package talentLMS.category;

import io.qameta.allure.Step;
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
        categoryName= "Baabar";
        categoryPrice= 10;
    }

    @Test
    @Step("Добавление категории")
    public void addCategoryTest(){
        addCategoryPage.addNewCategory(categoryName, categoryPrice);
        Assert.assertTrue(addCategoryPage.getCategorySuccessMessage().contains("Success! New category created."));
        System.out.println("Success!!!");
  }

    @Test
    @Step("Добавление категории с пустым параметром")
    public void addEmptyCategoryTest(){
        addCategoryPage.addNewCategory("", 0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOf(addCategoryPage.errorNameRequired));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "'Name' is required";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message text does not match");
    }


    @Test
    @Step("Удаление категории")
    public void deleteCategoryTest(){
        deleteCategoryPage.deleteCategory(categoryName);
        Assert.assertFalse(deleteCategoryPage.isCategoryPresent(categoryName), "Category should not be present after deletion");
    }

    @Test
    @Step("Редактироваание категории")
    public void editCategoryNameTest(){
        addCategoryPage.editCategory(categoryName);
        Assert.assertTrue(addCategoryPage.getCategorySuccessUpdatedMessage(), "Message not found: Category update failed");
    }

    @Test
    @Step("Отмена создания  категории")
    public void cancelNewCategoryTest(){
        addCategoryPage.cancelCategory(categoryName, categoryPrice);
        Assert.assertFalse(deleteCategoryPage.isCategoryPresent(categoryName), "Category should not be present after deletion");
        System.out.println("New category was SUCCESSFULLY CANCELED!!!");
    }

    @Test
    @Step("Создание категории с символами")
    public void CategoryWithCharactersTest() {
        String categoryNameWithCharacters = "!@£$%qwert";
        addCategoryPage.addNewCategory(categoryNameWithCharacters, categoryPrice);
        Assert.assertTrue(addCategoryPage.getCategorySuccessCreatedMessage(), "Message not found: Category update failed");
    }
}
