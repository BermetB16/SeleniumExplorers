package talentLMS.page.reports.usersReports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class UserReportProgressPage extends BasePage {

    @FindBy(xpath = "//div[text()='Progress overview']")
    public WebElement progressOverviewText;

    @FindBy(xpath = "//a[@id='trigger-gamification-modal']")
    public WebElement GamificationLink;

    @FindBy(xpath = "//h3[@class='font-weight-bold']")
    public WebElement leaderboardText;

    @FindBy(xpath = "//a[@id='certifications-tab']")
    public WebElement certificates;

    @FindBy(xpath = "//a[@id='badges-tab']")
    public WebElement badges;

    @FindBy(xpath = "//a[@id='timeline-tab']")
    public WebElement timeline;

    @FindBy(xpath = "//a[@id='overview-tab']")
    public WebElement overView;

    @FindBy(xpath = "//a[@id='courses-tab']")
    public WebElement courses;

    @FindBy(xpath = "//a[@class='btn active' and text()='Profile']")
    public WebElement profileButton;

    @FindBy(xpath ="//a[@class='btn active' and text()='Progress']")
    public WebElement progressButton;

    @FindBy(xpath = "//a[@class='btn active' and text()='Infographic']")
    public WebElement infographicButton;

    @FindBy(xpath = "//span[text()='Activity badges']")
    public WebElement activityBadgesText;

    @FindBy(xpath = "//th[@class='tl-align-left sorting_disabled' and text()='Events']")
    public WebElement eventsText;
}
