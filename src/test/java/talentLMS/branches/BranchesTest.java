package talentLMS.branches;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentLMS.base.BaseTest;
import talentLMS.fileUtils.ConfigReader;
import talentLMS.page.base.BasePage;
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
    public void PlayBranchesVideoTest() {
        playBranchesPage.playBranchesVideo();
        String ariaLabel = playBranchesPage.playBranchesBtn.getAttribute("aria-label");
        Assert.assertEquals(ariaLabel, "Pause", "Кнопка не изменила свой атрибут на 'Pause'. Текущий атрибут: " + ariaLabel);
    }
    }
