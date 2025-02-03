package talentLMS.page.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import talentLMS.exception.PageNotFoundException;
import talentLMS.utils.enums.Page;
import talentLMS.utils.enums.Role;

public class PageNavigator extends BasePage {

    public void switchToPage(Page page) {
        try {
            webElementActions.click(driver.findElement(By.xpath(page.getXPath())));
        } catch (NoSuchElementException e) {
            throw new PageNotFoundException("Page not found by his xPath: " + page.getXPath());
        } catch (Exception e) {
            throw new RuntimeException("Cannot navigate to page: " + page.getXPath());
        }
    }

    public void switchToPageByRole(Role role) {
        try {
            WebElement dropDownMenu = driver.findElement(By.id("tl-dropdown-roles"));
            webElementActions.moveToElement(dropDownMenu);
            webElementActions.click(dropDownMenu.findElement(By.id(role.getXPath())));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("DropDownMenu not found " + role);
        }
    }
}