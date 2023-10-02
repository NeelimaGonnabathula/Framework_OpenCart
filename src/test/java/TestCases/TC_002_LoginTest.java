package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity", "Master"})
	public void test_login()
	{
		try {
		logger.info("**** Starting T_002_LoginTest ****");
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));    //valid email and password getting from config.properties file
		lp.clickLogin();
		logger.info("clicked on login");
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
		logger.info("Assert message to check account page exists");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
