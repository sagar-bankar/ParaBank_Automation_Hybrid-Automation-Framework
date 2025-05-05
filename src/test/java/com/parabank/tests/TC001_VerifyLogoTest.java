package com.parabank.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;

public class TC001_VerifyLogoTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void Verify_Logo() 
	{
		HomePage H= new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(H.getparaBank()));
		H.isDisplayed();
		
		logger.info("Logo status is: "+ H.isDisplayed());
		Assert.assertTrue(H.isDisplayed());
		
		
	}
	

}
