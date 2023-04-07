package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pages.AddedToCartPage;
import com.amazon.pages.IndexPage;
import com.amazon.pages.ProductInfoPage;
import com.amazon.pages.SearchResultPage;
public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	ProductInfoPage productInfoPage;
	AddedToCartPage addedToCartPage;
	
	
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void initialSetup() {
		launchBrowser();
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(groups = {"Regression"})
	public void verifySearchResult() {	
		String search ="pixel";
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(search);
		String result = searchResultPage.searchProductIs();
		System.out.println("Result for :" +result);
		Assert.assertEquals("\"pixel\"", result);
	}
	

	@Test(groups = {"Regression"})
	public void verifyAddToCartTest() {	
		String search ="pixel";
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(search);
		productInfoPage = searchResultPage.selectProduct();
		addedToCartPage = productInfoPage.addToCart();
		boolean result = addedToCartPage.validateAddToCart();
		Assert.assertTrue(result);				
	}


}
