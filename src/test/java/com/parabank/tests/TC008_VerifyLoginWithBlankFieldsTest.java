package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.parabank.pages.HomePage;

public class TC008_VerifyLoginWithBlankFieldsTest extends BaseClass {

	@Test
	public void VerifyLoginWithBlankFieldsTest() {
		HomePage homepage = new HomePage(driver);

		waitForElementToBeVisible(homepage.getusername());
		waitForElementToBeVisible(homepage.getpassword());

		elementToBeClicable(homepage.getcustomerLogin());
		homepage.clickOnlogIn();

		waitForElementToBeVisible(homepage.getpleaseEnterAUsernameAndPa());

		String expectederror = "Please enter a username and password.";
		String actualerror = homepage.getpleaseEnterAUsernameAndPa().getText();
		Assert.assertEquals(actualerror, expectederror);
	}

}
