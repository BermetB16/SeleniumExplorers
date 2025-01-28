package talentLMS.page.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
}
