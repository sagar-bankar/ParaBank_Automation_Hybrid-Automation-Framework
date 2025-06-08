package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;

public class TC003_UserLoginWithValidCredentialsTest extends BaseClass {

	@Test(groups = { "sanity", "master" })
	public void User_login_with_valid_credentials() {

		HomePage homepage = new HomePage(driver);

		waitForElementToBeVisible(homepage.getusername());
		homepage.sendusername(p.getProperty("Username") + getRandomString());

		waitForElementToBeVisible(homepage.getpassword());
		homepage.sendpassword(p.getProperty("Password"));

		logger.info("Login username-->: "+p.getProperty("Username") + getRandomString());
		logger.info("Login password-->: "+p.getProperty("Password") );
		
		waitForElementToBeVisible(homepage.getlogIn());
		homepage.clickOnlogIn();

		// MyAccountPage
		com.parabank.pages.MyAccountPage MA = new com.parabank.pages.MyAccountPage(driver);
		waitForElementToBeVisible(MA.getlogOut());

		Assert.assertTrue(MA.isDisablelogOut(),
				"TC_003_User_login_with_valid_credentials is failed" + MA.isDisablelogOut());

	}

}