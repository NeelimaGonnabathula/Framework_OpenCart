package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	
	@FindBy(id= "input-firstname")
	WebElement txtFirstname;
	
	@FindBy(id= "input-lastname")
	WebElement txtLastname;
	
	@FindBy(id= "input-email")
	WebElement txtEmail;
	
	@FindBy(id= "input-password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-newsletter-no']")
	WebElement btnSubscribe;
	
	@FindBy(name= "agree")
	WebElement chkPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement ConfirmationMessage;
	
	//ActionMethods
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pswd)
	{
		txtPassword.sendKeys(pswd);
	}
	
	
	public void setSubscribe()
	{
		btnSubscribe.click();
	}
	
	public void setPrivacyPolicy()
	{
		txtPassword.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return(ConfirmationMessage.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
