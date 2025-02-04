package talentLMS.page.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.entity.Course;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.utils.enums.Page;

public class AddCoursePage extends BasePage {

    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    @FindBy(css = "div.btn-group > a.btn.btn-primary[href*='/course/create")
    public WebElement addCourseButton;

    @FindBy(xpath = "//div[@class='controls']/div[@class='input-append tl-countdown']/input[@name='name']")
    public WebElement courseNameField;

    @FindBy(xpath = "//*[@id=\"s2id_tl-course-category-select\"]/a")
    public WebElement courseCategoryField;

    @FindBy(xpath = "//div[@class='controls']/div[@class='input-append tl-countdown']/textarea[@name='description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//div[@class='btn-group dropup']/input")
    public WebElement saveAndSelectUsersButton;

    @FindBy(css = ".control-group.error .help-inline")
    public WebElement courseNameIsRequiredText;

    @FindBy(css = "#tl-confirm-submit")
    public WebElement deleteButton;


    public AddCoursePage addCourse(Course course){
        webElementActions.click(adminDashboardPage.courses)
                .click(addCourseButton)
                .sendKeys(courseNameField, course.getCourseName())
                .sendKeys(courseCategoryField,course.getCourseCategoryName())
                .sendKeys(descriptionField, course.getDescription())
                .click(saveAndSelectUsersButton);
        return this;
    }
}