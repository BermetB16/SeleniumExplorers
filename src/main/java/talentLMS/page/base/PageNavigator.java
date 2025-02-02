package talentLMS.page.base;

import org.openqa.selenium.By;
import talentLMS.utils.enums.Page;

public class PageNavigator extends BasePage {

    public void switchToPage(Page page) {
        webElementActions.click(driver.findElement(By.xpath(page.getXPath())));
    }
}