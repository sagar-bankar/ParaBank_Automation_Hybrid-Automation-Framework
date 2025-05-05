package com.parabank.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pages.HomePage;
import com.parabank.pages.LoginAccountPage;
import com.parabank.pages.RegisterPage;

public class TC002_RegistrationOfNewUserTest extends BaseClass
{
	@Test(groups= {"regression","master"})
     public void Registration_of_new_user()
     {
    	 HomePage H=new HomePage(driver);
    	 wait.until(ExpectedConditions.visibilityOf(H.getRegister()));
    	 H.clickOnRegister();
    	 
    	 //On Registration page
    	 
    	 RegisterPage R=new RegisterPage(driver);
    	 wait.until(ExpectedConditions.visibilityOf(R.getFirstName()));
    	 R.sendFirstName(p.getProperty("First_Name"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getLastName()));
    	 R.sendLasttName(p.getProperty("Last_Name"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getaddressstreet()));
    	 R.sendAddressstreet(p.getProperty("Address"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getaddresscity()));
    	 R.sendaddresscity(p.getProperty("city"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getaddressstate()));
    	 R.sendaddressstate(p.getProperty("state"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getaddresszipCode()));
    	 R.sendAddresszipCode(p.getProperty("zipcode"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getphoneNumber()));
    	 R.sendphoneNumber(p.getProperty("phone"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getcustomerssn()));
    	 R.sendcustomerssn(p.getProperty("SSN"));
    	 
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getUserName()));
    	 R.sendUserName(p.getProperty("Username")+getRandomString());
    	 
    	 
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getPasswordName()));
    	 R.sendPasswordName(p.getProperty("Password"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getRepeatPasswordName()));
    	 R.sendRepeatPasswordName(p.getProperty("Password"));
    	 
    	 wait.until(ExpectedConditions.visibilityOf(R.getRegister()));
    	 R.clickOnNewUserRegister();
    	 
    	 //LoginAccountPage
    	 LoginAccountPage LA=new LoginAccountPage(driver);
    	 wait.until(ExpectedConditions.visibilityOf(LA.getyourAccountWasCreatedSucce()));
    	 
    	 //System.out.println(LA.isDisplayedyourAccountWasCreatedSucce());
    	String Expected="Your account was created successfully. You are now logged in.";
    	String Actual=LA.isDisplayedyourAccountWasCreatedSucce();
    	
    	Assert.assertEquals(Actual, Expected, "TC_002_Registration_of_new_user is Failed"+Actual);
    	
    	//Assert.assertTrue(LA.isDisplayedyourAccountWasCreatedSucce()==Expected, "TC_002_Registration_of_new_user is Failed"+LA.isDisplayedyourAccountWasCreatedSucce());
    	 
     }
	
}