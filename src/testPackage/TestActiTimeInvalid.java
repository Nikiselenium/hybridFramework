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

@Listeners(CustomListner.class)

public class TestActiTimeInvalid extends Basetest {

	
	@Test
	public void actTimeInvalidLoginTest() throws IOException
	{
		//object creations
				Flib flib = new Flib();
				LoginPage lp = new LoginPage(driver);
				 WebdriverCommonLib wb = new WebdriverCommonLib();

				//get the row count to itterate the for loop for those many rows
				int rc = flib.getrowCount(EXCEL_PATH, "InvalidCredentials");
				for(int i=1;i<=rc;i++)
				{
					String username = flib.readExcel(EXCEL_PATH, "InvalidCredentials", i, 0);
					String password = flib.readExcel(EXCEL_PATH, "InvalidCredentials", i, 1);
					lp.InvalidLoginActiTime(username, password);//login to the application

					WebElement errmsg = lp.getErrMsg();//get the errormsg WebElement
					wb.waitForElement(20);//implicitely wait
					wb.waitForWebELement(30, "invalid", errmsg,"error message");




			
		}
		
	
	}

}