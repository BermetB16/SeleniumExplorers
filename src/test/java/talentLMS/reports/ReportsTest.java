package talentLMS.reports;

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
import talentLMS.page.reports.usersReports.UserReportsPage;

public class ReportsTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
    }

    @Test
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
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.branchReports));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.infographics));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.overview));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.timeLine));
        Assert.assertTrue(webElementActions.isDisplayed(reportsPage.trainingMatrix));
        Assert.assertTrue(webElementActions.scrollToElement(reportsPage.customReports).isDisplayed(reportsPage.customReports));
    }

    @Test
    public void goToUserReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.userReports);
        Assert.assertTrue(webElementActions.isDisplayed(userReportsPage.userReportsHead));
    }

    @Test
    public void goToCourseReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.courseReports);
        Assert.assertTrue(webElementActions.isDisplayed(new CourseReportsPage().courseReportsHead));
    }

    @Test
    public void goToGroupReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.courseReports);
        Assert.assertTrue(webElementActions.isDisplayed(new GroupReportsPage().groupReportsHead));
    }

    @Test
    public void goToScormReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.scormReports);
        Assert.assertTrue(webElementActions.isDisplayed(new ScormReportPage().scormReportsHead));
    }

    @Test
    public void goToSurveyReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.surveyReports);
        Assert.assertTrue(webElementActions.isDisplayed(new SurveyReportsPage().surveyReportsHead));
    }

    @Test
    public void goToTestReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.testReports);
        Assert.assertTrue(webElementActions.isDisplayed(new TestReportsPage().testReportsHead));
    }

    @Test
    public void goToILTReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.iltReports);
        Assert.assertTrue(webElementActions.isDisplayed(new ILTReportsPage().iltReportsHead));
    }

    @Test
    public void goToBranchReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.branchReports);
        Assert.assertTrue(webElementActions.isDisplayed(new BranchReportsPage().branchReportsHead));
    }

    @Test
    public void goToAssignmentReports() {
        webElementActions.click(adminDashboardPage.reports)
                .click(reportsPage.assignmentReports);
        Assert.assertTrue(webElementActions.isDisplayed(new AssignmentReportsPage().assignmentReportsHead));
    }

    @Test
    public void goToCustomReports() {
        webElementActions.click(adminDashboardPage.reports)
                .jsClick(reportsPage.customReports);
        Assert.assertTrue(webElementActions.isDisplayed(new CustomReportsPage().customReportsHead));
    }

    @Test
    public void testReportsUserFound() {
        userReportsPage.goToUserProgressPage("S.Explorers");
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.overView));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.badges));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.timeline));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.certificates));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.courses));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.infographicButton));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.profileButton));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.progressButton));
    }

    @Test
    public void testReportsUserFound2() {
        userReportsPage.goToUserProgressPage("S.Explorers");
        Assert.assertTrue(webElementActions.isEnabled(userReportProgressPage.overView));
        Assert.assertTrue(webElementActions.isEnabled(userReportProgressPage.badges));
        Assert.assertTrue(webElementActions.isEnabled(userReportProgressPage.timeline));
        Assert.assertTrue(webElementActions.isEnabled(userReportProgressPage.certificates));
        Assert.assertTrue(webElementActions.isEnabled(userReportProgressPage.courses));
        Assert.assertTrue(webElementActions.isEnabled(userReportProgressPage.infographicButton));
        Assert.assertTrue(webElementActions.isEnabled(userReportProgressPage.profileButton));
        Assert.assertTrue(webElementActions.isEnabled(userReportProgressPage.progressButton));
    }

    @Test
    public void testReportsUserNotFound() {
        try {
            userReportProgressPage = userReportsPage.goToUserProgressPage("NonExistingUser");
            Assert.fail("Expected RuntimeException, but test continued.");
        } catch (RuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("User with name 'NonExistingUser' not found"));
        }
    }

    @Test
    public void testReportsCourseFound() {
        courseReportsPage.goToCourseInfoReport("Binance");
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.overViewSection));
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.usersSection));
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.timeline));
    }

    @Test
    public void testReportsCourseFound2() {
        courseReportsPage.goToCourseInfoReport("Binance");
        Assert.assertTrue(webElementActions.isEnabled(courseInfoReportPage.overViewSection));
        Assert.assertTrue(webElementActions.isEnabled(courseInfoReportPage.usersSection));
        Assert.assertTrue(webElementActions.isEnabled(courseInfoReportPage.timeline));
    }

    @Test
    public void testReportsCourseNotFound() {
        try {
            courseInfoReportPage = courseReportsPage.goToCourseInfoReport("NonExistingCourse");
            Assert.fail("Expected RuntimeException, but test continued.");
        } catch (RuntimeException e) {
            Assert.assertTrue(e.getMessage().contains("Course with name 'NonExistingCourse' not found"));
        }
    }
}
