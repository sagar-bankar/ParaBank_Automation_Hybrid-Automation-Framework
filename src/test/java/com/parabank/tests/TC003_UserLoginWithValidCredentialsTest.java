package com.parabank.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;

public class TC003_UserLoginWithValidCredentialsTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void User_login_with_valid_credentials()
	{
		
		HomePage H=new HomePage(driver);
		
		   
			 wait.until(ExpectedConditions.visibilityOf(H.getusername()));
			 H.sendusername(p.getProperty("Username")+getRandomString());
			 
			 wait.until(ExpectedConditions.visibilityOf(H.getpassword()));
			 H.sendpassword(p.getProperty("Password"));
			
			 wait.until(ExpectedConditions.visibilityOf(H.getlogIn()));
			 H.clickOnlogIn();
		
		//MyAccountPage
		com.parabank.pages.MyAccountPage MA=new com.parabank.pages.MyAccountPage(driver);
		wait.until(ExpectedConditions.visibilityOf(MA.getlogOut()));
		
		Assert.assertTrue(MA.isDisablelogOut(), "TC_003_User_login_with_valid_credentials is failed"+MA.isDisablelogOut());
		
		
		
		
	}

}