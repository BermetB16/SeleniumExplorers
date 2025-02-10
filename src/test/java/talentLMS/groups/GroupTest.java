package talentLMS.groups;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.utils.enums.Page;
import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
public class GroupTest extends BaseTest {

    @BeforeClass
    public void setUp() {


        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));


        adminDashboardModernPage.goToLegacyInterface();
        pageNavigator.switchToPage(Page.GROUPS);


    }

    @Test
    @Step("Создание группы")
    public void testCreateGroup() {

        String groupName = "Test";
        String groupDescription = "Test Group Description";
        String price = "10";

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription(groupDescription)
                .clickGroupPriceBtn()
                .inputPriceOfGroup.sendKeys(price);
        groupsPage.clickSaveGroup();



        Assert.assertTrue(groupsPage.getSuccessMessage().contains("Success! New group created."));
    }



    @Test
    @Step("Редактирование группы")
    public void testEditGroup() {
        String updatedGroupName = "Updated Test Group";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        webElementActions.moveToElement(groupsPage.triplePoint);

        groupsPage.clickEditGroup();

        groupsPage.enterGroupName(updatedGroupName)
                .clickSaveGroup();

        webElementActions.waitElementToBeDisplayed(groupsPage.successMessage);

        Assert.assertTrue(groupsPage.getSuccessMessage().contains("Success! Group updated."));
    }


    @Test
    @Step("Удаление группы")
    public void testDeleteGroup() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        webElementActions.moveToElement(groupsPage.triplePoint);


        groupsPage.clickDeleteGroup();


        WebElement confirmButton = wait.until(ExpectedConditions.visibilityOf(groupsPage.confirmDeleteBtn));


        confirmButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(), 'SeleniumExplorers')]")));


        boolean isGroupPresent = groupsPage.isGroupPresent("Test");
        assertFalse("ГGroup is not deleted", isGroupPresent);
    }

    @Test
    @Step("Создание группы с пустыми полями")
    public void testCreateGroupWithEmptyFields() {


        String groupName = "";
        String groupDescription = "Description";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        groupsPage.clickAddGroupHome();


        groupsPage.enterGroupName(groupName);


        groupsPage.clickSaveGroup();


        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(groupsPage.getErrorMessage()));



        Assert.assertTrue(errorMessage.getText().contains("'Name' is required"), "Ошибка не содержит ожидаемого текста.");
    }

    @Test
    @Step("Создание группы без описания")
    public void testCreateGroupWithoutDescription() {

        String groupName = "Test Group Without Description";
        String groupDescription = "";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription(groupDescription)
                .clickSaveGroup();



        Assert.assertTrue(groupsPage.getSuccessMessage().contains("Success! New group created."));
    }
    @Test
    @Step("Отмена создания группы")
    public void testCancelCreateGroup() {

        String groupName = "Cancelled Group";


        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .clickCancelGroup();

        Assert.assertFalse(groupsPage.isGroupPresent(groupName), "Группа была создана, несмотря на отмену.");
    }
    @Test
    @Step("Создание группы с особыми символами")
    public void testCreateGroupWithSpecialCharacters() {
        String groupName = "Test@#Group!";
        String groupDescription = "Group with special characters";

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription(groupDescription)
                .clickSaveGroup();

        Assert.assertTrue(groupsPage.getSuccessMessage().contains("Success! New group created."));
    }

    @Test
    @Step("Добавление пользователя в группу")
    public void testAddUserToGroup() {
        String groupName = "Group with user";
        String groupDescription = "Group with users";
        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription(groupDescription)
                .clickSaveGroup();

        webElementActions.waitBtnToBeClickable(groupsPage.addUserToGroupBtn);
        groupsPage.addUserToGroupBtn.click();

        webElementActions.waitElementToBeDisplayed(groupsPage.groupMemberText);

        Assert.assertTrue(groupsPage.groupMemberText.isDisplayed(), "user is added to group");
    }
    @Test(priority = 41)
    @Step("Verify groups page loads correctly")
    public void testGroupsPageLoad() {
        groupsPage.clickAddGroupHome();


        Assert.assertTrue(groupsPage.groupsBtnOnHomePage.isDisplayed(), "Groups page did not load.");
    }
    @Test
    @Step("Verify all groups are displayed on groups page")
    public void testGroupsDisplayOnPage() {
        List<WebElement> groups = groupsPage.webTableOfGroups;

        Assert.assertTrue(groups.size() > 0, "No groups displayed on the page.");
    }
    @Test(priority = 14)
    @Step("Verify group key assignment")
    public void testAssignGroupKey() {
        String groupName = "Group with Key";
        String groupKey = "Group1234";

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription("Group with a unique key")
                .enterGroupKeyButton(groupKey)    // Кликовая операция для вызова поля ввода ключа// Передача значения ключа группы
                .clickSaveGroup();

        Assert.assertFalse(groupsPage.getSuccessMessage().contains("Group has been successfully created"),
                "Group key was not assigned properly.");
    }
    @Test
    @Step("Verify all fields are visible while creating a group")
    public void testFieldsForGroupCreation() {
        groupsPage.clickAddGroupHome();
        Assert.assertTrue(groupsPage.groupNameField.isDisplayed(), "Group name field is not visible.");
        Assert.assertTrue(groupsPage.groupDescriptionField.isDisplayed(), "Group description field is not visible.");
        Assert.assertTrue(groupsPage.saveGroupBtn.isDisplayed(), "'Save' button is not visible.");
    }
    @Test
    @Step("Добавление курса в группу")
    public void testAddCourseToGroup() {
        String groupName = "Group with Course";
        String groupDescription = "Group for adding course";

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription(groupDescription)
                .clickSaveGroup()
                        .clickCourseButton();

        webElementActions.waitBtnToBeClickable(groupsPage.addCourseToGroup);
        groupsPage.addCourseToGroup.click();

        webElementActions.waitElementToBeDisplayed(groupsPage.CourseGroupMemberText);
        Assert.assertTrue(groupsPage.CourseGroupMemberText.isDisplayed(), "Курс не был добавлен в группу.");
    }
    @Test
    @Step("Проверка, что курс не добавляется, если он не существует")
    public void testAddNonExistingCourse() {
        String groupName = "Group for Non-Existing Course";
        String groupDescription = "Group where non-existing course should not be added";
        String nonExistingCourseName = "Non-Existing Course";

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription(groupDescription)
                .clickSaveGroup()
                .clickCourseButton();

        boolean isCoursePresent = groupsPage.driver.findElements(By.xpath("//a[contains(text(), '" + nonExistingCourseName + "')]")).size() > 0;

        Assert.assertFalse(isCoursePresent, "Невозможно добавить несуществующий курс.");
    }
    @Test
    @Step("Создание группы с нулевой ценой")
    public void testCreateGroupWithZeroPrice() {
        String groupName = "Group With Zero Price";
        String groupDescription = "This group has zero price";
        String price = "0"; // Цена 0

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription(groupDescription)
                .clickGroupPriceBtn()
                .inputPriceOfGroup.sendKeys(price);
        groupsPage
                .clickSaveGroup();

        Assert.assertTrue(groupsPage.getSuccessMessage().contains("Success! New group created."),
                "Группа с нулевой ценой не была создана.");
    }
    @Test
    @Step("Проверка сортировки групп по имени")
    public void testGroupSortingByName() {
        String groupName1 = "Alpha Group";
        String groupName2 = "Beta Group";

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName1)
                .enterGroupDescription("Description for Alpha group")
                .clickSaveGroup()
                        .groupButtonOnHomePage();

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName2)
                .enterGroupDescription("Description for Beta group")
                .clickSaveGroup()
                .groupButtonOnHomePage();

        // Получение списка всех групп и проверка сортировки
        List<WebElement> groups = groupsPage.webTableOfGroups;
        Assert.assertTrue(groups.get(0).getText().compareTo(groups.get(1).getText()) < 0, "Группы не отсортированы по имени.");
    }
    @Test
    @Step("Проверка добавления нескольких пользователей в группу")
    public void testAddMultipleUsersToGroup() {
        String groupName = "Group with Multiple Users";
        String groupDescription = "This group will have multiple users added to it";

        groupsPage.clickAddGroupHome()
                .enterGroupName(groupName)
                .enterGroupDescription(groupDescription)
                .clickSaveGroup();


        groupsPage.addUserToGroup();
        groupsPage.addUserToGroup();
        groupsPage.addUserToGroup();


        Assert.assertTrue(groupsPage.groupMemberText.isDisplayed(), "Пользователи не были добавлены в группу.");
    }
    @Test
    @Step("Проверка массового добавления групп")
    public void testBulkGroupCreation() {
        for (int i = 1; i <= 5; i++) {
            String groupName = "Group " + i;
            groupsPage.clickAddGroupHome()
                    .enterGroupName(groupName)
                    .enterGroupDescription("Description for " + groupName)
                    .clickSaveGroup()
                    .groupButtonOnHomePage();
        }


        for (int i = 1; i <= 5; i++) {
            String groupName = "Group " + i;
            Assert.assertTrue(groupsPage.isGroupPresent(groupName), "Группа " + groupName + " не была найдена.");
        }
    }





































}
















































