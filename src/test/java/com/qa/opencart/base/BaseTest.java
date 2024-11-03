package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	
	protected HomePage homepage;
	protected LoginPage loginPage;
	
	@BeforeTest
	//@Parameters({"browser"})
	public void setup() {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		
		/*if(browserName != null) {
			//the browser value in the config file will be updated by the browser value passed in the testng
			prop.setProperty("browser", browserName);
		}*/
		
		page = pf.initBrowser(prop);
		homepage = new HomePage(page);
		
	}

	@AfterTest
	public void tearDown() {
		//page.context().browser().close();
		System.out.println("THE END");
	}
}
