package talentLMS.page.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import talentLMS.entity.Course;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.BasePage;

import java.time.Duration;

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

    @FindBy(css = ".control-group.error .help-inline")
    public WebElement courseNameIsRequiredText;

    @FindBy(css = "div > a[href=\"https://seleniumexplorers.talentlms.com/course/index/gridPref:reset\"]")
    public WebElement coursesButton;

    @FindBy(css = "#tl-confirm-submit")
    public WebElement deleteButton;


    public AddCoursePage addCourse(Course course){
webElementActions.click(addCourseButton)
        .sendKeys(courseNameField, course.getCourseName())
        .sendKeys(courseCategoryField,course.getCourseCategoryName())
        .sendKeys(descriptionField, course.getDescription())
        .click(saveAndSelectUsersButton);
        return this;
    }

    public AddCoursePage addCourseNegativeCase(){
        webElementActions.click(addCourseButton)
                .sendKeys(courseNameField,"")
                .click(saveAndSelectUsersButton);
        String expectedRequiredText = "'Course name' is required";
        String realRequiredText = courseNameIsRequiredText.getText();
        Assert.assertTrue(expectedRequiredText.equals(realRequiredText));
        return this;
    }

    public AddCoursePage updateInfoOfCourse(String courseName){
        webElementActions.click(coursesButton);
        driver.findElement(By.cssSelector("span[title=\"" + courseName + "\"]")).click();
        courseNameField.clear();
        webElementActions.sendKeys(courseNameField,randomCourseGenerator.randomCourseName())
                .click(saveAndSelectUsersButton);
        return this;
    }

    public AddCoursePage deleteCourse(String courseName){
        webElementActions.click(coursesButton);
        WebElement deleteElement = driver.findElement(By.cssSelector("i[onclick*=\"" + courseName + "\"][alt=\"Delete\"]"));
        actions.moveToElement(deleteElement).perform();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(deleteElement));
        webElementActions.click(deleteElement).click(deleteButton);


        return this;
    }
}
