package talentLMS.reports;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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

    @BeforeClass
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
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.scormReports));
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
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.userReports);
        Assert.assertTrue(webElementActions.isDisplayed(userReportsPage.userReportsHead));
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
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.groupReports);
        Assert.assertTrue(webElementActions.isDisplayed(new GroupReportsPage().groupReportsHead));
    }

    @Test
    @Step("Navigate to SCORM Reports and verify the SCORM Reports page is displayed")
    public void goToScormReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.scormReports);
        Assert.assertTrue(webElementActions.isDisplayed(new ScormReportPage().scormReportsHead));
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
        courseReportsPage.goToCourseInfoReport("Binance");
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.overViewSection));
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.usersSection));
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.timeline));
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
