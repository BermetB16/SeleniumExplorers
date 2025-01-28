package talentLMS.helper;

import talentLMS.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementActions {

    private static Actions actions = new Actions(Driver.getDriver());

    public static void waitBtnToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement element) {
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        element.click();
    }

    public static void sendKeys(WebElement element, String text) {
        waitElementToBeDisplayed(element);
        element.sendKeys(text);
    }

    public static void doubleClick(WebElement element) {
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        actions.doubleClick(element).perform();
    }

    public static void rightClick(WebElement element) {
        waitElementToBeDisplayed(element);
        waitBtnToBeClickable(element);
        actions.contextClick(element).perform();
    }

    public static String getText(WebElement element) {
        waitElementToBeDisplayed(element); // Ожидание, пока элемент станет видимым
        return element.getText(); // Возврат текста элемента
    }
}