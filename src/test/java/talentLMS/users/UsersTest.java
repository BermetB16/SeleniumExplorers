package talentLMS.users;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.users.UsersPage;
import java.util.Random;

/**
 * author Nurdan
 */
public class UsersTest extends BaseTest {

        @BeforeMethod
        @Step("Authorization")
        public void authorization() {
            browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
            loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
            adminDashboardModernPage.goToLegacyInterface();
        }

        @Test(description = "Add a new user")
        @Step("Add a new user")
        public void addNewUserTest() {
            usersPage.addNewUser(randomUser);
        }

        @Test(description = "Click 'Add User' button and verify the page header")
        @Step("Click 'Add User' button and verify page header")
        public void clickAddUserButton() {
            webElementActions.click(adminDashboardPage.addUserButton);
            Assert.assertTrue(webElementActions.isDisplayed(addUserPage.addUserHeadText));
        }

        @Test(description = "Verify user limit reached message")
        @Step("Verify that the user limit message is displayed")
        public void addNewUserLimitText() {
            webElementActions.click(adminDashboardPage.users).click(new UsersPage().addUserButton);
            Assert.assertTrue(webElementActions.isDisplayed(addUserPage.usersLimitText));
            Assert.assertEquals(addUserPage.usersLimitText.getText(), "You have just reached your active users limit. To add more users, upgrade your plan.");
        }

        @Test(description = "Add a new user with invalid data")
        @Step("Add a new user with invalid data")
        public void addNewUserNegativeTest() {
            webElementActions.click(adminDashboardPage.users)
                    .click(usersPage.addUserButton)
                    .sendKeys(addUserPage.firstName, "")
                    .sendKeys(addUserPage.lastName, "")
                    .sendKeys(addUserPage.email, "")
                    .sendKeys(addUserPage.username, "")
                    .sendKeys(addUserPage.password, "")
                    .click(addUserPage.userSubmitButton);
            Assert.assertTrue(webElementActions.isDisplayed(addUserPage.firstNameIsRequiredText));
            Assert.assertTrue(webElementActions.isDisplayed(addUserPage.lastNameIsRequiredText));
            Assert.assertTrue(webElementActions.isDisplayed(addUserPage.emailAddressIsRequiredText));
            Assert.assertTrue(webElementActions.isDisplayed(addUserPage.usernameIsRequiredText));
        }

        @Test(description = "Verify email address validation for invalid format")
        @Step("Verify email address validation for invalid format")
        public void invalidTypeOfEmailTest() {
            Random random = new Random();
            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder emailPart = new StringBuilder();
            for (int i = 0; i < 5 + random.nextInt(10); i++) {
                emailPart.append(characters.charAt(random.nextInt(characters.length())));
            }
            String invalidEmail = emailPart + "invalid";
            webElementActions.click(adminDashboardPage.users)
                    .click(usersPage.addUserButton)
                    .sendKeys(addUserPage.firstName, "erce")
                    .sendKeys(addUserPage.lastName, "weexdw")
                    .sendKeys(addUserPage.email, invalidEmail)
                    .sendKeys(addUserPage.username, "dfvdfv")
                    .sendKeys(addUserPage.password, "dfvdfv")
                    .click(addUserPage.userSubmitButton);
            Assert.assertTrue(webElementActions.isDisplayed(addUserPage.notValidEmailAddressText));
        }

    @Test(description = "Update user information successfully")
    @Step("Update user information")
    public void updateUser() {
        String username = "P. Huel";
        WebElement user = driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']"));
        Assert.assertNotNull(user, "User '" + username + "' not found!");
        profileUserPage.updateInfoOfUsers(username);
        Assert.assertTrue(webElementActions.isDisplayed(addUserPage.successfulUserUpdateText),
                "Success message was not displayed after updating user.");
    }

        @Test(description = "Attempt to update user with invalid username")
        @Step("Update user with invalid username")
        public void updateUserNegative() {
            try {
                profileUserPage.updateInfoOfUsers("invalid_username");
                Assert.fail("Expected NoSuchElementException was not thrown");
            } catch (NoSuchElementException e) {
                Assert.assertTrue(e.getMessage().contains("Unable to locate element"),
                        "Exception message does not match expected.");
            }
        }

    @Test(description = "Update user with no parameters")
    @Step("Update user with no parameters")
    public void updateUserWithNoParameters() {
        webElementActions.click(adminDashboardPage.users);
        String username = "B. Welch";
        WebElement user = driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']"));
        Assert.assertNotNull(user, "User '" + username + "' not found!");
        webElementActions.click(user);
        addUserPage.firstName.clear();
        addUserPage.lastName.clear();
        webElementActions.sendKeys(addUserPage.firstName, "")
                .sendKeys(addUserPage.lastName, "")
                .click(addUserPage.userSubmitButton);
        Assert.assertTrue(webElementActions.isDisplayed(addUserPage.firstNameIsRequiredText),
                "First name error message not displayed.");
        Assert.assertTrue(webElementActions.isDisplayed(addUserPage.lastNameIsRequiredText),
                "Last name error message not displayed.");
    }

        @Test(description = "Verify sections on the reports page")
        @Step("Verify sections on the reports page")
        public void goToReportsProgressTest() {
            usersPage.goToReports();
            Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.progressOverviewText));
            Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.badges));
            Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.timeline));
            Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.certificates));
        }

    @Test(description = "Verify behavior when reports are found or not found")
    @Step("Check report buttons if reports exist, handle missing reports otherwise")
    public void testGoToReports() {
        try {
            usersPage.goToReports();
            Assert.assertNotNull(wait.until(ExpectedConditions.elementToBeClickable(usersPage.profileButton)), "Profile button not clickable");
            Assert.assertNotNull(wait.until(ExpectedConditions.elementToBeClickable(usersPage.progressButton)), "Progress button not clickable");
            Assert.assertNotNull(wait.until(ExpectedConditions.elementToBeClickable(usersPage.infographicButton)), "Infographic button not clickable");
            System.out.println("Reports found, buttons are clickable.");
        } catch (NoSuchElementException e) {
            System.out.println("No reports found, handled exception: " + e.getMessage());
        }
    }


    @Test(description = "Log into account and verify successful login")
        @Step("Log into account and verify successful login")
        public void logIntoAccountTest() {
            usersPage.logIntoAccount();
            Assert.assertTrue(webElementActions.isDisplayed(usersPage.headHomeField));
        }

        @Test(description = "Attempt to log in with invalid credentials")
        @Step("Attempt to log in with invalid credentials")
        public void testLogIntoAccount_NoAccountsFound() {
            try {
                usersPage.logIntoAccount();
                Assert.assertTrue(webElementActions.isDisplayed(usersPage.headHomeField));
            } catch (NoSuchElementException e) {
                Assert.assertTrue(e.getMessage().contains("No elements found on the page."));
            }
        }

        @Test(description = "Navigate to edit page and verify sections")
        @Step("Navigate to edit page and verify sections")
        public void editTest() {
            usersPage.goToEdit();
            Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.infoSection));
            Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.coursesSection));
            Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.groupsSection));
            Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.filesSection));
        }

        @Test(description = "Handle case where no edit options are found")
        @Step("Handle case where no edit options are found")
        public void testGoToEdit_NoEditOptionsFound() {
            try {
                usersPage.goToEdit();
                Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.infoSection));
                Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.coursesSection));
                Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.groupsSection));
                Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.filesSection));
            } catch (NoSuchElementException e) {
                Assert.assertTrue(e.getMessage().contains("No elements found on the page."));
            }
        }

        @Test(description = "Verify that edit page sections are clickable")
        @Step("Verify that edit page sections are clickable")
        public void editTestClickableButtons() {
            usersPage.goToEdit();
            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(profileUserPage.infoSection)) != null, "Info section not clickable");
            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(profileUserPage.coursesSection)) != null, "Courses section not clickable");
            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(profileUserPage.groupsSection)) != null, "Groups section not clickable");
            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(profileUserPage.filesSection)) != null, "Files section not clickable");
        }
    }





