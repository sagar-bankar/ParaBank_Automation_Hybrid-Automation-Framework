package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.utils.ExtentReportManager;

public class TC009_VerifyCaseSensitivityInLoginTest extends BaseClass {

    @Test(groups = { "master" })
    public void verifyCaseSensitivityInLogin() {

        ExtentReportManager.getTest().info("Test Case: Verify Case Sensitivity in Login - Started");

        HomePage homePage = new HomePage(driver);

        waitForElementToBeVisible(homePage.getusername());
        String upperUsername = (p.getProperty("Username") + randomString).toUpperCase();
        homePage.sendusername(upperUsername);
        ExtentReportManager.getTest().info("Entered Username in uppercase: " + upperUsername);

        waitForElementToBeVisible(homePage.getpassword());
        String upperPassword = p.getProperty("Password").toUpperCase();
        homePage.sendpassword(upperPassword);
        ExtentReportManager.getTest().info("Entered Password in uppercase: " + upperPassword);

        elementToBeClicable(homePage.getcustomerLogin());
        homePage.clickOnlogIn();
        ExtentReportManager.getTest().info("Clicked on Login button with uppercase credentials.");

        waitForElementToBeVisible(homePage.getpleaseEnterAUsernameAndPa());

        String expectedError = "The username and password could not be verified.";
        String actualError = homePage.getpleaseEnterAUsernameAndPa().getText();

        ExtentReportManager.getTest().info("Expected Error Message: " + expectedError);
        ExtentReportManager.getTest().info("Actual Error Message: " + actualError);

        Assert.assertEquals(actualError, expectedError,
                "Test Case Failed: Case sensitivity in login not properly enforced. Actual message: " + actualError);

        ExtentReportManager.getTest().info("Test Case: Verify Case Sensitivity in Login - Completed Successfully.");
    }
}
