package talentLMS.page.reports.group_reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class GroupReportsPage extends BasePage {

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis'][contains(text(),'Group reports')]")
    public WebElement groupReportsHead;
}
