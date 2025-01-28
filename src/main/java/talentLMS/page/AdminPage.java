package talentLMS.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.helper.WebElementActions;
import talentLMS.page.groups.GroupsPage;

public class AdminPage extends BasePage {

    String adminHomePageURL = "https://seleniumexplorers.talentlms.com/dashboard";
    @FindBy(xpath = "(//a[contains(text(),'Users')])[1]")
    public WebElement adminUsersBtn;

    @FindBy(xpath = "(//a[contains(text(),'Add user')])[1]")
    public WebElement adminAddUserBtn;

    @FindBy(xpath = "//i[@title='Log out']")
    private WebElement logOutBtn;

    @FindBy(xpath = "//a[contains(text(),'Categories')]")
    private WebElement categoriesTxtBtn;

    @FindBy(xpath = "//i[@class='icon-menu tl-icon-stack-content']")
    private WebElement categoriesIconBtn;

    @FindBy(xpath = "//a[contains(text(),'Add category')]")
    private WebElement addCategoryBtn;
    @FindBy(xpath = "//a[contains(text(),'Reports')]")
    public WebElement reports;

    public AdminPage clickCategoriesTxtLink() {
       WebElementActions.click(categoriesTxtBtn);
        return this;
    }

    public AdminPage clickCategoriesIconBtn() {
        WebElementActions.click(categoriesIconBtn);
        return this;
    }

    public AdminPage clickLogoutBtn() {
       WebElementActions.click(logOutBtn);
        return this;
    }







    @FindBy(xpath = "//div[@class='tl-bold-link']//a[contains(text(),'Groups')]")
    public WebElement groupsBtn;

    public AdminPage clickGroupsBtn() {
        WebElementActions.click(groupsBtn);
        return this;

    }

    public GroupsPage clickAddGroup() {
        return null;
    }
}