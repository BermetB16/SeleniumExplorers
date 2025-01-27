package talentLMS.helper;

import talentLMS.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementActions {
    public Actions actions = new Actions(Driver.getDriver());

    public WebElementActions waitBtnToBeClickable(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions waitElementToBeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions click(WebElement element){
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        element.click();
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String text){
        waitElementToBeDisplayed(element);
        element.sendKeys(text);
        return this;
    }

    public WebElementActions doubleClick(WebElement element){
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element){
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element){
        waitElementToBeDisplayed(element);
        actions.moveToElement(element).perform();
        return this;
    }
}
