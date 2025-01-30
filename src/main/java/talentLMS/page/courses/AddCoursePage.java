package talentLMS.page.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import talentLMS.entity.Course;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.BasePage;

public class AddCoursePage extends BasePage {
    @FindBy(xpath = "//div[@id='tl-admin-dashboard']/div[@class='tl-icons-block']/div[@class='tl-icon-label']/div[@class='hidden-phone']/a[contains(text(),'Add course')]")
    public WebElement addCourseButton;

    @FindBy(xpath = "//div[@class='controls']/div[@class='input-append tl-countdown']/input[@name='name']")
    public WebElement courseNameField;

    @FindBy(xpath = "//*[@id=\"s2id_tl-course-category-select\"]/a")
    public WebElement courseCategoryField;

    @FindBy(xpath = "//div[@class='controls']/div[@class='input-append tl-countdown']/textarea[@name='description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//div[@class='btn-group dropup']/input")
    public WebElement saveAndSelectUsersButton;


    public AddCoursePage addCourse(Course course){
webElementActions.click(addCourseButton)
        .sendKeys(courseNameField, course.getCourseName())
        .sendKeys(courseCategoryField,course.getCourseCategoryName())
        .sendKeys(descriptionField, course.getDescription())
        .click(saveAndSelectUsersButton);
        return this;


    }
}
