package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. By
	private By productCount = By.xpath("//div[@class='product-thumb']"); 
	
	//2. constructor
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. page actions
	public int getSearchProductCount() {
		return eleUtil.waitForElementsToBeVisible(productCount, AppConstants.MEDIUM_DEFAULT_TIME_OUT).size();
	}
	
	public ProductInfoPage selectProduct(String searchProductName) {
		By product = By.linkText(searchProductName);
		eleUtil.doClick(product);
		return new ProductInfoPage(driver);
	}

}
