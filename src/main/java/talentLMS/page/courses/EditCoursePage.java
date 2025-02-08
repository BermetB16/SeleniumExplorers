package talentLMS.page.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCoursePage {
    @FindBy(xpath = "//a[text()='Users']")
    public WebElement usersSection;

    @FindBy(xpath = "//a[text()='Course']")
    public WebElement courseSection;

    @FindBy(xpath = "//a[text()='Groups']")
    public WebElement groupsSection;

    @FindBy(xpath = "//div[@class='toast-message' and text()='Success! Course updated.']")
    public WebElement courseUpdatedText;
}
