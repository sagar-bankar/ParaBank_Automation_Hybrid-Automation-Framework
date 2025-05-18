package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.MyAccountPage;

/*
 * ### Test Case: Account Balance Check

#### Test Case ID: TC008
   - Test Case Title: Verify account balance display after login
   - Pre-condition: User must be logged in.
   - Steps:
     1. Navigate to the account overview page.
     2. Check the displayed account balance.
   - Expected Result: Correct balance for each account is displayed.
   - Automated: Yes
 */

public class TC006_VerifyAccountBalanceDisplayAfterLoginTest extends BaseClass {

	@Test(groups = { "master" })
	public void Verify_account_balance_display_after_login() {

		HomePage homepage = new HomePage(driver);

		waitForElementToBeVisible(homepage.getusername());
		homepage.sendusername(p.getProperty("Username") + getRandomString());

		waitForElementToBeVisible(homepage.getpassword());
		homepage.sendpassword(p.getProperty("Password"));

		waitForElementToBeVisible(homepage.getlogIn());
		homepage.clickOnlogIn();

		// MyAccountPage
		MyAccountPage myaccountpage = new MyAccountPage(driver);
		waitForElementToBeVisible(myaccountpage.getaccountBalance());
		myaccountpage.isaccountBalanceDisplay();

		logger.info(myaccountpage.isaccountBalanceDisplay());

		Assert.assertTrue(myaccountpage.isaccountBalanceDisplay(),
				"Verify_account_balance_display_after_login: " + myaccountpage.isaccountBalanceDisplay());

	}

}