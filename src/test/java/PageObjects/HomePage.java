package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage

{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}	
	
	//Elements
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']")
	WebElement lnkLogin;
	
	//ActionMethods
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void lnkRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
