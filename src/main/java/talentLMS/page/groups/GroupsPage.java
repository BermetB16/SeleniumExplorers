package talentLMS.page.groups;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

import java.util.List;

public class GroupsPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Add group')]")
    public WebElement addGroupBtn;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement groupNameField;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement groupDescriptionField;

    @FindBy(xpath = "//input[@name='submit_group']")
    public WebElement saveGroupBtn;

    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[2]")
    public WebElement triplePoint;

    @FindBy(xpath = "(//i[@alt='Edit'])[2]")
    public WebElement editGroupBtn;

    @FindBy(xpath = "(//i[@alt='Delete'])[2]")
    public WebElement deleteGroupBtn;

    @FindBy(xpath = "//*[@id='tl-confirm']//a[contains(text(), 'Cancel')]")
    public WebElement confirmDeleteBtn;
    @FindBy(xpath = "//a[@href=\"https://seleniumexplorers.talentlms.com/group/index\"]")
    public WebElement cancelGroupBtn;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[@class='btn btn-primary' and text()='Add group']")
    public WebElement addGroupHome;

    @FindBy(xpath = "//div/i[@class='icon-plus icon-grid tl-toggle-user']")
    public WebElement addUserToGroupBtn;
    @FindBy(xpath = "//span[@class='label label-registration']")
    public WebElement groupMemberText;
    @FindBy(xpath = "//a[contains(text(), 'Courses')]")
    public WebElement coursesTab;
    @FindBy(xpath = "//div/i[@class='icon-plus icon-grid tl-toggle-course']")
    public WebElement addCourseToGroup;
    @FindBy(xpath = "//span[@class='label label-registration']")
    public WebElement CourseGroupMemberText;
    @FindBy(xpath = "//a[@href=\"https://seleniumexplorers.talentlms.com/group/course/id:105\"]")
    public WebElement courseButton;


    @FindBy(xpath = "(//a[contains(text(), 'Groups')])[1]")
    public WebElement groupsBtnOnHomePage;
    @FindBy(xpath = "//a[@title='Groups']")
    public WebElement groupBtn;
    @FindBy(xpath = "//td[@class=' tl-align-left']")
    public List<WebElement> webTableOfGroups;
    @FindBy(xpath = "//a[@id='show-key']")
    public WebElement groupKeyBtn;
    @FindBy(xpath = "//a[@id='show-price']")
    public WebElement groupPriceBtn;
    @FindBy(xpath = "//input[@name='group_key']")
    public WebElement inputKeyOfGroup;
    @FindBy(xpath = "//input[@name='price']")
    public WebElement inputPriceOfGroup;
    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement textOfSuccsefullyAddedGroup;

    @FindBy(xpath = "//button[@class='back-button']")
    public WebElement backButton;


    public GroupsPage clickAddGroup() {
        webElementActions.click(addGroupBtn);
        return this;
    }

    public GroupsPage clickAddGroupHome(){
        webElementActions.click(addGroupHome);
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
    public GroupsPage clickGroupPriceBtn() {
        groupPriceBtn.click();
        return this;
    }
    public GroupsPage addUserToGroup(){
        addUserToGroupBtn.click();
        return this;
    }
    public GroupsPage groupMemberTextList(){
        groupMemberText.click();
        return this;
    }



    public GroupsPage clickSaveGroup() {
        webElementActions.click(saveGroupBtn);
        return this;
    }
    public GroupsPage clickCancelGroup(){
        webElementActions.click(cancelGroupBtn);
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
    public GroupsPage clickCourseButton() {
        webElementActions.click(courseButton);
        return this;
    }
    public GroupsPage enterGroupKeyButton(String groupKey) {
        webElementActions.click(groupKeyBtn);
        return this;
    }

    public String getSuccessMessage() {
        return webElementActions.getText(successMessage);
    }
    public GroupsPage moveToElement() {
        webElementActions.click(triplePoint);
        return this;
    }
    public GroupsPage clickBackButton() {
        backButton.click();
        return this;
    }

    public boolean isGroupPresent(String groupName) {
        try {

            WebElement groupElement = driver.findElement(By.xpath("//div[contains(text(), '" + groupName + "')]"));
            return groupElement != null && groupElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public WebElement getErrorMessage() {
        return driver.findElement(By.xpath("//div[contains(@class, ''Name' is required')]"));  // Замените этот XPath на ваш актуальный
    }

}
