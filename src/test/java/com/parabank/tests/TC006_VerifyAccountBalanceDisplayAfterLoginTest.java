package com.parabank.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.MyAccountPage;

/*
 * ### Test Case: Account Balance Check

#### Test Case ID: TC008
   - Test Case Title: Verify account balance display after login
   - Pre-condition: User must be logged in.
   - Steps:
     1. Navigate to the account overview page.
     2. Check the displayed account balance.
   - Expected Result: Correct balance for each account is displayed.
   - Automated: Yes
 */

public class TC006_VerifyAccountBalanceDisplayAfterLoginTest extends BaseClass {
	
	@Test(groups= {"master"})
	public void Verify_account_balance_display_after_login() {
		
		HomePage H=new HomePage(driver);
		
		 wait.until(ExpectedConditions.visibilityOf(H.getusername()));
		 H.sendusername(p.getProperty("Username")+getRandomString());
		 
		 wait.until(ExpectedConditions.visibilityOf(H.getpassword()));
		 H.sendpassword(p.getProperty("Password"));
		
		 wait.until(ExpectedConditions.visibilityOf(H.getlogIn()));
		 H.clickOnlogIn();
		 
		//MyAccountPage
		 MyAccountPage MA=new MyAccountPage(driver);
		 wait.until(ExpectedConditions.visibilityOf(MA.getaccountBalance()));
		 MA.isaccountBalanceDisplay();
		 
		 logger.info(MA.isaccountBalanceDisplay());
		 
		 Assert.assertTrue(MA.isaccountBalanceDisplay(), "Verify_account_balance_display_after_login: "+MA.isaccountBalanceDisplay());
		 
	}

}