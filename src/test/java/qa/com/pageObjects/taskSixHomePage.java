package qa.com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

		WebElement photosLink = driver.findElement(
				By.xpath("//button[@class='btn select-category-btn shadow-none' and normalize-space()='Photo']"));
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
		WebElement startLearningSection = driver.findElement(By.xpath("//div[@id='resourceReferenceBox']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", startLearningSection);
	}

	public void clickStartLearning() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement startLearningButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='START LEARNING']")));
		startLearningButton.click();
	}

	public void clickProgramming() {
		WebElement programmingLink = driver.findElement(By.xpath("//button[normalize-space()='Programming']"));
		programmingLink.click();
	}

	public void clickJava() {
		WebElement javaLink = driver.findElement(By.xpath("//button[normalize-space()='Java']"));
		javaLink.click();
	}

	public void clickViewMoreOnW3School() {
		WebElement viewMoreLink = driver
				.findElement(By.xpath("//h5[text()='W3Schools']/parent::div//a[text()='View More']"));

		String url = viewMoreLink.getAttribute("href");

		((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", url);

		switchToNewTab();
	}

	private void switchToNewTab() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}
}
