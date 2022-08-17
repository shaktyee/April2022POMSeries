package com.qa.opencart.tests;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterTest extends BaseTest {
	
	@BeforeClass
	public void regSetup() {
		registerPage = loginpage.goToRegisterPage();
	}
	
	@Test(dataProvider = "getRegExcelData")
	public void userRegTest(String firstName, String lastName, String phone,
			String password, String subscribe) {
		boolean successFlag = registerPage.userRegistration(firstName, lastName, randomEmail(),phone,
				password, subscribe);
		registerPage.goToRegisterPage();
		Assert.assertTrue(successFlag);
	}
	
	public String randomEmail() {
		Random random = new Random();
		String email = "automation" + random.nextInt(1000) + "@gmail.com";
		return email;
	}

//	@DataProvider
//	public Object[][] getRegData() {
//		return new Object[][] {
//			{"Ciya", "Automation", "ciya1@test.com", "9999999999","test@123", "yes"},
//			{"Aiya", "Automation", "aiya1@test.com", "9999999999","test@123", "yes"},
//			{"Diya", "Automation", "diya1@test.com", "9999999999","test@123", "yes"}
//		};
//	}
	
	@DataProvider
	public Object[][] getRegExcelData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}
	
}
