package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.utils.ExtentReportManager;

public class TC004_VerifyLoginFailureWithEmptyUsernameTest extends BaseClass {

    @Test(groups = { "master" })
    public void verifyLoginFailureWithEmptyUsername() {
        ExtentReportManager.getTest().info("Test Case: Verify Login Failure with Empty Username - Started");

        HomePage homePage = new HomePage(driver);

        waitForElementToBeVisible(homePage.getRegister()); // Optional wait - ensures page is ready
        ExtentReportManager.getTest().info("Attempting login without entering username and password.");

        homePage.clickOnlogIn();

        waitForElementToBeVisible(homePage.getpleaseEnterAUsernameAndPa());

        String expectedMessage = "Please enter a username and password.";
        String actualMessage = homePage.pleaseEnterAUsernameAndPa();
        boolean isMessageCorrect = actualMessage.contentEquals(expectedMessage);

        ExtentReportManager.getTest().info("Expected Validation Message: " + expectedMessage);
        ExtentReportManager.getTest().info("Actual Validation Message: " + actualMessage);
        ExtentReportManager.getTest().info("Validation result: " + isMessageCorrect);

        logger.info("Validation result (Empty Username): " + isMessageCorrect);

        Assert.assertTrue(isMessageCorrect,
                "Test Case Failed: Login failure message did not match. Actual message: " + actualMessage);

        ExtentReportManager.getTest().info("Test Case: Verify Login Failure with Empty Username - Completed Successfully.");
    }
}
