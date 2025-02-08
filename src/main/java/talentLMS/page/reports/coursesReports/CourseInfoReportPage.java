package talentLMS.page.reports.coursesReports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class CourseInfoReportPage extends BasePage {

    @FindBy(xpath = "//a[@id='overview-tab' and @class='tl-course-info-menu-item' and @data-toggle='tab' and text()='Overview']")
    public WebElement overViewSection;

    @FindBy(xpath = "a#users-tab.tl-course-info-menu-item[data-toggle='tab']")
    public WebElement usersSection;

    @FindBy(xpath = "//a[@id='timeline-tab']")
    public WebElement timeline;
}
