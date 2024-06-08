package qa.com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;
//	private final String propertyFilePath = "Test/src/test/java/qa/com/config/config.properties";

	public ConfigReader() {
		properties = new Properties();
		try (InputStream input = new FileInputStream("C:\\Users\\umair.boota_ventured\\Desktop\\test\\Test\\src\\test\\java\\qa\\com\\config\\config.properties")) {
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Failed to load config.properties file.");
		}
	}

	public String getUrl() {
		return properties.getProperty("BaseURL");
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getUsername() {
		return properties.getProperty("userName");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}
	
	public String getDevice() {
		return properties.getProperty("Device");
	}
	
	public String getHeadless() {
		return properties.getProperty("Headless");
	}
	
	public String getdbUserName() {
		return properties.getProperty("dbUsername");
	}
	
	public String getdbPassword() {
		return properties.getProperty("dbpassword");
	}
	
	public String getdbConnectionString() {
		return properties.getProperty("db_conURL");
	}

	
}