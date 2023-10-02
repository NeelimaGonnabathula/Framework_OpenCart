package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

 
	@Test(groups= {"Regression", "Master"})
	public void test_account_registration() throws InterruptedException
	{
		logger.info(" **** Starting TC_001_AccountRegistrationTest **** ");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount");
		
		hp.lnkRegister();
		logger.info("clicked on Registration");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName("neel");
		regPage.setLastName("gonna");
		regPage.setEmail(randomstring() + "@gmail.com");   //random email needs to be provided
		regPage.setPassword(randomNumber());
		logger.info("set password");
		regPage.setSubscribe();
		logger.info("clicked on Subscribe");
		regPage.setPrivacyPolicy();
		logger.info("clicked on setPrivacyPolicy");
		
		regPage.clickContinue();
		logger.info("clicked on continue");
		
		Thread.sleep(3000);
		String confirm = regPage.getConfirmationMsg();
		Assert.assertEquals(confirm, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.info("test failed");
			Assert.fail();
		}
		logger.info(" **** Completed TC_001_AccountRegistrationTest **** ");
		}
}
