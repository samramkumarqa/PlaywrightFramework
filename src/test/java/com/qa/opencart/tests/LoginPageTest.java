package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.AppConstants.AppConstants;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void loginPageNavigationTest() {
		loginPage = homepage.navigateToLoginPage();
		String actLoginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("page act title: "+ actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExists());
	}
	
	@Test(priority=3)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), 
				prop.getProperty("password").trim()));	
		}
}
