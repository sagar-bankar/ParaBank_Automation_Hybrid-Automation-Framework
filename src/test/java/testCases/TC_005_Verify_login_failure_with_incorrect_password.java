package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

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

public class TC_005_Verify_login_failure_with_incorrect_password extends BaseClass{
	
	@Test(groups= {"master"})
	public void Verify_login_failure_with_incorrect_password() {
		
		HomePage h=new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(h.getusername()));
		h.sendusername(p.getProperty("Username")+randomString);
		
		wait.until(ExpectedConditions.visibilityOf(h.getpassword()));
		h.sendpassword(p.getProperty("Wrong_Password"));
		
		wait.until(ExpectedConditions.elementToBeClickable(h.getlogIn()));
		h.clickOnlogIn();
		
		
		String Expected="The username and password could not be verified.";
		String Actual=h.pleaseEnterAUsernameAndPa();
		boolean result=Actual.contentEquals(Expected);
		
		logger.info(Actual);
		
		Assert.assertTrue(result, "Verify_login_failure_with_incorrect_password is Failed"+Actual);
		
	}

}