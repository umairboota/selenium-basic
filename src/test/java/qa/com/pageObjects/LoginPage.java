package qa.com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators for the login elements
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter the username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to perform login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
