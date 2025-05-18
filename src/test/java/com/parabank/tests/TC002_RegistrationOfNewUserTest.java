package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.LoginAccountPage;
import com.parabank.pages.RegisterPage;

public class TC002_RegistrationOfNewUserTest extends BaseClass {
	@Test(groups = { "regression", "master" })
	public void Registration_of_new_user() {
		HomePage H = new HomePage(driver);
		waitForElementToBeVisible(H.getRegister());
		H.clickOnRegister();

		// On Registration page

		RegisterPage R = new RegisterPage(driver);
		waitForElementToBeVisible(R.getFirstName());
		R.sendFirstName(p.getProperty("First_Name"));

		waitForElementToBeVisible(R.getLastName());
		R.sendLasttName(p.getProperty("Last_Name"));

		waitForElementToBeVisible(R.getaddressstreet());
		R.sendAddressstreet(p.getProperty("Address"));

		waitForElementToBeVisible(R.getaddresscity());
		R.sendaddresscity(p.getProperty("city"));

		waitForElementToBeVisible(R.getaddressstate());
		R.sendaddressstate(p.getProperty("state"));

		waitForElementToBeVisible(R.getaddresszipCode());
		R.sendAddresszipCode(p.getProperty("zipcode"));

		waitForElementToBeVisible(R.getphoneNumber());
		R.sendphoneNumber(p.getProperty("phone"));

		waitForElementToBeVisible(R.getcustomerssn());
		R.sendcustomerssn(p.getProperty("SSN"));

		waitForElementToBeVisible(R.getUserName());
		R.sendUserName(p.getProperty("Username") + getRandomString());

		waitForElementToBeVisible(R.getPasswordName());
		R.sendPasswordName(p.getProperty("Password"));

		waitForElementToBeVisible(R.getRepeatPasswordName());
		R.sendRepeatPasswordName(p.getProperty("Password"));

		waitForElementToBeVisible(R.getRegister());
		R.clickOnNewUserRegister();

		// LoginAccountPage
		LoginAccountPage LA = new LoginAccountPage(driver);
		waitForElementToBeVisible(LA.getyourAccountWasCreatedSucce());

		// System.out.println(LA.isDisplayedyourAccountWasCreatedSucce());
		String Expected = "Your account was created successfully. You are now logged in.";
		String Actual = LA.isDisplayedyourAccountWasCreatedSucce();

		Assert.assertEquals(Actual, Expected, "TC_002_Registration_of_new_user is Failed" + Actual);

		// Assert.assertTrue(LA.isDisplayedyourAccountWasCreatedSucce()==Expected,
		// "TC_002_Registration_of_new_user is
		// Failed"+LA.isDisplayedyourAccountWasCreatedSucce());

	}

}