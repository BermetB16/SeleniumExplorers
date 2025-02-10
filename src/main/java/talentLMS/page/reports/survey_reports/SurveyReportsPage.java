package talentLMS.page.reports.survey_reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class SurveyReportsPage extends BasePage {

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis'][contains(text(),'Survey reports')]")
    public WebElement surveyReportsHead;
}
