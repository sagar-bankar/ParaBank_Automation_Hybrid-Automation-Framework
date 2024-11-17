package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAccountPage {
	
	WebDriver driver;
	public LoginAccountPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//p[contains(text(),'Your account was created successfully. You are now')]") 
	@CacheLookup private WebElement yourAccountWasCreatedSucce;
	
	//Return Webelement
	
	public WebElement getyourAccountWasCreatedSucce() {
		return yourAccountWasCreatedSucce;
	}
	
	
	
	
	
	//Actions

	public String isDisplayedyourAccountWasCreatedSucce() {
		return yourAccountWasCreatedSucce.getText();
	}
	
	
}