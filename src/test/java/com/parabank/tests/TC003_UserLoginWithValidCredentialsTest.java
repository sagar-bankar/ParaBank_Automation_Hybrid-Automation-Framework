package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.MyAccountPage;
import com.parabank.utils.ExtentReportManager;

public class TC003_UserLoginWithValidCredentialsTest extends BaseClass {

    @Test(groups = { "sanity", "master" })
    public void userLoginWithValidCredentials() {

        ExtentReportManager.getTest().info("Test Case: User Login with Valid Credentials - Started");

        HomePage homePage = new HomePage(driver);

        waitForElementToBeVisible(homePage.getusername());
        String uniqueUsername = p.getProperty("Username") + getRandomString();
        homePage.sendusername(uniqueUsername);
        ExtentReportManager.getTest().info("Entered Username: " + uniqueUsername);

        waitForElementToBeVisible(homePage.getpassword());
        homePage.sendpassword(p.getProperty("Password"));
        ExtentReportManager.getTest().info("Entered Password.");

        logger.info("Login Username: " + uniqueUsername);
        logger.info("Login Password: " + p.getProperty("Password"));

        waitForElementToBeVisible(homePage.getlogIn());
        homePage.clickOnlogIn();
        ExtentReportManager.getTest().info("Clicked on Login button.");

        // Verifying successful login
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        waitForElementToBeVisible(myAccountPage.getlogOut());

        boolean isLogoutVisible = myAccountPage.isDisablelogOut();
        ExtentReportManager.getTest().info("Logout button display status: " + isLogoutVisible);

        Assert.assertTrue(isLogoutVisible,
                "Test Case Failed: Logout button was not found, indicating login may have failed.");

        ExtentReportManager.getTest().info("Test Case: User Login with Valid Credentials - Completed Successfully.");
    }
}
