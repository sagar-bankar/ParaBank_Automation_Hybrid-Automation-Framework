package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;

public class TC004_VerifyLoginFailureWithEmptyUsernameTest extends BaseClass {

	@Test(groups = { "master" })
	public void Verify_login_failure_with_empty_username() {
		HomePage homepage = new HomePage(driver);

		waitForElementToBeVisible(homepage.getRegister());
		homepage.clickOnlogIn();

		waitForElementToBeVisible(homepage.getpleaseEnterAUsernameAndPa());

		String Expected = "Please enter a username and password.";
		String Actual = homepage.pleaseEnterAUsernameAndPa();
		boolean result = Actual.contentEquals(Expected);

		logger.info(result);

		Assert.assertTrue(result, "Verify_login_failure_with_empty_username is Failed" + Actual);
	}

}