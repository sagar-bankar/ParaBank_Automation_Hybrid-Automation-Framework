package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
	
	 WebDriver driver;
	 private static final int TIMEOUT = 10;  // 10 seconds timeout
	
	public HomePage(WebDriver driver)
	{
		//this.driver=driver;
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
		
	}
	
	//Locators
	@FindBy(xpath="//img[@title='ParaBank']") 
	 private WebElement paraBank;
	
	@FindBy(xpath="//input[@name='username']") 
	@CacheLookup private WebElement username;
	
	@FindBy(xpath="//input[@name='password']") 
	@CacheLookup private WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']") 
	@CacheLookup private WebElement logIn;
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	@CacheLookup private WebElement btnregister;
	
	@FindBy(xpath="//p[@class='error']") 
	@CacheLookup private WebElement pleaseEnterAUsernameAndPa;
	
	
	
	@FindBy(css="div[id='leftPanel'] h2") 
	@CacheLookup private WebElement customerLogin;
	
	//Return
	public WebElement getparaBank() {
		return paraBank;
	}
	
	public WebElement getusername() {
		return username;
	}
	
	public WebElement getpassword() {
		return password;
	}
	
	public WebElement getlogIn() {
		return logIn;
	}
	
	public WebElement getRegister() {
		return btnregister;
	}
	
	public WebElement getpleaseEnterAUsernameAndPa() {
		return pleaseEnterAUsernameAndPa;
	}
	
	public WebElement getcustomerLogin() {
		return customerLogin;
	}
	
	//Actions
	public boolean isDisplayed() {
		return paraBank.isDisplayed();
		
	}
	
	public void sendusername(String Username){
		username.sendKeys(Username);
	}
	
	public void sendpassword(String Password){
		password.sendKeys(Password);
	}
	
	public void clickOnlogIn() {
		logIn.click();
	}
	
	public void clickOnRegister() {
		btnregister.click();
	}
	
	public String pleaseEnterAUsernameAndPa() {
		return pleaseEnterAUsernameAndPa.getText();
	}
	
	public boolean isDisplayedLogin() {
		return logIn.isDisplayed();
	}
	
	public boolean isDisplayedcustomerLogin() {
		return customerLogin.isDisplayed();
	}
	

}