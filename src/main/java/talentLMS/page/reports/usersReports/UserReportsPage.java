package talentLMS.page.reports.usersReports;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.page.reports.main_reports.ReportsPage;

public class UserReportsPage extends BasePage {

    ReportsPage reportsPage = new ReportsPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    @FindBy(xpath = "//div[@class='tl-title tl-ellipsis'][contains(text(),'User reports')]")
    public WebElement userReportsHead;

    public UserReportProgressPage goToUserProgressPage(String user) {
        try {
            WebElement userElement = driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + user + "']"));
            webElementActions.click(adminDashboardPage.reports)
                    .click(reportsPage.userReports)
                    .click(userElement);
            return new UserReportProgressPage();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("User with name '" + user + "' not found in the reports table.", e);
        }


    }
}
