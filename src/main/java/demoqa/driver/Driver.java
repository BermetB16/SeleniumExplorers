package demoqa.driver;

import demoqa.fileUtils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {
    private Driver(){
        // singleton pattern
    }

    private static WebDriver driver;

    public  static WebDriver getDriver(){
        if (driver == null){
            switch (ConfigReader.getProperty("browserType").toLowerCase()){
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
