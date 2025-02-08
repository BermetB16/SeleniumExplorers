package talentLMS.page.dashboard.legacy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class AdminDashboardPage extends BasePage {

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Users']")
    public WebElement users;
    @FindBy(xpath = "//a[normalize-space(text())='Add user']")
    public WebElement addUserButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Categories']")
    public WebElement categories;
    @FindBy(xpath = "//a[normalize-space(text())='Add category']")
    public WebElement addCategoryButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'User types']")
    public WebElement userTypes;
    @FindBy(xpath = "//a[normalize-space(text())='Add user type']")
    public WebElement addUserTypeButton;


    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Courses']")
    public WebElement courses;
    @FindBy(xpath = "//a[normalize-space(text())='Add course']")
    public WebElement addCourseButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Groups']")
    public WebElement groups;
    @FindBy(xpath = "//a[normalize-space(text())='Add group']")
    public WebElement addGroupButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Branches']")
    public WebElement branches;
    @FindBy(xpath = "//a[normalize-space(text())='Add branch']")
    public WebElement addBranchButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Events engine']")
    public WebElement events;
    @FindBy(xpath = "//a[normalize-space(text())='Add notification']")
    public WebElement addNotificationButton;
    @FindBy(xpath = "//a[normalize-space(text())='Add automation']")
    public WebElement addAutomationButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Import - Export']")
    public WebElement importExport;
    @FindBy(xpath = "//a[normalize-space(text())='Import']")
    public WebElement importButton;
    @FindBy(xpath = "//a[normalize-space(text())='Export']")
    public WebElement exportButton;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Account & Settings']")
    public WebElement accountSettings;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Reports']")
    public WebElement reports;
}