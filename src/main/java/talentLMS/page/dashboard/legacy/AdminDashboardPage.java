package talentLMS.page.dashboard.legacy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class AdminDashboardPage extends BasePage {

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Users']")
    public WebElement users;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Categories']")
    public WebElement categories;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'User types']")
    public WebElement userTypes;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Reports']")
    public WebElement reports;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Courses']")
    public WebElement courses;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Groups']")
    public WebElement groups;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Branches']")
    public WebElement branches;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Events engine']")
    public WebElement events;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Import - Export']")
    public WebElement importExport;

    @FindBy(xpath = "//div[@class='tl-bold-link']/a[normalize-space()= 'Account & Settings']")
    public WebElement accountSettings;
}