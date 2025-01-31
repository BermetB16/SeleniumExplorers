package talentLMS.page.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import talentLMS.page.BasePage;

public class AddCategoryPage extends BasePage {
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

    public AddCategoryPage updateCategory(String username){
        dashboardPage.switchToPage("Categories");

        driver.findElement(By.xpath("//a[contains(text(),'"+ username + "')]"));
        if (username != null) {
            driver.findElement(By.xpath("//a[contains(text(),'"+ username + "')]")).click();
        } else {
            throw new NoSuchElementException("Категория с именем " + username + " не найдена.");
        }
        addCategoryPage = new AddCategoryPage();
        addCategoryPage.accountName.clear();
        webElementActions.sendKeys(addCategoryPage.accountName,randomUserGenerator.randomFirstName());
        PageFactory.initElements(driver, deleteCategoryPage);
        webElementActions.click(deleteCategoryPage.updateCategoryBtn);
        return new AddCategoryPage();

    }









    public AddCategoryPage addNewCategory(String accountName) {

        AddCategoryPage addCategoryPage = new AddCategoryPage();

        // Нажимаем на кнопку добавления категории
        webElementActions.click(dashboardPage.addCategoryBtn);

        // Заполняем поле Account Name (передаем текст в поле accountName)
        webElementActions.sendKeys(addCategoryPage.accountName, accountName); // Правильный способ

        // Нажимаем на кнопку выбора родительской категории и выбираем нужную категорию
        webElementActions.click(addCategoryPage.parentCategoryBtn).click(iTCategory);

        // Отправляем форму
        webElementActions.click(addCategoryPage.categorySubmitBtn);

        // Возвращаем объект страницы AddCategoryPage
        return addCategoryPage;
    }

}
