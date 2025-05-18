package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;

public class TC009_VerifyCaseSensitivityInLoginTest extends BaseClass {

	@Test
	public void VerifyCaseSensitivityInLoginTest() {
		HomePage homepage = new HomePage(driver);

		waitForElementToBeVisible(homepage.getusername());
		homepage.sendusername((p.getProperty("Username") + randomString).toUpperCase()); // All---->sendinCapital

		waitForElementToBeVisible(homepage.getpassword());
		homepage.sendpassword((p.getProperty("Password")).toUpperCase()); // Capital password

		elementToBeClicable(homepage.getcustomerLogin());
		homepage.clickOnlogIn();

		waitForElementToBeVisible(homepage.getpleaseEnterAUsernameAndPa());

		String expectederror = "The username and password could not be verified.";
		String actualerror = homepage.getpleaseEnterAUsernameAndPa().getText();
		Assert.assertEquals(actualerror, expectederror);
	}

}
