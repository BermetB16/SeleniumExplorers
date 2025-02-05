package talentLMS.page.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

public class AddCategoryPage extends BasePage {

    DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    @FindBy(xpath = "//input[@placeholder=\"e.g. Accounting\"]")
    public WebElement categoryName;

    @FindBy(xpath = "//a[@class=\"btn btn-primary\" and text()=\"Add category\"]")
    public WebElement addCategoryBtn;

    @FindBy(xpath = "//span[@class=\"select2-chosen\"]")
    public WebElement parentCategoryBtn;

    @FindBy(xpath = "//ul[@class=\"select2-results\"]")
    public WebElement iTCategory;

    @FindBy(xpath = "//div[contains(text(),'Finance')]")
    public WebElement financeCategory;

    @FindBy(xpath = "//input[@name=\"submit_category\"]")
    public WebElement categorySubmitBtn;

    @FindBy(xpath = "//a[@id=\"show-price\"]")
    public WebElement categoryPriceBtn;

    @FindBy(xpath = "//input[@id=\"category-price\"]")
    public WebElement categoryPrice;

    @FindBy(xpath = "//span[@class='help-inline' and contains(text(), 'is required')]")
    public WebElement errorNameRequired;

    @FindBy(xpath = "//div[@class=\"toast-message\"]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),\"Category updated successfully\")]")
    public WebElement categoryUpdatedMsg;

    public AddCategoryPage editCategory(String username) {
        driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]"));
        if (username != null) {
            driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]")).click();
        } else {
            throw new NoSuchElementException("Category with \'" + username + "\'- name is not found.");
        }

        this.categoryName.clear();
        webElementActions.sendKeys(this.categoryName, RandomUserGenerator.randomFirstName());
        PageFactory.initElements(driver, deleteCategoryPage);
        webElementActions.click(deleteCategoryPage.updateCategoryBtn);
        return new AddCategoryPage();
    }

    public AddCategoryPage addNewCategory(String categoryName, int categoryPrice) {
        webElementActions.click(addCategoryBtn);
        webElementActions.sendKeys(this.categoryName, categoryName);
        webElementActions.click(categoryPriceBtn);
        webElementActions.sendKeys(this.categoryPrice, String.valueOf(categoryPrice));
        webElementActions.click(parentCategoryBtn).click(iTCategory);
        webElementActions.click(categorySubmitBtn);
        return new AddCategoryPage();
    }

    public String getCategorySuccessMessage() {
        return webElementActions.getText(successMessage);
    }

    public String getCategorySuccessUpdateMessage(){
        return webElementActions.getText(categoryUpdatedMsg);
    }
}