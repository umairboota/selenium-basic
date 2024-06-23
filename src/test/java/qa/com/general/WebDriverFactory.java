package qa.com.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;

import qa.com.config.ConfigReader;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

	static WebDriver driver;
	static ConfigReader configReader = new ConfigReader();

	static String device = configReader.getDevice();
	static Boolean headless = Boolean.valueOf(configReader.getHeadless());

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
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\umair.boota_ventured\\Documents\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver(op);
			break;

//		case "ie":
//			System.setProperty("webdriver.ie.driver",
//					"C:\\Users\\umair.boota_ventured\\Documents\\IEDriverServer_x64_4.14.0\\IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
//			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
			driver = new FirefoxDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\umair.boota_ventured\\Documents\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		String url = configReader.getUrl();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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
