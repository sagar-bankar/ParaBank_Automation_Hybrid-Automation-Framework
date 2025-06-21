package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.LoginAccountPage;
import com.parabank.pages.RegisterPage;
import com.parabank.utils.ExtentReportManager;

public class TC002_RegistrationOfNewUserTest extends BaseClass {
    
    @Test(groups = { "regression", "master" })
    public void registrationOfNewUser() {
        ExtentReportManager.getTest().info("Test Case: Registration of New User - Started");

        // Navigate to Register Page
        HomePage homePage = new HomePage(driver);
        waitForElementToBeVisible(homePage.getRegister());
        ExtentReportManager.getTest().info("Register link is visible. Clicking on Register...");
        homePage.clickOnRegister();

        // Fill out the Registration Form
        RegisterPage registerPage = new RegisterPage(driver);

        waitForElementToBeVisible(registerPage.getFirstName());
        registerPage.sendFirstName(p.getProperty("First_Name"));
        ExtentReportManager.getTest().info("Entered First Name.");

        waitForElementToBeVisible(registerPage.getLastName());
        registerPage.sendLasttName(p.getProperty("Last_Name"));
        ExtentReportManager.getTest().info("Entered Last Name.");

        waitForElementToBeVisible(registerPage.getaddressstreet());
        registerPage.sendAddressstreet(p.getProperty("Address"));
        ExtentReportManager.getTest().info("Entered Address.");

        waitForElementToBeVisible(registerPage.getaddresscity());
        registerPage.sendaddresscity(p.getProperty("city"));
        ExtentReportManager.getTest().info("Entered City.");

        waitForElementToBeVisible(registerPage.getaddressstate());
        registerPage.sendaddressstate(p.getProperty("state"));
        ExtentReportManager.getTest().info("Entered State.");

        waitForElementToBeVisible(registerPage.getaddresszipCode());
        registerPage.sendAddresszipCode(p.getProperty("zipcode"));
        ExtentReportManager.getTest().info("Entered Zip Code.");

        waitForElementToBeVisible(registerPage.getphoneNumber());
        registerPage.sendphoneNumber(p.getProperty("phone"));
        ExtentReportManager.getTest().info("Entered Phone Number.");

        waitForElementToBeVisible(registerPage.getcustomerssn());
        registerPage.sendcustomerssn(p.getProperty("SSN"));
        ExtentReportManager.getTest().info("Entered SSN.");

        String uniqueUsername = p.getProperty("Username") + getRandomString();
        waitForElementToBeVisible(registerPage.getUserName());
        registerPage.sendUserName(uniqueUsername);
        ExtentReportManager.getTest().info("Entered Username: " + uniqueUsername);

        waitForElementToBeVisible(registerPage.getPasswordName());
        registerPage.sendPasswordName(p.getProperty("Password"));
        ExtentReportManager.getTest().info("Entered Password.");

        waitForElementToBeVisible(registerPage.getRepeatPasswordName());
        registerPage.sendRepeatPasswordName(p.getProperty("Password"));
        ExtentReportManager.getTest().info("Repeated Password.");

        waitForElementToBeVisible(registerPage.getRegister());
        registerPage.clickOnNewUserRegister();
        ExtentReportManager.getTest().info("Clicked on Register button.");

        // Validate Account Creation Message
        LoginAccountPage loginPage = new LoginAccountPage(driver);
        waitForElementToBeVisible(loginPage.getyourAccountWasCreatedSucce());

        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String actualMessage = loginPage.isDisplayedyourAccountWasCreatedSucce();

        ExtentReportManager.getTest().info("Verifying success message after registration.");
        ExtentReportManager.getTest().info("Expected: " + expectedMessage);
        ExtentReportManager.getTest().info("Actual: " + actualMessage);

        Assert.assertEquals(actualMessage, expectedMessage,
                "Test Case Failed: Registration message mismatch. Actual: " + actualMessage);

        ExtentReportManager.getTest().info("Test Case: Registration of New User - Completed Successfully.");
    }
}
