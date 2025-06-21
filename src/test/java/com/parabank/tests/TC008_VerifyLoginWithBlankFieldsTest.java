package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.parabank.pages.HomePage;
import com.parabank.utils.ExtentReportManager;

public class TC008_VerifyLoginWithBlankFieldsTest extends BaseClass {

    @Test(groups = { "master" })
    public void verifyLoginWithBlankFields() {

        ExtentReportManager.getTest().info("Test Case: Verify Login With Blank Fields - Started");

        HomePage homePage = new HomePage(driver);

        waitForElementToBeVisible(homePage.getusername());
        waitForElementToBeVisible(homePage.getpassword());
        ExtentReportManager.getTest().info("Username and Password fields are visible but not entered.");

        elementToBeClicable(homePage.getcustomerLogin());
        homePage.clickOnlogIn();
        ExtentReportManager.getTest().info("Clicked on Login button without entering credentials.");

        waitForElementToBeVisible(homePage.getpleaseEnterAUsernameAndPa());

        String expectedError = "Please enter a username and password.";
        String actualError = homePage.getpleaseEnterAUsernameAndPa().getText();

        ExtentReportManager.getTest().info("Expected Error Message: " + expectedError);
        ExtentReportManager.getTest().info("Actual Error Message: " + actualError);

        Assert.assertEquals(actualError, expectedError,
                "Test Case Failed: Error message mismatch. Actual: " + actualError);

        ExtentReportManager.getTest().info("Test Case: Verify Login With Blank Fields - Completed Successfully.");
    }
}
