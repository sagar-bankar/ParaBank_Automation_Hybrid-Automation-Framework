package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.utils.ExtentReportManager;

/*
 * Test Case Title: Verify login failure with incorrect password
 * Pre-condition: User must be registered
 * Steps:
 *   1. Navigate to the login page.
 *   2. Enter a valid username but an incorrect password.
 *   3. Click on the login button.
 * Expected Result: Error message indicating incorrect login details.
 * Automated: Yes
 */

public class TC005_VerifyLoginFailureWithIncorrectPasswordTest extends BaseClass {

    @Test(groups = { "master" })
    public void verifyLoginFailureWithIncorrectPassword() {

        ExtentReportManager.getTest().info("Test Case: Verify Login Failure with Incorrect Password - Started");

        HomePage homePage = new HomePage(driver);

        waitForElementToBeVisible(homePage.getusername());
        String testUsername = p.getProperty("Username") + randomString;
        homePage.sendusername(testUsername);
        ExtentReportManager.getTest().info("Entered Username: " + testUsername);

        waitForElementToBeVisible(homePage.getpassword());
        String testWrongPassword = p.getProperty("Wrong_Password");
        homePage.sendpassword(testWrongPassword);
        ExtentReportManager.getTest().info("Entered Incorrect Password.");

        elementToBeClicable(homePage.getlogIn());
        homePage.clickOnlogIn();
        ExtentReportManager.getTest().info("Clicked on Login button.");

        String expectedErrorMessage = "The username and password could not be verified.";
        String actualErrorMessage = homePage.pleaseEnterAUsernameAndPa();

        ExtentReportManager.getTest().info("Expected Error Message: " + expectedErrorMessage);
        ExtentReportManager.getTest().info("Actual Error Message: " + actualErrorMessage);

        boolean result = actualErrorMessage.contentEquals(expectedErrorMessage);
        logger.info("Login failure message: " + actualErrorMessage);

        Assert.assertTrue(result,
                "Test Case Failed: Incorrect login message mismatch. Actual: " + actualErrorMessage);

        ExtentReportManager.getTest().info("Test Case: Verify Login Failure with Incorrect Password - Completed Successfully.");
    }
}
