package qa.com.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import qa.com.config.ConfigReader;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    static WebDriver driver;
    static ConfigReader configReader = new ConfigReader();

    static String device = configReader.getDevice();
    static Boolean headless = Boolean.valueOf(configReader.getHeadless());
    public static Actions action;
    public static Robot robot;

    public static WebDriver getInstance() throws AWTException {
        ChromeOptions op = new ChromeOptions();
        if (device.equals("Windows")) {
            op.addArguments("--start-maximized");
        } else {
            op.addArguments("start-fullscreen");
        }

        if (headless) {
            op.addArguments("--headless");
        }

        op.addExtensions(new File("chromeappExtension/chromeapp.crx"));

        String browser = configReader.getBrowser();
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\umair.boota_ventured\\Documents\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver(op);
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            case "ie":
                System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer"); // Set the correct path
                driver = new InternetExplorerDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver"); // Set the correct path
                driver = new FirefoxDriver();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "path/to/msedgedriver"); // Set the correct path
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        String url = configReader.getUrl();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        action = new Actions(driver);
        robot = new Robot();

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }

    public static void finishDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
