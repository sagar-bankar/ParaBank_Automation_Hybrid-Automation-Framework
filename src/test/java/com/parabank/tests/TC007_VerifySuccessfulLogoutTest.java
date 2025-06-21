package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.MyAccountPage;
import com.parabank.utils.ExtentReportManager;

/*
 * ### Test Case: Logout Functionality
 *
 * Test Case ID: TC007
 * Title: Verify successful logout
 * Pre-condition: User must be logged in.
 * Steps:
 *   1. Click on the logout button.
 * Expected Result: The user should be logged out, and the login page should be displayed.
 * Automated: Yes
 */

public class TC007_VerifySuccessfulLogoutTest extends BaseClass {

    @Test(groups = { "master" })
    public void verifySuccessfulLogout() {

        ExtentReportManager.getTest().info("Test Case: Verify Successful Logout - Started");

        HomePage homePage = new HomePage(driver);

        waitForElementToBeVisible(homePage.getusername());
        String username = p.getProperty("Username") + getRandomString();
        homePage.sendusername(username);
        ExtentReportManager.getTest().info("Entered Username: " + username);

        waitForElementToBeVisible(homePage.getpassword());
        homePage.sendpassword(p.getProperty("Password"));
        ExtentReportManager.getTest().info("Entered Password.");

        waitForElementToBeVisible(homePage.getlogIn());
        homePage.clickOnlogIn();
        ExtentReportManager.getTest().info("Clicked on Login button.");

        // MyAccountPage
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        waitForElementToBeVisible(myAccountPage.getlogOut());
        myAccountPage.clickOnlogOut();
        ExtentReportManager.getTest().info("Clicked on Logout button.");

        // Verifying login panel is displayed after logout
        waitForElementToBeVisible(homePage.getcustomerLogin());
        boolean isLoginVisible = homePage.isDisplayedcustomerLogin();

        ExtentReportManager.getTest().info("Login panel visibility after logout: " + isLoginVisible);
        logger.info("Login panel displayed after logout: " + isLoginVisible);

        Assert.assertTrue(isLoginVisible,
                "Test Case Failed: Login panel not displayed after logout, logout may have failed.");

        ExtentReportManager.getTest().info("Test Case: Verify Successful Logout - Completed Successfully.");
    }
}
