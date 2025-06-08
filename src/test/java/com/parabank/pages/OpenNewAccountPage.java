package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage {

	private static int TIMEOUT = 10;

	public OpenNewAccountPage(WebDriver driver) {

		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	// Locators
	@FindBy(xpath="//select[@id='type']") 
	 private WebElement typeOfAccount;
	
	@FindBy(xpath="//select[@id='fromAccountId']")  
	private WebElement accountID;
	
	@FindBy(xpath="//input[@value='Open New Account']") 
	private WebElement btnOpenNewAccount;

	// Returns
	// Actions
	public void selectAccountType(String accoutType) {
		Select select=new Select(typeOfAccount);
		select.selectByVisibleText(accoutType.toUpperCase());
	}
	
	public void selectAccountid(String ID) {
		Select select=new Select(accountID);
		select.selectByVisibleText(ID);
		
	}
	
	public void clickonbtnOpenNewAccount() {
		btnOpenNewAccount.click();
	}

}
