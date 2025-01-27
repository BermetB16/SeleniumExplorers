package talentLMS.page.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.BasePage;

public class DeleteCategoryPage extends BasePage {

//    @FindBy(xpath = "//a[@id=\"tl-confirm-submit\"]")
//    public WebElement deleteCategoryBtn;

     @FindBy(xpath = "//a[@class=\"btn btn-danger\" and @href=\"javascript:void(0)\" ]")
     public WebElement deleteCategoryBtn;

     @FindBy(xpath = "//a[@id=\"tl-confirm-submit\"]")
    public WebElement finalDeleteCategoryBtn;
}
