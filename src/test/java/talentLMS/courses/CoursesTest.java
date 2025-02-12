package talentLMS.courses;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import static org.testng.Assert.assertThrows;

/**
  * author Nurdan
 */
public class CoursesTest extends BaseTest {

    @BeforeMethod
    @Step("authorization")
    public void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
    }

    @Test(description = "Add a new course and verify that the course was successfully added")
    @Step("Add a new course and verify the success message")
    public void addCourseTest(){
        coursePage.addCourse(randomCourse);
        Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.courseAddedText), "Course was not successfully added.");
    }

    @Test(description = "Click the 'Add Course' button and verify the presence of the course creation header")
    @Step("Click 'Add Course' button and verify page header")
    public void addCourseButtonTest(){
        webElementActions.click(adminDashboardPage.addCourseButton);
        Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.addCourseHeadText), "Add course header not displayed.");
    }

    @Test(description = "Attempt to add a course with missing mandatory parameters and verify the corresponding validation message")
    @Step("Attempt to add a course without mandatory parameters and verify the error")
    public void addCourseTest_WithNoMandatoryParameters(){
        webElementActions.click(adminDashboardPage.courses)
                .click(coursePage.addCourseButton)
                .sendKeys(addCoursePage.courseNameField,"")
                .sendKeys(addCoursePage.courseCategoryField,randomCourse.getCourseCategoryName())
                .sendKeys(addCoursePage.descriptionField, randomCourse.getDescription())
                .click(addCoursePage.saveAndSelectUsersButton);
        Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.courseNameIsRequiredText), "Validation message for missing course name not displayed.");
    }

    @Test(description = "Navigate to the 'Add Course' section and ensure the page loads correctly")
    @Step("Navigate to 'Add Course' section and check page load")
    public void goAddCourseSectionTest(){
        try {
            webElementActions.click(adminDashboardPage.addUserButton);
            Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.addCourseHeadText), "Add Course page not loaded correctly.");
        } catch (NoSuchElementException e){
            Assert.fail("Expected NoSuchElementException was not thrown.");
        }
    }

    @Test(description = "Update an existing course and verify that the updated sections are displayed correctly")
    @Step("Update a course and verify that the course details are updated")
    public void updateCourseTest() {
        try {
            coursePage.updateCourse("Binance");

            Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.courseSection),
                    "Course section not updated.");
            Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.usersSection),
                    "Users section not visible.");
            Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.groupsSection),
                    "Groups section not visible.");
            Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.courseUpdatedText),
                    "Course updated confirmation text not displayed.");
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + e.getMessage());
        }
    }


    @Test(description = "Attempt to update a course with an invalid name and expect a 'NoSuchElementException'")
    @Step("Try updating with an invalid course name and expect an exception")
    public void updateCourseNegative() {
        try {
            coursePage.updateCourse("invalid_courseName");
            Assert.fail("Expected NoSuchElementException was not thrown.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("Unable to locate element"), "Exception message does not match.");
        }
    }

    @Test(description = "Attempt to update a course with missing parameters and verify the validation error message")
    @Step("Update course with missing parameters and verify error message")
    public void updateUserWithNoParameters(){
        webElementActions.click(adminDashboardPage.courses);
        String courseName = "Binance";
        webElementActions.click(driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + courseName + "']")));
        addCoursePage.courseNameField.clear();
        addCoursePage.courseCategoryField.clear();
        webElementActions.sendKeys(addCoursePage.courseNameField, "")
                .sendKeys(addCoursePage.courseCategoryField, "")
                .click(addUserPage.userSubmitButton);
        Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.courseNameIsRequiredText), "Validation message for empty course name not displayed.");
    }

    @Test(description = "Navigate to the reports section and verify that the overview, users, and timeline sections are displayed correctly")
    @Step("Navigate to reports and verify the sections are displayed")
    public void goToReportsCoursesTest(){
        webElementActions.click(adminDashboardPage.courses);
        usersPage.goToReports();
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.overViewSection), "Overview section not visible.");
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.usersSection), "Users section not visible.");
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.timeline), "Timeline section not visible.");
    }

    @Test(description = "Attempt to access reports when no reports are available and expect 'NoSuchElementException'")
    @Step("Try accessing reports with no data and expect exception")
    public void goToReportsCourses_NoReportsFound() {
        try {
            usersPage.goToReports();
            Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.overViewSection), "Overview section not visible.");
            Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.usersSection), "Users section not visible.");
            Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.timeline), "Timeline section not visible.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("No elements found on the page."), "Exception message does not match.");
        }
    }

    @Test(description = "Navigate to the edit course section and verify that necessary elements are visible")
    @Step("Go to edit course section and verify elements")
    public void editTestCourses(){
        usersPage.goToEdit();
        Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.usersSection), "Users section not displayed.");
        Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.courseSection), "Course section not displayed.");
        Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.groupsSection), "Groups section not displayed.");
    }

    @Test(description = "Try accessing the edit course section with no valid course and expect 'NoSuchElementException'")
    @Step("Access edit section with no valid course and expect exception")
    public void editTestCourses_NoEditsFound() {
        assertThrows(NoSuchElementException.class, () -> usersPage.goToEdit());
    }

    @Test(description = "Verify that the edit course sections (users, course, groups) are clickable")
    @Step("Verify that the edit course sections are clickable")
    public void editTestCoursesClickableButtons() {
        usersPage.goToEdit();
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(editCoursePage.usersSection)) != null, "Users section not clickable.");
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(editCoursePage.courseSection)) != null, "Course section not clickable.");
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(editCoursePage.groupsSection)) != null, "Groups section not clickable.");
    }

    @Test(description = "Clone an existing course and verify that the clone submit button is visible")
    @Step("Clone an existing course and verify the clone button")
    public void cloneCourseTest(){
        coursePage.cloneCourse();
        Assert.assertTrue(webElementActions.isDisplayed(coursePage.cloneSubmitButton), "Clone submit button not visible.");
    }

    @Test(description = "Attempt to clone a course with no valid clones available and expect 'NoSuchElementException'")
    @Step("Try cloning with no valid clones and expect exception")
    public void cloneTestCourses_NoClonesFound() {
        assertThrows(NoSuchElementException.class, () -> coursePage.cloneCourse());
    }

    @Test(description = "Delete a course and verify that the delete button is displayed")
    @Step("Delete course and verify delete button visibility")
    public void deleteCourseTest(){
        coursePage.deleteCourse();
        Assert.assertTrue(webElementActions.isDisplayed(coursePage.deleteCourseButton), "Delete course button not visible.");
    }

    @Test(description = "Attempt to delete a course with no valid course to delete and expect 'NoSuchElementException'")
    @Step("Try deleting with no valid course to delete and expect exception")
    public void deleteTestCourses_NoDeletesFound() {
        assertThrows(NoSuchElementException.class, () -> coursePage.deleteCourse());
    }
}

