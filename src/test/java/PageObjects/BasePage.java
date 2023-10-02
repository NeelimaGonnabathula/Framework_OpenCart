package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//this basepage constructor is used in all pageobjects

public class BasePage {

		WebDriver driver;

		public BasePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
}
