package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.utils.ExtentReportManager;

public class TC001_VerifyLogoTest extends BaseClass {
    
    @Test(groups = {"sanity", "master"})
    public void verifyLogoIsDisplayed() {
        ExtentReportManager.getTest().info("Test Case: Verify Logo Display - Started");

        HomePage homePage = new HomePage(driver);
        ExtentReportManager.getTest().info("Navigated to ParaBank home page");

        waitForElementToBeVisible(homePage.getparaBank());
        
        boolean isLogoDisplayed = homePage.isDisplayed();
        ExtentReportManager.getTest().info("Logo display status on homepage: " + isLogoDisplayed);
        logger.info("Logo status retrieved: " + isLogoDisplayed);

        Assert.assertTrue(isLogoDisplayed, "Logo should be displayed on the homepage.");

        ExtentReportManager.getTest().info("Test Case: Verify Logo Display - Completed");
    }
}
