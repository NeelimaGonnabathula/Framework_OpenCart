package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {

	public WebDriver driver;
	public Logger logger;    //logging
	
	
	public ResourceBundle rb;    //config file
	
	
	@BeforeClass(groups= {"Master", "Regression","Sanity"})
	@Parameters("browser")
	public void setup(String br)
	{
		
		rb=ResourceBundle.getBundle("config");
		
		logger = LogManager.getLogger(this.getClass());   //logging
		
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});

		//WebDriverManager.chromedriver().setup();     not required for latest versions
		//	driver = new ChromeDriver(options);
		
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else
		{
			driver = new ChromeDriver();
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master", "Regression","Sanity"})
	public void teardown()
	{
		driver.quit();
	}
	
	//user defined java methods  //java - lang dependency
	
	public String randomstring()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return(generatedString);
	}
	
	public String randomNumber()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return(generatedString2);
	}
	
	public String randomAlphaNumeric()
	{
		String st = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return(st+"@"+num); //alphanumberic with special character
	}
	
	public String captureScreen(String tname) throws IOException {
		
		/*SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt = new Date();
		String timestamp = df.format(dt);*/
		
		//converted above 3 statements into a single statement as below
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //creating a timestamp for screenshot
		
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE); //takes screenshot
		String destination = System.getProperty("user.dir")+ "\\screenshots\\"+ tname + "_" +  timeStamp + ".png";
				// saves screenshot in above path
		try {
			FileUtils.copyFile(source, new File(destination));   //copy the file to destination
		}
		catch(Exception e)        // still have error the get the error message
		{
			e.getMessage();
		}
		return destination;
	}
	
}
