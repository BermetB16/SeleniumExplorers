package talentLMS.page.reports.custom_reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class CustomReportsPage extends BasePage {

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis'][contains(text(),'Custom reports')]")
    public WebElement customReportsHead;
}
