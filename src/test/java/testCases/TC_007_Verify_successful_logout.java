package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;

/*
 * ### Test Case: Logout Functionality

#### Test Case ID: TC009
   - Test Case Title: Verify successful logout
   - Pre-condition: User must be logged in.
   - Steps:
     1. Click on the logout button.
   - Expected Result: The user should be logged out, and the login page should be displayed.
   - Automated: Yes
 * 
 */
public class TC_007_Verify_successful_logout extends BaseClass{

	@Test(groups= {"master"})
	public void Verify_successful_logout() {
		//HomePage
		HomePage H=new HomePage(driver);
		
		 wait.until(ExpectedConditions.visibilityOf(H.getusername()));
		 H.sendusername(p.getProperty("Username")+getRandomString());
		 
		 wait.until(ExpectedConditions.visibilityOf(H.getpassword()));
		 H.sendpassword(p.getProperty("Password"));
		
		 wait.until(ExpectedConditions.visibilityOf(H.getlogIn()));
		 H.clickOnlogIn();
		 
		 //MyAccountPage
		 MyAccountPage MA=new MyAccountPage(driver);
		 wait.until(ExpectedConditions.visibilityOf(MA.getlogOut()));
		 MA.clickOnlogOut();
		 
		 //HomePage
		 wait.until(ExpectedConditions.visibilityOf(H.getcustomerLogin()));
		 System.out.println( H.getcustomerLogin());
		
		 boolean iscustomerLoginDisplay=H.isDisplayedcustomerLogin();
		 logger.info("Login button displayed: " + iscustomerLoginDisplay);
		
		 
		 Assert.assertTrue( iscustomerLoginDisplay, "Verify_successful_logout is Failed ");
	}
	
}