package talentLMS.page.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.entity.Course;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.utils.randomEntityUtils.RandomCourseGenerator;

import java.util.List;
import java.util.Random;

public class CoursePage extends BasePage {

    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    RandomCourseGenerator randomCourseGenerator = new RandomCourseGenerator();
    AddCoursePage addCoursePage = new AddCoursePage();

    @FindBy(css = "div.btn-group > a.btn.btn-primary[href*='/course/create")
    public WebElement addCourseButton;

    @FindBy(css = "#tl-confirm-submit")
    public WebElement deleteButton;

    @FindBy(xpath = "//th[@class='tl-align-left sorting' and text()='Course']")
    public WebElement courseHeadText;

    @FindBy(xpath = "//a[@id='tl-clone-modal-confirm-submit' and @class='btn btn-primary' and text()='Clone']")
    public WebElement cloneSubmitButton;

    @FindBy(xpath = "a#tl-confirm-submit.btn.btn-danger")
    public WebElement deleteCourseButton;


    public AddCoursePage addCourse(Course course){
        webElementActions.click(adminDashboardPage.courses)
                .click(addCourseButton)
                .sendKeys(addCoursePage.courseNameField, course.getCourseName())
                .sendKeys(addCoursePage.courseCategoryField,course.getCourseCategoryName())
                .sendKeys(addCoursePage.descriptionField, course.getDescription())
                .click(addCoursePage.saveAndSelectUsersButton);
        return new AddCoursePage();
    }

    public EditCoursePage updateCourse(String courseName) {
        try {
            webElementActions.click(adminDashboardPage.courses);
            WebElement courseElement = driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + courseName + "']"));
            webElementActions.click(courseElement);
            if (!webElementActions.isDisplayed(addCoursePage.courseNameField)) {
                throw new RuntimeException("Edit Course page did not load properly.");
            }
            addCoursePage.courseNameField.clear();
            addCoursePage.courseCategoryField.clear();
            addCoursePage.descriptionField.clear();

            webElementActions.sendKeys(addCoursePage.courseNameField, randomCourseGenerator.randomCourseName())
                    .sendKeys(addCoursePage.courseCategoryField, randomCourseGenerator.randomCourseCategory())
                    .sendKeys(addCoursePage.descriptionField, randomCourseGenerator.randomDescription())
                    .click(addCoursePage.saveAndSelectUsersButton);

            return new EditCoursePage();

        } catch (NoSuchElementException e) {
            throw new RuntimeException("Course with name '" + courseName + "' not found in the courses table.", e);
        }
    }


    public CoursePage cloneCourse() {
        webElementActions.click(adminDashboardPage.courses);
        List<WebElement> cloneList = driver.findElements(By.xpath("//i[@title='Clone']"));
        if (cloneList.isEmpty()) {
            throw new NoSuchElementException("No elements found on the page.");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(cloneList.size());
        WebElement randomClone = cloneList.get(randomIndex);
        webElementActions.scrollToElement(randomClone).jsClick(randomClone).click(cloneSubmitButton);
        return this;
    }

    public CoursePage deleteCourse(){
        webElementActions.click(adminDashboardPage.courses);
        List<WebElement> deleteList = driver.findElements(By.xpath("//i[@title='Delete']"));
        if (deleteList.isEmpty()) {
            throw new NoSuchElementException("No elements found on the page.");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(deleteList.size());
        WebElement randomDelete = deleteList.get(randomIndex);
        webElementActions.scrollToElement(randomDelete).jsClick(randomDelete).click(deleteCourseButton);
        return this;
    }
}