package talentLMS.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import static org.testng.Assert.assertThrows;

public class CoursesTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
    }

    @Test
    public void addCourseTest(){
       coursePage.addCourse(randomCourse);
       Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.courseAddedText));
    }

    @Test
    public void addCourseButtonTest(){
        webElementActions.click(adminDashboardPage.addCourseButton);
        Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.addCourseHeadText));
    }

    @Test
    public void addCourseTest_WithNoMandatoryParameters(){
        webElementActions.click(adminDashboardPage.courses)
                .click(coursePage.addCourseButton)
                .sendKeys(addCoursePage.courseNameField,"")
                .sendKeys(addCoursePage.courseCategoryField,randomCourse.getCourseCategoryName())
                .sendKeys(addCoursePage.descriptionField, randomCourse.getDescription())
                .click(addCoursePage.saveAndSelectUsersButton);
        Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.courseNameIsRequiredText));
    }

    @Test
    public void goAddCourseSectionTest(){
        try {
            webElementActions.click(adminDashboardPage.addUserButton);
          Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.addCourseHeadText));
        } catch (NoSuchElementException e){
            Assert.fail("Expected NoSuchElementException was not thrown");
        }
    }

    @Test
    public void updateCourseTest(){
        coursePage.updateCourse("Binance");
        Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.courseSection));
        Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.usersSection));
        Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.groupsSection));
        Assert.assertTrue((webElementActions.isDisplayed(editCoursePage.courseUpdatedText)));
    }


    @Test
    public void updateCourseNegative() {
        try {
            coursePage.updateCourse("invalid_courseName");
            Assert.fail("Expected NoSuchElementException was not thrown");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("Unable to locate element"),
                    "Сообщение исключения не содержит ожидаемый текст");
        }
    }

    @Test
    public void updateUserWithNoParameters(){
        webElementActions.click(adminDashboardPage.courses);
        String courseName = "Binance";
        webElementActions.click(driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + courseName + "']")));
        addCoursePage.courseNameField.clear();
        addCoursePage.courseCategoryField.clear();
        webElementActions.sendKeys(addCoursePage.courseNameField, "")
                .sendKeys(addCoursePage.courseCategoryField, "")
                .click(addUserPage.userSubmitButton);
        Assert.assertTrue(webElementActions.isDisplayed(addCoursePage.courseNameIsRequiredText));
    }

    @Test
    public void goToReportsCoursesTest(){
        webElementActions.click(adminDashboardPage.courses);
        usersPage.goToReports();
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.overViewSection));
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.usersSection));
        Assert.assertTrue(webElementActions.isDisplayed(courseInfoReportPage.timeline));
    }

    @Test
    public void goToReportsCourses_NoReportsFound() {
        try {
            usersPage.goToReports();
            Assert.fail("Expected NoSuchElementException, but test continued.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("No elements found on the page."));
        }
    }

    @Test
    public void editTestCourses(){
        usersPage.goToEdit();
        Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.usersSection));
        Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.courseSection));
        Assert.assertTrue(webElementActions.isDisplayed(editCoursePage.groupsSection));
    }

    @Test
    public void editTestCourses_NoEditsFound() {
        assertThrows(NoSuchElementException.class, () -> usersPage.goToEdit());
    }

    @Test
    public void editTestCoursesClickableButtons() {
        usersPage.goToEdit();
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(editCoursePage.usersSection)) != null, "Элемент не кликабельный");
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(editCoursePage.courseSection)) != null, "Элемент не кликабельный");
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(editCoursePage.groupsSection)) != null, "Элемент не кликабельный");
    }

    @Test
    public void cloneCourseTest(){
        coursePage.cloneCourse();
        Assert.assertTrue(webElementActions.isDisplayed(coursePage.cloneSubmitButton));
    }

    @Test
    public void cloneTestCourses_NoClonesFound() {
        assertThrows(NoSuchElementException.class, () -> coursePage.cloneCourse());
    }

    @Test
    public void deleteCourseTest(){
        coursePage.deleteCourse();
        Assert.assertTrue(webElementActions.isDisplayed(coursePage.deleteCourseButton));
    }

    @Test
    public void deleteTestCourses_NoDeletesFound() {
        assertThrows(NoSuchElementException.class, () -> coursePage.deleteCourse());
    }




}