package talentLMS.page.branches;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class PlayBranchesPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"tl-bold-link\"]/a[contains(text(),\"Branches\")]")
    public WebElement branchesBtn;

    @FindBy(xpath = "//button[@aria-label=\"Play\"]")
    public WebElement playBranchesBtn;

    @FindBy(xpath = "//button[@title=\"Fullscreen\"]")
    public WebElement fullScreenBranchesBtn;

    @FindBy(xpath = "//a[text()=\"Upgrade\"]")
    public WebElement upgradeBranchesBtn;

    public PlayBranchesPage playBranchesVideo() {
        webElementActions .click(fullScreenBranchesBtn)
                          .click(playBranchesBtn);
        return new PlayBranchesPage();
    }
}
