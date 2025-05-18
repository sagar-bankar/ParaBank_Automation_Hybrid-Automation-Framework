package com.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;

public class TC001_VerifyLogoTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void Verify_Logo() 
	{
		HomePage homepage= new HomePage(driver);
		waitForElementToBeVisible(homepage.getparaBank());
		homepage.isDisplayed();
		
		logger.info("Logo status is: "+ homepage.isDisplayed());
		Assert.assertTrue(homepage.isDisplayed());
		
		
	}
	

}
