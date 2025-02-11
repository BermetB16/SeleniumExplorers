package talentLMS.driver;

import org.openqa.selenium.WebDriver;
import talentLMS.fileUtils.ConfigReader;

public class Driver {

    public static WebDriver driver;

    private Driver() {
        // singleton pattern
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browserType")) {
                case "chrome":
                    driver = ChromeWebDriver.loadFromDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFromDriver();
                    break;
                case "safari":
                    driver = SafariWebDriver.loadFromDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadFromDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + ConfigReader.getProperty("browserType"));
            }
        }
        return driver;
    }
}