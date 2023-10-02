package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass 
{

	@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class)
	public void test_loginDDT(	String email, String password, String exp)
	{		
		try
		{
			
			logger.info("**** Starting TC_003_LoginDDT ****");
			
			HomePage hp= new HomePage(driver);
			
			hp.clickMyAccount();
			hp.clickLogin();
				
			LoginPage lp= new LoginPage(driver);
			
			lp.setEmail(rb.getString(email));
			logger.info("provided email");
			lp.setPassword(rb.getString(password));    //valid email and password getting from config.properties file
			logger.info("provided password");
			lp.clickLogin();
			logger.info("clicked on login");
		
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();
			
			if(exp.equals("Valid"))
			{
				if(targetpage ==true)
				{
					macc.Logout();
					Assert.assertTrue(true);
				}
			
			else 
			{
				Assert.fail();
			}
				
			}
			
			if(exp.equals("Invalid"))
			{
				if(targetpage ==true)
				{
					macc.Logout();
					Assert.assertTrue(false);
				}
			
			else 
			{
				Assert.assertTrue(true);
			}
				
			}
		}
		
			catch(Exception e)
			{		
				Assert.fail();
			}
			
			logger.info("****completed TC_003_LoginDDT ****");
			
	}
	
}
