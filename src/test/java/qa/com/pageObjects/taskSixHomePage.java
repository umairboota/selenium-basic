package qa.com.pageObjects;

import org.openqa.selenium.By;
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
		// Implement logic to check if intermediate heading is displayed
		return driver.findElement(By.xpath("//h4[normalize-space()='Intermediate']")).isDisplayed();
	}

	public boolean isAdvanceHeadingDisplayed() {
		// Implement logic to check if advance heading is displayed
		return driver.findElement(By.xpath("//h4[normalize-space()='Advanced']")).isDisplayed();
	}

	public void scrollToStartLearning() {
		// Implement logic to scroll to Start Learning section
	}

	public void clickStartLearning() {
		// Implement logic to click on Start Learning button
	}

	public void clickProgramming() {
		// Implement logic to click on Programming link
	}

	public void clickJava() {
		// Implement logic to click on Java link
	}

	public void clickViewMoreOnW3School() {
		// Implement logic to click on View more option on W3School link
	}
}
