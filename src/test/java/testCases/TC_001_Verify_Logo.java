package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC_001_Verify_Logo extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void Verify_Logo() 
	{
		HomePage H= new HomePage(driver);
		H.isDisplayed();
		
		logger.info("Logo status is: "+ H.isDisplayed());
		Assert.assertTrue(H.isDisplayed());
		
		
	}
	

}
