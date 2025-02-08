package talentLMS.page.reports.ilt_reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class ILTReportsPage extends BasePage {

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis'][contains(text(),'ILT reports')]")
    public WebElement iltReportsHead;
}
