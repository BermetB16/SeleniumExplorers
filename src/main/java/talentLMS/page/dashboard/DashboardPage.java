package talentLMS.page.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import talentLMS.entity.User;
import talentLMS.helper.WebElementActions;
import talentLMS.page.BasePage;
import talentLMS.page.users.AddCategoryPage;
import talentLMS.page.users.AddUserPage;
import talentLMS.page.users.DeleteCategoryPage;

import java.time.Duration;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//div[@id='tl-admin-users']//div[@class='hidden-phone']/a[contains(text(),'Add user')]")
    public WebElement addUserBtn;

    @FindBy(xpath = "//div[@data-testid='profile-menu-button']")
    public WebElement profileMenuBtn;

    @FindBy(xpath = "//a[@data-testid='legacy-menu-item']")
    public WebElement goToLegacyInterfaceBtn;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[@href = \"https://seleniumexplorers.talentlms.com/user/index/gridPref:reset\"]")
    public WebElement usersButton;



//    @FindBy(xpath = "//tr[@role='row']/td/a/span[text()='B. Welch']")
//    public WebElement userInfo;


    @FindBy(xpath = "//input[@type='text' and @name='name']")
    public WebElement firstNameField;


//Categories
    @FindBy(xpath = "//a[@href=\"https://seleniumexplorers.talentlms.com/category/create\"]")
    public WebElement addCategoryBtn;

    @FindBy(xpath = "//a[contains(text(),\"Categories\")]")
    public WebElement categoriesBtn;


    public DashboardPage goToLegacyInterface() {
        actions.moveToElement(profileMenuBtn).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(goToLegacyInterfaceBtn));
        webElementActions.click(goToLegacyInterfaceBtn);
        return this;
    }

    public AddUserPage addNewUser(User user) {
        webElementActions.click(addUserBtn);
        webElementActions.sendKeys(new AddUserPage().firstName, user.getFirstName());
        WebElementActions.sendKeys(new AddUserPage().lastName, user.getLastName());
             WebElementActions   .sendKeys(new AddUserPage().email, user.getEmail());
               WebElementActions.sendKeys(new AddUserPage().username, user.getUserName());
           WebElementActions     .sendKeys(new AddUserPage().password, AddUserPage.generateStrongPassword(30));
             WebElementActions   .click(new AddUserPage().addUserButton);
        return new AddUserPage();
    }

    public AddUserPage updateInfoOfUsers(String username){
        webElementActions.click(usersButton);
        driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']")).click();
        firstNameField.clear();
        webElementActions.sendKeys(firstNameField,randomUserGenerator.randomFirstName());
        webElementActions.click(new AddUserPage().addUserButton);
        return new AddUserPage();

    }

    public DeleteCategoryPage deleteCategory(String categoryName){
        DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();
        webElementActions.click(categoriesBtn);
        driver.findElement(By.xpath("//a[contains(text(),'"+ categoryName + "')]"));
        if (categoryName != null) {
            driver.findElement(By.xpath("//a[contains(text(),'"+ categoryName + "')]")).click();
        } else {
            throw new NoSuchElementException("Категория с именем " + categoryName + " не найдена.");
        }

        PageFactory.initElements(driver, deleteCategoryPage);

        webElementActions.click(deleteCategoryPage.deleteCategoryBtn);
        webElementActions.click(deleteCategoryPage.finalDeleteCategoryBtn);

        return deleteCategoryPage;
    }

    public AddCategoryPage updateCategory(String username){
        DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage();
        webElementActions.click(categoriesBtn);
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
        webElementActions.click(addCategoryBtn);

        // Заполняем поле Account Name (передаем текст в поле accountName)
        webElementActions.sendKeys(addCategoryPage.accountName, accountName); // Правильный способ

        // Нажимаем на кнопку выбора родительской категории и выбираем нужную категорию
        webElementActions.click(addCategoryPage.parentCategoryBtn).click(addCategoryPage.iTCategory);

        // Отправляем форму
        webElementActions.click(addCategoryPage.categorySubmitBtn);

        // Возвращаем объект страницы AddCategoryPage
        return addCategoryPage;
    }


}

