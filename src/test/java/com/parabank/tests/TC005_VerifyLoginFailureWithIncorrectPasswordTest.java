package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;

/*
 * Test Case Title: Verify login failure with incorrect password
   - Pre-condition: User must be registered
   - Steps:
     1. Navigate to the login page.
     2. Enter a valid username but an incorrect password.
     3. Click on the login button.
   - Expected Result: Error message indicating incorrect login details.
   - Automated: Yes
 */

public class TC005_VerifyLoginFailureWithIncorrectPasswordTest extends BaseClass{
	
	@Test(groups= {"master"})
	public void Verify_login_failure_with_incorrect_password() {
		
		HomePage homepage=new HomePage(driver);
		waitForElementToBeVisible(homepage.getusername());
		homepage.sendusername(p.getProperty("Username")+randomString);
		
		waitForElementToBeVisible(homepage.getusername());
		homepage.sendpassword(p.getProperty("Wrong_Password"));
		
		elementToBeClicable(homepage.getlogIn());
		homepage.clickOnlogIn();
		
		
		String Expected="The username and password could not be verified.";
		String Actual=homepage.pleaseEnterAUsernameAndPa();
		boolean result=Actual.contentEquals(Expected);
		
		logger.info(Actual);
		
		Assert.assertTrue(result, "Verify_login_failure_with_incorrect_password is Failed"+Actual);
		
	}

}