package talentLMS.branches;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.utils.enums.Page;

public class BranchesTest extends BaseTest {
    @BeforeClass
    public void setUp() {
        browserManager.openURL("https://seleniumexplorers.talentlms.com/plus/login");
        loginPage.doLogin(ConfigReader.getProperty("userName"), ConfigReader.getProperty("password"));
        adminDashboardModernPage.goToLegacyInterface();
        pageNavigator.switchToPage(Page.BRANCHES);
    }

    @Test
    @Step("смотреть branch video на весь экран")
    public void PlayBranchesVideoFullScreenTest() {
        branchesPage.playBranchesVideoFullScreen();
        Assert.assertTrue(branchesPage.pauseBranchesBtn.isDisplayed(), "Кнопка 'Pause' не отображается. Видео не начало воспроизведение.");
    }

    @Test
    @Step("смотреть branch video")
    public void PlayBranchesVideoTest() {
        branchesPage.playBranchesVideo();
        Assert.assertTrue(branchesPage.pauseBranchesBtn.isDisplayed(), "Кнопка 'Pause' не отображается. Видео не начало воспроизведение.");
    }

    @Test
    @Step("проверка кнопки 'Upgrade branches'")
    public void upGradeClickTest(){
        webElementActions.click(branchesPage.upgradeBranchesBtn);
        WebElement subscriptionXpath = driver.findElement(By.xpath("//a[text()=\"Subscription\"]"));
        Assert.assertTrue(subscriptionXpath.isDisplayed(), "Кнопка 'Upgrade branches' не работает.");
    }

    @Test
    @Step("проверка доступности всех полей")
    public void branchesFieldTest(){
        Assert.assertTrue(branchesPage.playBranchesBtn.isDisplayed());
        Assert.assertTrue(branchesPage.fullScreenBranchesBtn.isDisplayed());
        Assert.assertTrue(branchesPage.upgradeBranchesBtn.isDisplayed());
    }
}
