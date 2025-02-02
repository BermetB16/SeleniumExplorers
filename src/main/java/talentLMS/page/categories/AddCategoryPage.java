package talentLMS.page.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.AdminDashboardPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

public class AddCategoryPage extends BasePage {

    DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    @FindBy(xpath = "//input[@placeholder=\"e.g. Accounting\"]")
    public WebElement accountName;

    @FindBy(xpath = "//span[@class=\"select2-chosen\"]")
    public WebElement parentCategoryBtn;

    @FindBy(xpath = "//ul[@class=\"select2-results\"]")
    public WebElement iTCategory;

    @FindBy(xpath = "//div[contains(text(),'Finance')]")
    public WebElement financeCategory;

    @FindBy(xpath = "//input[@name=\"submit_category\"]")
    public WebElement categorySubmitBtn;

    public AddCategoryPage updateCategory(String username) {

        driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]"));
        if (username != null) {
            driver.findElement(By.xpath("//a[contains(text(),'" + username + "')]")).click();
        } else {
            throw new NoSuchElementException("Категория с именем " + username + " не найдена.");
        }

        this.accountName.clear();
        webElementActions.sendKeys(this.accountName, RandomUserGenerator.randomFirstName());
        PageFactory.initElements(driver, deleteCategoryPage);
        webElementActions.click(deleteCategoryPage.updateCategoryBtn);
        return new AddCategoryPage();

    }

    public AddCategoryPage addNewCategory(String accountName) {

        AddCategoryPage addCategoryPage = new AddCategoryPage();
        webElementActions.click(adminDashboardPage.addCategoryBtn);
        webElementActions.sendKeys(addCategoryPage.accountName, accountName);
        webElementActions.click(addCategoryPage.parentCategoryBtn).click(iTCategory);

        webElementActions.click(addCategoryPage.categorySubmitBtn);
        return addCategoryPage;
    }
}