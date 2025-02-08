package talentLMS.page.reports.assignment_reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class AssignmentReportsPage extends BasePage {

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis'][contains(text(),'Assignment reports')]")
    public WebElement assignmentReportsHead;
}
