package talentLMS.page.dashboard.legacy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class AdminDashboardPage extends BasePage {

    // Base elements

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

    // Links

    @FindBy(xpath = "//div[@id='tl-admin-users']/div/a[normalize-space()='Add user']")
    public WebElement usersAddUserLink;

    @FindBy(xpath = "//div[@class='hidden-phone']/a[normalize-space()='Add category']")
    public WebElement categoriesAddCategoryLink;

    @FindBy(xpath = "//div[@class='hidden-phone']/a[normalize-space()='Add branch']")
    public WebElement branchesAddBranchLink;

    @FindBy(xpath = "//div[@class='hidden-phone']/a[normalize-space()='Add user type']")
    public WebElement userTypesAddUserTypeLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Users']")
    public WebElement reportsUsersLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Courses']")
    public WebElement reportsCoursesLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Branches']")
    public WebElement reportsBranchesLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Groups']")
    public WebElement reportGroupsLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Scorm']")
    public WebElement reportScoresLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Tests']")
    public WebElement reportTestsLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Infographics']")
    public WebElement reportInfographicsLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Training matrix']")
    public WebElement reportTrainingMatrixLink;

    @FindBy(xpath = "//div[@id='tl-admin-dashboard-reports']//a[normalize-space()='Custom']")
    public WebElement reportCustomLink;

    @FindBy(xpath = "//div[@id='tl-admin-courses']//a[normalize-space()='Add course']")
    public WebElement coursesAddCourseLink;

    @FindBy(xpath = "//div[@id='tl-admin-courses']//a[normalize-space()='Course store']")
    public WebElement coursesCourseStoreLink;

    @FindBy(xpath = "//div[@class='tl-icon-label']//a[normalize-space()='Add group']")
    public WebElement groupsAddGroupLink;

    @FindBy(xpath = "//div[@id='tl-admin-events-engine']//a[normalize-space()='Add notification']")
    public WebElement eventEngineAddNotificationLink;

    @FindBy(xpath = "//div[@id='tl-admin-events-engine']//a[normalize-space()='Add automation']")
    public WebElement eventEngineAddAutomationLink;

    @FindBy(xpath = "//div[@class='tl-icon-label']//a[normalize-space()='Import']")
    public WebElement importLink;

    @FindBy(xpath = "//div[@class='tl-icon-label']//a[normalize-space()='Export']")
    public WebElement exportLink;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='Homepage']")
    public WebElement settingsHomepageLinks;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='Users']")
    public WebElement settingsUsersLink;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='Themes']")
    public WebElement settingsThemes;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='Certificates']")
    public WebElement settingsCertificatesLink;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='Gamification']")
    public WebElement settingsGamificationLink;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='E-commerce']")
    public WebElement settingsECommerceLink;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='Domain']")
    public WebElement settingsDomainLink;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='Subscription']")
    public WebElement settingsSubscriptionLink;

    @FindBy(xpath = "//div[@id='tl-admin-settings']//a[normalize-space()='New interface']")
    public WebElement settingsNewInterfaceLink;
}