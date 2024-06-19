package qa.com.testcases;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.com.config.ConfigReader;
import qa.com.general.WebDriverFactory;
import qa.com.pageObjects.TaskSixHomePage;

public class TaskSixTest {
    
    static WebDriver driver;
    ConfigReader configReader;
    TaskSixHomePage homePage;
    
    @BeforeClass
    public void setUp() throws AWTException {
        driver = WebDriverFactory.getInstance();
        configReader = new ConfigReader();
        homePage = new TaskSixHomePage(driver);
    }
    
    @Test(priority = 1)
    public void caseOne() {
        // Step 1: Go to the web URL
        driver.get(configReader.getUrl());
        
        // Step 2: Explore resources
        homePage.exploreResources();
        
        // Step 3: Click on Designing
        homePage.clickDesigning();
        
        // Step 4: Click on Photos
        homePage.clickPhotos();
        
        // Assert: Verify headings
        Assert.assertTrue(homePage.isBeginnerHeadingDisplayed());
        Assert.assertTrue(homePage.isIntermediateHeadingDisplayed());
        Assert.assertTrue(homePage.isAdvanceHeadingDisplayed());
    }
    
//    @Test(priority = 2)
    public void caseTwo() {
        // Step 1: Go to the dashboard
        driver.get(configReader.getUrl());
        
        // Step 2: Scroll down (if needed)
        homePage.scrollToStartLearning();
        
        // Step 3: Click on Start Learning
        homePage.clickStartLearning();
        
        // Step 4: Click on Programming
        homePage.clickProgramming();
        
        // Step 5: Click on Java
        homePage.clickJava();
        
        // Step 6: Click on View more option on W3School
        homePage.clickViewMoreOnW3School();
        
        // Assert: Verify user lands to W3School page for Java tutorial
        String expectedTitle = "Java Tutorial - W3Schools";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
    
    @AfterClass
    public void tearDown() {
        WebDriverFactory.finishDriver();
    }
}
