package talentLMS.page.groups;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import talentLMS.helper.WebElementActions;
import talentLMS.page.BasePage;

import java.time.Duration;

public class GroupsPage extends BasePage {


    @FindBy(xpath = "//a[contains(text(),'Add group')]")
    public WebElement addGroupBtn;

    @FindBy(xpath = "//input[@name='name'] ")
    public WebElement groupNameField;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement groupDescriptionField;

    @FindBy(xpath = "//input[@name='submit_group']")
    public WebElement saveGroupBtn;

    @FindBy(xpath = "//div[@class='tl-table-operations touchable']//i[@alt='Edit']")
    public WebElement editGroupBtn;
    @FindBy(xpath = "//div[@class='tl-table-operations touchable']//i[@alt='Delete']")
    public WebElement deleteGroupBtn;

    @FindBy(xpath = "//a[@id=\"tl-confirm-submit\"]")
    public WebElement confirmDeleteBtn;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successMessage;

    public GroupsPage clickAddGroup() {
       webElementActions.click(addGroupBtn);
        return this;
    }

    public GroupsPage enterGroupName(String groupName) {
        webElementActions.sendKeys(groupNameField, groupName);
        return this;
    }

    public GroupsPage enterGroupDescription(String description) {
        webElementActions.sendKeys(groupDescriptionField, description);
        return this;
    }


    public GroupsPage clickSaveGroup() {
        webElementActions.click(saveGroupBtn);
        return this;
    }

    public GroupsPage clickEditGroup() {
        webElementActions.click(editGroupBtn);
        return this;
    }

    public GroupsPage clickDeleteGroup() {
        webElementActions.click(deleteGroupBtn);
        return this;
    }

    public GroupsPage confirmDelete() {
       webElementActions.click(confirmDeleteBtn);
        return this;
    }

    public String getSuccessMessage() {
        return webElementActions.getText((successMessage));
    }



    }
