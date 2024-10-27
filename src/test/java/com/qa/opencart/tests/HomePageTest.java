package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.AppConstants.AppConstants;
import com.qa.opencart.base.BaseTest;

public class HomePageTest extends BaseTest{
	
	

	
	
	@Test
	public void homePageTitleTest() {
		String actualTitle = homepage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageURLTest() {
		String actualURL = homepage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Macbook"},
			{"imac"},
			{"Samsung"}
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) {
		String actualSearchHeader = homepage.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search - "+productName);
	}
	
	
}
