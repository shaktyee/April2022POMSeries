package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. OR
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	
	private By subscribeYes = By.xpath("//input[@type='radio' and @value = '1' and @name = 'newsletter']");
	private By subscribeNo = By.xpath("//input[@type='radio' and @value = '0' and @name = 'newsletter']");
//	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[1]/input[@type = 'radio']");
//	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[2]/input[@type = 'radio']");
	
	private By agreeCheckBox = By.xpath("//input[@type='checkbox' and @name = 'agree']");
//	private By agreeCheckBox = By.name("agree");
	private By conitnueButton = By.xpath("//input[@type='submit' and @class = 'btn btn-primary']");
//	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMsg = By.cssSelector("div#content h1");
	
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
			
	
	//2. const
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	//3. page actions
	public boolean userRegistration(String firstName, String lastName, String email, String phone,
			String password, String subscribe) {
		eleUtil.doSendKeysWithWait(this.firstName, AppConstants.MEDIUM_DEFAULT_TIME_OUT, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(telephone, phone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(confirmPassword, password);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		}else {
			eleUtil.doClick(subscribeNo);
		}
		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(conitnueButton);
		
		String actSuccessMsg = 
				eleUtil.waitForElementVisible(successMsg, AppConstants.MEDIUM_DEFAULT_TIME_OUT).getText();
		System.out.println("--------------User Reg success Message------------"+ actSuccessMsg);
		if(actSuccessMsg.contains(AppConstants.REGISTER_SUCCESS_MSG)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void goToRegisterPage() {
		eleUtil.doClick(logoutLink);
		eleUtil.doClick(registerLink);		
	}
	
}
