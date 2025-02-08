package talentLMS.page.reports.coursesReports;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.page.reports.main_reports.ReportsPage;

public class CourseReportsPage extends BasePage {

    ReportsPage reportsPage = new ReportsPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis'][contains(text(),'Course reports')]")
    public WebElement courseReportsHead;

    public CourseInfoReportPage goToCourseInfoReport(String course) {
        try {
            WebElement courseElement = driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + course + "']"));
            webElementActions.click(adminDashboardPage.reports)
                    .click(reportsPage.courseReports)
                    .click(courseElement);
            return new CourseInfoReportPage();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Course with name '" + course + "' not found in the reports table.", e);
        }
    }





}
