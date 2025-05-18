package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.MyAccountPage;

/*
 * ### Test Case: Logout Functionality

#### Test Case ID: TC009
   - Test Case Title: Verify successful logout
   - Pre-condition: User must be logged in.
   - Steps:
     1. Click on the logout button.
   - Expected Result: The user should be logged out, and the login page should be displayed.
   - Automated: Yes
 * 
 */
public class TC007_VerifySuccessfulLogoutTest extends BaseClass {

	@Test(groups = { "master" })
	public void Verify_successful_logout() {
		// HomePage
		HomePage homepage = new HomePage(driver);

		waitForElementToBeVisible(homepage.getusername());
		homepage.sendusername(p.getProperty("Username") + getRandomString());

		waitForElementToBeVisible(homepage.getpassword());
		homepage.sendpassword(p.getProperty("Password"));

		waitForElementToBeVisible(homepage.getlogIn());
		homepage.clickOnlogIn();

		// MyAccountPage
		MyAccountPage myaccountpage = new MyAccountPage(driver);
		waitForElementToBeVisible(myaccountpage.getlogOut());
		myaccountpage.clickOnlogOut();

		// HomePage
		waitForElementToBeVisible(homepage.getcustomerLogin());
		System.out.println(homepage.getcustomerLogin());

		boolean iscustomerLoginDisplay = homepage.isDisplayedcustomerLogin();
		logger.info("Login button displayed: " + iscustomerLoginDisplay);

		Assert.assertTrue(iscustomerLoginDisplay, "Verify_successful_logout is Failed ");
	}

}