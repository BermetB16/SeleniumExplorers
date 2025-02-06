package talentLMS.page.reports.scorm_reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class ScormReportPage extends BasePage {

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis'][contains(text(),'Scorm reports')]")
    public WebElement scormReportsHead;
}
