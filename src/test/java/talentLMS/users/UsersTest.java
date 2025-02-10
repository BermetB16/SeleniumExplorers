package talentLMS.users;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.users.UsersPage;
import talentLMS.utils.randomEntityUtils.RandomUserGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertThrows;

public class UsersTest extends BaseTest {

    @BeforeClass
    public void authorization() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
    }

    @Test
    public void addNewUserTest() {
        usersPage.addNewUser(randomUser);
    }

    @Test
    public void clickAddUserButton(){
        webElementActions.click(adminDashboardPage.addUserButton);
        Assert.assertTrue(webElementActions.isDisplayed(addUserPage.addUserHeadText));
    }

    @Test
    public void addNewUserLimitText(){
        webElementActions.click(adminDashboardPage.users).click(new UsersPage().addUserButton);
        Assert.assertTrue(webElementActions.isDisplayed(addUserPage.usersLimitText));
        Assert.assertEquals(addUserPage.usersLimitText.getText(), "You have just reached your active users limit. To add more users, upgrade your plan.");
    }

    @Test
    public void addNewUserNegativeTest(){
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

    @Test
    public void invalidTypeOfEmailTest(){
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


    @Test
    public void updateUser() {
        profileUserPage.updateInfoOfUsers("P. Huel");
        Assert.assertTrue(webElementActions.isDisplayed(addUserPage.successfulUserUpdateText));
    }

    @Test
    public void updateUserNegative() {
        try {
            profileUserPage.updateInfoOfUsers("invalid_username");
            Assert.fail("Expected NoSuchElementException was not thrown");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("Unable to locate element"),
                    "Сообщение исключения не содержит ожидаемый текст");
        }
    }

    @Test
    public void updateUserWithNoParameters(){
        webElementActions.click(adminDashboardPage.users);
        String username = "B. Welch";
        webElementActions.click(driver.findElement(By.xpath("//tr[@role='row']/td/a/span[text()='" + username + "']")));
        addUserPage.firstName.clear();
        addUserPage.lastName.clear();
        webElementActions.sendKeys(addUserPage.firstName, "")
                         .sendKeys(addUserPage.lastName, "")
                         .click(addUserPage.userSubmitButton);
        Assert.assertTrue(webElementActions.isDisplayed(addUserPage.firstNameIsRequiredText));
        Assert.assertTrue(webElementActions.isDisplayed(addUserPage.lastNameIsRequiredText));
    }


    @Test
    public void goToReportsProgressTest(){
        usersPage.goToReports();
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.progressOverviewText));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.badges));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.timeline));
        Assert.assertTrue(webElementActions.isDisplayed(userReportProgressPage.certificates));
    }


    @Test
    public void goToReportsProfileTest(){
        usersPage.goToReports();
        Assert.assertTrue( wait.until(ExpectedConditions.elementToBeClickable(usersPage.profileButton)) != null,"Элемент не кликабельный");
        Assert.assertTrue( wait.until(ExpectedConditions.elementToBeClickable(usersPage.progressButton)) != null,"Элемент не кликабельный");
        Assert.assertTrue( wait.until(ExpectedConditions.elementToBeClickable(usersPage.infographicButton)) != null,"Элемент не кликабельный");
        Assert.assertTrue( wait.until(ExpectedConditions.elementToBeClickable(usersPage.profileButton)) != null,"Элемент не кликабельный");
    }

    @Test
    public void testGoToReports_NoReportsFound() {
        try {
            usersPage.goToReports();
            Assert.fail("Expected NoSuchElementException, but test continued.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("No elements found on the page."));
        }
    }

    @Test
    public void logIntoAccountTest(){
        usersPage.logIntoAccount();
        Assert.assertTrue(webElementActions.isDisplayed(usersPage.headHomeField));
    }

    @Test
    public void testLogIntoAccount_NoAccountsFound() {
        try {
            usersPage.logIntoAccount();
            Assert.fail("Expected NoSuchElementException, but test continued.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("No elements found on the page."));
        }
    }


    @Test
    public void editTest(){
        usersPage.goToEdit();
        Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.infoSection));
        Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.coursesSection));
        Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.groupsSection));
        Assert.assertTrue(webElementActions.isDisplayed(profileUserPage.filesSection));
    }

    @Test
    public void testGoToEdit_NoEditOptionsFound() {
        try {
            usersPage.goToEdit();
            Assert.fail("Expected NoSuchElementException, but test continued.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("No elements found on the page."));
        }
    }


    @Test
    public void editTestClickableButtons(){
        usersPage.goToEdit();
        Assert.assertTrue( wait.until(ExpectedConditions.elementToBeClickable(profileUserPage.infoSection)) != null,"Элемент не кликабельный");
        Assert.assertTrue( wait.until(ExpectedConditions.elementToBeClickable(profileUserPage.coursesSection)) != null,"Элемент не кликабельный");
        Assert.assertTrue( wait.until(ExpectedConditions.elementToBeClickable(profileUserPage.groupsSection)) != null,"Элемент не кликабельный");
        Assert.assertTrue( wait.until(ExpectedConditions.elementToBeClickable(profileUserPage.filesSection)) != null,"Элемент не кликабельный");
    }




}




