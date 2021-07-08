package testPackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.Basetest;
import generic.CustomListner;
import generic.Flib;
import generic.WebdriverCommonLib;
import pagepackage.LoginPage;
import pagepackage.Settings;

@Listeners(CustomListner.class)

public class TestActitimeropdowns extends Basetest {


	@Test

	public void getTheOptionsOfFirstDropdown() throws IOException, InterruptedException

	{
		Flib flib = new Flib();
		String username = flib.readPropertyData(PROP_PATH, "un");
		String password = flib.readPropertyData(PROP_PATH, "pwd");


		LoginPage lp = new LoginPage(driver);
		lp.validLoginActitime(username, password);

		//to avoid synchronisation issue we are using explicitly wait
		WebdriverCommonLib wb = new WebdriverCommonLib();
		wb.waitForPageLoad(30, "Enter");

		//to click on settings
		Settings sp = new Settings(driver);
		sp.clickSettings();
		//to get all the options of first dropdown 

		WebElement firstDropdown = sp.getDropdown1();
		wb.getOptionOfDropdown(firstDropdown);

	}


	@Test

	public void getTheOptionsOfSecondDropdown() throws IOException, InterruptedException

	{
		Flib flib = new Flib();
		String username = flib.readPropertyData(PROP_PATH, "un");
		String password = flib.readPropertyData(PROP_PATH, "pwd");


		LoginPage lp = new LoginPage(driver);
		lp.validLoginActitime(username, password);
		//to avoid synchronisation issue we are using explicitly wait
		WebdriverCommonLib wb = new WebdriverCommonLib();
		wb.waitForPageLoad(30, "Enter");
		//to click on settings
		Settings sp = new Settings(driver);
		sp.clickSettings();

		//to get all the options of second dropdown 
		WebElement secondDropdown = sp.getDropdown2();
		wb.getOptionOfDropdown(secondDropdown);

	}

	@Test

	public void getTheOptionsOfThirdDropdown() throws IOException, InterruptedException

	{
		Flib flib = new Flib();
		String username = flib.readPropertyData(PROP_PATH, "un");
		String password = flib.readPropertyData(PROP_PATH, "pwd");


		LoginPage lp = new LoginPage(driver);
		lp.validLoginActitime(username, password);
		//to avoid synchronisation issue we are using explicitly wait
		WebdriverCommonLib wb = new WebdriverCommonLib();
		wb.waitForPageLoad(30, "Enter");
		//to click on settings
		Settings sp = new Settings(driver);
		sp.clickSettings();
		//to get all the options of third dropdown 

		WebElement thirdDropdown = sp.getDropdown3();
		wb.getOptionOfDropdown(thirdDropdown);

	}





}
