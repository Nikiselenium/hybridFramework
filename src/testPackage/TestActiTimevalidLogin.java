package testPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.Basetest;
import generic.CustomListner;
import generic.Flib;
import generic.WebdriverCommonLib;
import pagepackage.LoginPage;

@Listeners(CustomListner.class)


public class TestActiTimevalidLogin extends Basetest{
	

	
	
	@Test
	public void actTimevalidLoginTest() throws IOException, InterruptedException
	{
		Flib flib = new Flib();
		String username = flib.readPropertyData(PROP_PATH, "un");
		String password = flib.readPropertyData(PROP_PATH, "pwd");
		LoginPage lp = new LoginPage(driver);
		lp.validLoginActitime(username, password);
		
		WebdriverCommonLib wb = new WebdriverCommonLib();
		wb.waitForPageLoad(30, "Enter123");
		String homePagetitle = wb.getTitleOfTheWebPage();
		Assert.assertEquals(homePagetitle, "actiTIME - Enter Time-Track");
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
