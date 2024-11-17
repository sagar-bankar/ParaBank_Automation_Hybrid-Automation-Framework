package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC_004_Verify_login_failure_with_empty_username extends BaseClass {
	
	@Test(groups= {"master"})
	public void Verify_login_failure_with_empty_username() 
	{
		HomePage H=new HomePage(driver);
		
		wait.until(ExpectedConditions.visibilityOf(H.getRegister()));
		H.clickOnlogIn();
		
		wait.until(ExpectedConditions.visibilityOf(H.getpleaseEnterAUsernameAndPa()));
		
		String Expected="Please enter a username and password.";
		String Actual=H.pleaseEnterAUsernameAndPa();
		boolean result=Actual.contentEquals(Expected);
		
		logger.info(result);
		
		Assert.assertTrue(result, "Verify_login_failure_with_empty_username is Failed"+Actual);
	}

}