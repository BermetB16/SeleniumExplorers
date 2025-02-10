package talentLMS.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import talentLMS.driver.Driver;

import java.time.Duration;

public class WebElementActions {

    private WebDriver driver;
    private Actions actions;

    public WebElementActions(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
    }

    public WebElementActions waitBtnToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions click(WebElement element) {
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String text) {
        waitElementToBeDisplayed(element);
        highlightElement(element);
        element.sendKeys(text);
        return this;
    }

    public WebElementActions doubleClick(WebElement element) {
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element) {
        waitElementToBeDisplayed(element);
        actions.moveToElement(element).perform();
        return this;
    }

    public void rightClick(WebElement element) {
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        actions.contextClick(element).perform();
    }

    public WebElementActions highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red';" +
                "arguments[0].style.backgroundColor='peachpuff';", element);
        return this;
    }

    public boolean isDisplayed(WebElement element) {
        waitElementToBeDisplayed(element);
        return element.isDisplayed();
    }

    public boolean isEnabled(WebElement element) {
       waitBtnToBeClickable(element);
        return element.isEnabled();
    }

    public String getText(WebElement element) {
        waitElementToBeDisplayed(element);
        return element.getText();
    }

    public WebElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public WebElementActions jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions jsSendKeys(WebElement element, String txt) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value=arguments[1];", element, txt);
        return this;
    }
}