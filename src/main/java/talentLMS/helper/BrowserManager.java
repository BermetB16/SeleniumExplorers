package talentLMS.helper;

import org.openqa.selenium.WebDriver;

public class BrowserManager {

    private WebDriver driver;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String URL) {
        driver.navigate().to(URL);
    }

    public void back() {
        driver.navigate().back();
    }

    public void forward() {
        driver.navigate().forward();
    }

    public void switchToWindow(String windowName) {
        driver.switchTo().window(windowName);
    }
}
