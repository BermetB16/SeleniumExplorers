package talentLMS.page.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCoursePage {

    @FindBy(xpath = "//div[@class=\"tl-title tl-ellipsis\" and normalize-space(text())='Add course']")
    public WebElement addCourseHeadText;

    @FindBy(xpath = "//div[@class='toast-message' and contains(text(), 'Success! New course created. Now, add users')]")
    public WebElement courseAddedText;

    @FindBy(xpath = "//div[@class='controls']/div[@class='input-append tl-countdown']/input[@name='name']")
    public WebElement courseNameField;
    @FindBy(css = ".control-group.error .help-inline")
    public WebElement courseNameIsRequiredText;

    @FindBy(xpath = "//*[@id=\"s2id_tl-course-category-select\"]/a")
    public WebElement courseCategoryField;

    @FindBy(xpath = "//div[@class='controls']/div[@class='input-append tl-countdown']/textarea[@name='description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//div[@class='btn-group dropup']/input")
    public WebElement saveAndSelectUsersButton;
}
