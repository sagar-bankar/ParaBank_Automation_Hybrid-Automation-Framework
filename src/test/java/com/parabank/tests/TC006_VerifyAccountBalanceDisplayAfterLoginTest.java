package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.MyAccountPage;
import com.parabank.utils.ExtentReportManager;

/*
 * ### Test Case: Account Balance Check
 *
 * Test Case ID: TC006
 * Title: Verify account balance display after login
 * Pre-condition: User must be logged in.
 * Steps:
 *   1. Navigate to the account overview page.
 *   2. Check the displayed account balance.
 * Expected Result: Correct balance for each account is displayed.
 * Automated: Yes
 */

public class TC006_VerifyAccountBalanceDisplayAfterLoginTest extends BaseClass {

    @Test(groups = { "master" })
    public void verifyAccountBalanceDisplayAfterLogin() {

        ExtentReportManager.getTest().info("Test Case: Verify Account Balance Display After Login - Started");

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

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        waitForElementToBeVisible(myAccountPage.getaccountBalance());

        boolean isBalanceDisplayed = myAccountPage.isaccountBalanceDisplay();
        ExtentReportManager.getTest().info("Account Balance Displayed: " + isBalanceDisplayed);

        logger.info("Account balance display status: " + isBalanceDisplayed);

        Assert.assertTrue(isBalanceDisplayed,
                "Test Case Failed: Account balance was not displayed correctly after login.");

        ExtentReportManager.getTest().info("Test Case: Verify Account Balance Display After Login - Completed Successfully.");
    }
}
