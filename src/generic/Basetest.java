package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class Basetest implements generic.IAutoConstant{

	protected static WebDriver driver;
	//@BeforeMethod annotation will always work before @Test
	@BeforeMethod

	public void setUp() throws IOException
	{
		//get the data such as browsername and url from property file

		Flib flib = new Flib();
		String browservalue = flib.readPropertyData(PROP_PATH, "browser");
		String baseurl = flib.readPropertyData(PROP_PATH, "url");
		//we are using RTP(Run Time Polymorphism to decide which browser we need to launch
		if(browservalue.equalsIgnoreCase("chrome"))
		{



			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseurl);
		}

		else if(browservalue.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseurl);

		}

		else
		{
			System.out.println("invalid input");
		}



	}

	//this method will be called once the @test gets failed and the screenshot will be taken with the method name which gets failed
	
	public void fail(String methodName)
		{
		//handled the exception with the help of try catch
			try
			{
				
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("./screenshots/"+methodName+".png");
				Files.copy(src, dest);
			}
			
			catch(Exception e)
			{
				
				//todo handle exception
			}

			
		}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}



