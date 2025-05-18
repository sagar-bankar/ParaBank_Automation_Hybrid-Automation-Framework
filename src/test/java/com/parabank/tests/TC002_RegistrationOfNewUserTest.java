package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.LoginAccountPage;
import com.parabank.pages.RegisterPage;

public class TC002_RegistrationOfNewUserTest extends BaseClass {
	@Test(groups = { "regression", "master" })
	public void Registration_of_new_user() {
		HomePage homepage = new HomePage(driver);
		waitForElementToBeVisible(homepage.getRegister());
		homepage.clickOnRegister();

		// On Registration page

		RegisterPage register = new RegisterPage(driver);
		waitForElementToBeVisible(register.getFirstName());
		register.sendFirstName(p.getProperty("First_Name"));

		waitForElementToBeVisible(register.getLastName());
		register.sendLasttName(p.getProperty("Last_Name"));

		waitForElementToBeVisible(register.getaddressstreet());
		register.sendAddressstreet(p.getProperty("Address"));

		waitForElementToBeVisible(register.getaddresscity());
		register.sendaddresscity(p.getProperty("city"));

		waitForElementToBeVisible(register.getaddressstate());
		register.sendaddressstate(p.getProperty("state"));

		waitForElementToBeVisible(register.getaddresszipCode());
		register.sendAddresszipCode(p.getProperty("zipcode"));

		waitForElementToBeVisible(register.getphoneNumber());
		register.sendphoneNumber(p.getProperty("phone"));

		waitForElementToBeVisible(register.getcustomerssn());
		register.sendcustomerssn(p.getProperty("SSN"));

		waitForElementToBeVisible(register.getUserName());
		register.sendUserName(p.getProperty("Username") + getRandomString());

		waitForElementToBeVisible(register.getPasswordName());
		register.sendPasswordName(p.getProperty("Password"));

		waitForElementToBeVisible(register.getRepeatPasswordName());
		register.sendRepeatPasswordName(p.getProperty("Password"));

		waitForElementToBeVisible(register.getRegister());
		register.clickOnNewUserRegister();

		// LoginAccountPage
		LoginAccountPage loginaccountpage = new LoginAccountPage(driver);
		waitForElementToBeVisible(loginaccountpage.getyourAccountWasCreatedSucce());

		// System.out.println(LA.isDisplayedyourAccountWasCreatedSucce());
		String Expected = "Your account was created successfully. You are now logged in.";
		String Actual = loginaccountpage.isDisplayedyourAccountWasCreatedSucce();

		Assert.assertEquals(Actual, Expected, "TC_002_Registration_of_new_user is Failed" + Actual);

		// Assert.assertTrue(LA.isDisplayedyourAccountWasCreatedSucce()==Expected,
		// "TC_002_Registration_of_new_user is
		// Failed"+LA.isDisplayedyourAccountWasCreatedSucce());

	}

}