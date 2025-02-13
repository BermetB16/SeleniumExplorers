package talentLMS.reports;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.reports.assignment_reports.AssignmentReportsPage;
import talentLMS.page.reports.branch_reports.BranchReportsPage;
import talentLMS.page.reports.coursesReports.CourseReportsPage;
import talentLMS.page.reports.custom_reports.CustomReportsPage;
import talentLMS.page.reports.group_reports.GroupReportsPage;
import talentLMS.page.reports.ilt_reports.ILTReportsPage;
import talentLMS.page.reports.scorm_reports.ScormReportPage;
import talentLMS.page.reports.survey_reports.SurveyReportsPage;
import talentLMS.page.reports.test_reports.TestReportsPage;

/**
 * author Nurdan
 */
public class ReportsTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
    }

    @Test
    @Step("Navigate to the Reports section and verify all report types are displayed")
    public void goToReportsTest() {
        webElementActions.click(adminDashboardPage.reports);
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.userReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.courseReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.iltReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.assignmentReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.testReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.branchReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.groupReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.surveyReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.infographics));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.overview));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.timeLine));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.trainingMatrix));
        Assert.assertTrue(webElementActions.scrollToElement(reportsPage.customReports).isDisplayed(reportsPage.customReports));
    }

    @Test
    @Step("Navigate to User Reports and verify the User Reports page is displayed")
    public void goToUserReports() {
        try {
            webElementActions.click(adminDashboardPage.reports)
                    .click(reportsPage.userReports);
            Assert.assertTrue(webElementActions.isDisplayed(userReportsPage.userReportsHead));
        } catch (NoSuchElementException e){
            Assert.fail("Element not found: " + e.getMessage());
        }
    }

    @Test
    @Step("Navigate to Course Reports and verify the Course Reports page is displayed")
    public void goToCourseReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.courseReports);
        Assert.assertTrue(webElementActions.isDisplayed(new CourseReportsPage().courseReportsHead));
    }

    @Test
    @Step("Navigate to Group Reports and verify the Group Reports page is displayed")
    public void goToGroupReports() {
        try {
            webElementActions.click(adminDashboardPage.reports)
                    .click(reportsPage.groupReports);
            Assert.assertTrue(webElementActions.isDisplayed(new GroupReportsPage().groupReportsHead),
                    "Group Reports page is not displayed.");
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + e.getMessage());
        }
    }


    @Test
    @Step("Navigate to SCORM Reports and verify the SCORM Reports page is displayed")
    public void goToScormReports() {
        try {
            webElementActions.click(adminDashboardPage.reports)
                    .click(reportsPage.scormReports);
            Assert.assertTrue(webElementActions.isDisplayed(new ScormReportPage().scormReportsHead));
        } catch (NoSuchElementException e){
            Assert.fail("Element not found: " + e.getMessage());
        }
    }

    @Test
    @Step("Navigate to ILT Reports and verify the ILT Reports page is displayed")
    public void goToILTReports() {
        try {
            webElementActions.click(adminDashboardPage.reports)
                    .click(reportsPage.iltReports);
            Assert.assertTrue(webElementActions.isDisplayed(new ILTReportsPage().iltReportsHead),
                    "Group Reports page is not displayed.");
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + e.getMessage());
        }
    }

    @Test(description = "Navigate to Assignment Reports and verify the Assignment Reports page is displayed")
    @Step("Navigate to Assignment Reports and verify the Assignment Reports page")
    public void goToAssignmentReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.assignmentReports);
        Assert.assertTrue(webElementActions.isDisplayed(new AssignmentReportsPage().assignmentReportsHead), "Assignment Reports page is not displayed.");
    }

    @Test(description = "Navigate to Test Reports and verify the Test Reports page is displayed")
    @Step("Navigate to Test Reports and verify the Test Reports page")
    public void goToTestReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.testReports);
        Assert.assertTrue(webElementActions.isDisplayed(new TestReportsPage().testReportsHead), "Test Reports page is not displayed.");
    }

    @Test(description = "Navigate to Branch Reports and verify the Branch Reports page is displayed")
    @Step("Navigate to Branch Reports and verify the Branch Reports page")
    public void goToBranchReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.branchReports);
        Assert.assertTrue(webElementActions.isDisplayed(new BranchReportsPage().branchReportsHead), "Branch Reports page is not displayed.");
    }

    @Test(description = "Navigate to Survey Reports and verify the Survey Reports page is displayed")
    @Step("Navigate to Survey Reports and verify the Survey Reports page")
    public void goToSurveyReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.surveyReports);
        Assert.assertTrue(webElementActions.isDisplayed(new SurveyReportsPage().surveyReportsHead), "Survey Reports page is not displayed.");
    }
    @Test(description = "Navigate to Custom Reports and verify the Custom Reports page is displayed")
    @Step("Navigate to Custom Reports and verify the Custom Reports page")
    public void goToCustomReports() {
        webElementActions.jsClick(reportsPage.customReports);
        Assert.assertTrue(webElementActions.isDisplayed( new CustomReportsPage().customReportsHead), "Custom Reports page is not displayed.");
    }



    @Test
    @Step("Test that an error is thrown when user reports are not found")
    public void testReportsUserNotFound() {
        try {
            userReportProgressPage = userReportsPage.goToUserProgressPage("NonExistingUser");
            Assert.fail("Expected RuntimeException, but test continued.");
        } catch (RuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("User with name 'NonExistingUser' not found"));
        }
    }

    @Test
    @Step("Test that Course Info Report is displayed correctly for an existing course")
    public void testReportsCourseFound() {
        String courseName = "Binance";
        WebElement courseElement = driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + courseName + "']"));
        Assert.assertNotNull(courseElement, "Course '" + courseName + "' not found in the reports table.");
        courseReportsPage.goToCourseInfoReport(courseName);
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.overViewSection),
                "Overview section is not displayed.");
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.usersSection),
                "Users section is not displayed.");
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.timeline),
                "Timeline section is not displayed.");
    }




    @Test
    @Step("Test that an error is thrown when Course Info Report is not found")
    public void testReportsCourseNotFound() {
        try {
            courseInfoReportPage = courseReportsPage.goToCourseInfoReport("NonExistingCourse");
            Assert.fail("Expected RuntimeException, but test continued.");
        } catch (RuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("Course with name 'NonExistingCourse' not found"));
        }
    }
}
