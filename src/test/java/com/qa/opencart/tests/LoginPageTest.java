package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic - 100: Design the Login Page feature for open cart application")
@Story("US-101: Design Login Page feature with login, forgot password, title, URL")
public class LoginPageTest extends BaseTest{
	
	@Test
	@Description("Login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageTitleTest() {
		String actTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test
	public void loginPageUrlTest() {
		String actUrl = loginpage.getLoginPageUrl();
		
		Assert.assertEquals(actUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION),true);
	}
	
	@Test
	public void forgotPwdExistTest() {
		Assert.assertEquals(loginpage.isForgotPwdLinkExist(),true);
	}
	
	@Test
	public void loginTest() {
		accPage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountsPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}
}
