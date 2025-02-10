package talentLMS.page.reports.main_reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class ReportsPage extends BasePage {

    @FindBy(xpath = "//a[text()='User reports']")
    public WebElement userReports;

    @FindBy(xpath = "//a[text()='Course reports']")
    public WebElement courseReports;

    @FindBy(xpath = "//a[text()='Branch reports']")
    public WebElement branchReports;

    @FindBy(xpath = "//a[text()='Group reports']")
    public WebElement groupReports;

    @FindBy(xpath = "//a[text()='Scorm reports']")
    public WebElement scormReports;

    @FindBy(xpath = "//a[text()='Test reports']")
    public WebElement testReports;

    @FindBy(xpath = "//a[text()='Survey reports']")
    public WebElement surveyReports;

    @FindBy(xpath = "//a[text()='Assignment reports']")
    public WebElement assignmentReports;

    @FindBy(xpath = "//a[text()='ILT reports']")
    public WebElement iltReports;

    @FindBy(xpath = "//a[text()='Custom reports']")
    public WebElement customReports;

    @FindBy(xpath = "//a[text()='Overview']")
    public WebElement overview;

    @FindBy(xpath = "//a[text()='Infographics']")
    public WebElement infographics;

    @FindBy(xpath = "//a[text()='Timeline']")
    public WebElement timeLine;

    @FindBy(xpath = "//a[text()='Training matrix']")
    public WebElement trainingMatrix;
}
