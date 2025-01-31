package talentLMS.driver;

import org.openqa.selenium.WebDriver;
import talentLMS.fileUtils.ConfigReader;

public class Driver {
    private Driver(){
        // singleton pattern
    }

    private static WebDriver driver;

    public  static WebDriver getDriver(){
        if (driver == null){
            switch (ConfigReader.getProperty("browserType")){
                case "chrome":
                    driver = ChromeWebDriver.loadFromDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFromDriver();
                    break;
                case "safari":
                    driver = SafariWebDriver.loadFromDriver();
                case "edge":
                    driver = EdgeWebDriver.loadFromDriver();
                    // opera

                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + ConfigReader.getProperty("browserType"));
            }
        }
        return driver;
    }
}
