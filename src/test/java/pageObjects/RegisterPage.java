package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		//this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='customer.firstName']") 
	@CacheLookup private WebElement firstName;
	
	@FindBy(xpath="//input[@id='customer.lastName']") 
	@CacheLookup private WebElement lastName;
	
	@FindBy(xpath="//input[@id='customer.address.street']") 
	@CacheLookup private WebElement addressstreet;
	
	@FindBy(xpath="//input[@id='customer.address.city']") 
	@CacheLookup private WebElement addresscity;
	
	@FindBy(xpath="//input[@id='customer.address.state']") 
	@CacheLookup private WebElement addressstate;
	
	@FindBy(xpath="//input[@id='customer.address.zipCode']") 
	@CacheLookup private WebElement addresszipCode;
	
	@FindBy(xpath="//input[@id='customer.phoneNumber']") 
	@CacheLookup private WebElement phoneNumber;
	
	@FindBy(xpath="//input[@id='customer.ssn']") 
	@CacheLookup private WebElement customerssn;
	
	@FindBy(xpath="//input[@id='customer.username']") 
	@CacheLookup private WebElement username;
	
	@FindBy(xpath="//input[@id='customer.password']") 
	@CacheLookup private WebElement password;
	
	@FindBy(xpath="//input[@id='repeatedPassword']") 
	@CacheLookup private WebElement repeatedPassword;
	
	@FindBy(xpath="//input[@value='Register']") 
	@CacheLookup private WebElement register;
	
	//Return Webelement
	
	public WebElement getFirstName() {
		return firstName;
	}
	
	public WebElement getLastName() {
		return lastName;
	}
	
	public WebElement getaddressstreet() {
		return addressstreet;
	}
	
	public WebElement getaddresscity() {
		return addresscity;
	}
	
	public WebElement getaddressstate() {
		return addressstate;
	}
	
	public WebElement getaddresszipCode() {
		return addresszipCode;
	}
	
	public WebElement getphoneNumber() {
		return phoneNumber;
	}
	
	public WebElement getcustomerssn() {
		return customerssn;
	}
	
	public WebElement getUserName() {
		return username;
	}
	
	public WebElement getPasswordName() {
		return password;
	}
	
	public WebElement getRepeatPasswordName() {
		return repeatedPassword;
	}
	
	public WebElement getRegister() {
		return register;
	}
	
	
	
	//Actions

	public void sendFirstName(String Fname) {
		firstName.sendKeys(Fname);
	}
	
	public void sendLasttName(String Lname) {
		lastName.sendKeys(Lname);
	}
	
	public void sendAddressstreet(String Addressstreet) {
		addressstreet.sendKeys(Addressstreet);
	}
	
	public void sendaddresscity(String Addresscity) {
		addresscity.sendKeys(Addresscity);
	}
	
	public void sendaddressstate(String Addressstate) {
		addressstate.sendKeys(Addressstate);
	}
	
	public void sendAddresszipCode(String AddresszipCode) {
		addresszipCode.sendKeys(AddresszipCode);
	}
	
	public void sendphoneNumber(String PhoneNumber) {
		phoneNumber.sendKeys(PhoneNumber);
	}
	
	public void sendcustomerssn(String Customerssn) {
		customerssn.sendKeys(Customerssn);
	}
	
	
	
	public void sendUserName(String Uname) {
		username.sendKeys(Uname);
	}
	
	public void sendPasswordName(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void sendRepeatPasswordName(String Rpwd) {
		repeatedPassword.sendKeys(Rpwd);
	}
	
	public void clickOnNewUserRegister() {
		register.click();
	}
}