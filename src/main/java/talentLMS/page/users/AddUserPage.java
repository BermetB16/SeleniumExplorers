package talentLMS.page.users;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import talentLMS.entity.User;
import talentLMS.page.base.BasePage;
import talentLMS.page.dashboard.legacy.AdminDashboardPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.util.List;
import java.util.Random;

public class AddUserPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"tl-title tl-ellipsis\" and normalize-space(text())='Add user']")
    public WebElement addUserHeadText;

    @FindBy(xpath = "//div[@class='toast-message' and text()='User details updated successfully']")
    public WebElement successfulUserUpdateText;

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement firstName;
    @FindBy(xpath = "//span[@class='help-inline' and text()=\"'First name' is required\"]")
    public WebElement firstNameIsRequiredText;

    @FindBy(xpath = "//input[@name = 'surname']")
    public WebElement lastName;
    @FindBy(xpath = "//span[@class='help-inline' and text()=\"'Last name' is required\"]")
    public WebElement lastNameIsRequiredText;

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement email;
    @FindBy(xpath = "//span[@class='help-inline' and text()=\\\"'Email address' is required\\\"]")
    public WebElement emailAddressIsRequiredText;
    @FindBy(xpath = "//span[@class='help-inline' and text()=\\\"This is not a valid 'Email address'\\\"]")
    public WebElement notValidEmailAddressText;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement username;
    @FindBy(xpath = "//span[@class='help-inline' and text()=\\\"'Last name' is required\\\"]")
    public WebElement usernameIsRequiredText;

    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement password;

    @FindBy(xpath = "//span[text()='Learner-Type' or text()='SuperAdmin' or text()='Trainer-Type' or text()='Admin-Type']/ancestor::a[contains(@class, 'select2-choice')]")
    public WebElement userTypeField;

    @FindBy(name = "acl_user_type_id")
    public WebElement userTypeOptions;

    @FindBy(xpath = "//span[contains(text(), \"GMT\")]/ancestor::a[contains(@class, 'select2-choice')]")
    public WebElement timeZoneField;

    @FindBy(xpath = "//select[@name='timezone']")
    public WebElement timeZoneOptions;

    @FindBy(xpath = "//label[@class='control-label' and text()='Language']/following::a[@class='select2-choice']")
    public WebElement languageField;

    @FindBy(xpath = "//select[@name='language' and @class='tl-select2 select2-offscreen']")
    public WebElement languageOptions;

    @FindBy(xpath = "//input[@name ='submit_personal_details']")
    public WebElement userSubmitButton;

    @FindBy(css = "div.toast-message")
    public WebElement usersLimitText;

}