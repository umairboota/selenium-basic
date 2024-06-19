package qa.com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskSixHomePage {

	private WebDriver driver;

	// Constructor
	public TaskSixHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void exploreResources() {
		WebElement resourcesMenu = driver.findElement(By.xpath("//a[@id='navResourceBtn']"));
		resourcesMenu.click();
	}

	public void clickDesigning() {

		WebElement designingLink = driver.findElement(By.xpath("//button[normalize-space()='Designing']"));
		designingLink.click();
	}

	public void clickPhotos() {

		WebElement photosLink = driver.findElement(By.xpath("//button[@class='btn select-category-btn shadow-none' and normalize-space()='Photo']\r\n"));
		photosLink.click();
	}

	public boolean isBeginnerHeadingDisplayed() {
		
		return driver.findElement(By.xpath("//h4[normalize-space()='Beginner']")).isDisplayed();
	}

	public boolean isIntermediateHeadingDisplayed() {
		return driver.findElement(By.xpath("//h4[normalize-space()='Intermediate']")).isDisplayed();
	}

	public boolean isAdvanceHeadingDisplayed() {
		return driver.findElement(By.xpath("//h4[normalize-space()='Advanced']")).isDisplayed();
	}

	public void scrollToStartLearning() {
        // Implement logic to scroll to Start Learning section using JavaScriptExecutor
        WebElement startLearningSection = driver.findElement(By.id("start-learning-section"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", startLearningSection);
    }

    // Method to click on the "Start Learning" button
    public void clickStartLearning() {
        // Implement logic to click on Start Learning button
        WebElement startLearningButton = driver.findElement(By.id("start-learning-button"));
        startLearningButton.click();
    }

    // Method to click on the "Programming" link
    public void clickProgramming() {
        // Implement logic to click on Programming link
        WebElement programmingLink = driver.findElement(By.linkText("Programming"));
        programmingLink.click();
    }

    // Method to click on the "Java" link
    public void clickJava() {
        // Implement logic to click on Java link
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
    }

    // Method to click on the "View more" option on W3School link
    public void clickViewMoreOnW3School() {
        // Implement logic to click on View more option on W3School link
        WebElement viewMoreLink = driver.findElement(By.xpath("//a[contains(text(), 'View more')]"));
        viewMoreLink.click();
    }
}
