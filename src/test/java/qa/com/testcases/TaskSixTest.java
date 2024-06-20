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
        driver.get(configReader.getUrl());
    }
    
    @Test(priority = 1)
    public void caseOne() {        
        
        // Explore resources
        homePage.exploreResources();
        
        // Click on Designing
        homePage.clickDesigning();
        
        // Click on Photos
        homePage.clickPhotos();
        
        // Assert: Verify headings
        Assert.assertTrue(homePage.isBeginnerHeadingDisplayed());
        Assert.assertTrue(homePage.isIntermediateHeadingDisplayed());
        Assert.assertTrue(homePage.isAdvanceHeadingDisplayed());
    }
    
//    @Test(priority = 2)
    public void caseTwo() {
       
        
        // Scroll down 
        homePage.scrollToStartLearning();
        
        // Click on Start Learning
        homePage.clickStartLearning();
        
        // Click on Programming
        homePage.clickProgramming();
        
        // Click on Java
        homePage.clickJava();
        
        // Click on View more option on W3School
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
