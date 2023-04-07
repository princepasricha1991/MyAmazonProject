/**
 * 
 */
package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pages.AddedToCartPage;
import com.amazon.pages.CartWithAllItemsPage;
import com.amazon.pages.IndexPage;
import com.amazon.pages.ProductInfoPage;
import com.amazon.pages.SearchResultPage;

/**
 * @author Prince Pasricha
 *
 */
public class CartWithAllItemsPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	ProductInfoPage productInfoPage;
	AddedToCartPage addedToCartPage;
	CartWithAllItemsPage cartWithAllItemsPage;
	
	
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void initialSetup() {
		launchBrowser();
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void closeBrowser() {
		driver.quit();
	}
	

	@Test(groups = {"Regression"})
	public void verifyCorrectSubtoal() {	
		String search ="pixel";
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(search);
		productInfoPage = searchResultPage.selectProduct();
		productInfoPage.changeQuantity("2");
		addedToCartPage = productInfoPage.addToCart();
		cartWithAllItemsPage = addedToCartPage.clickOnGoToCartPage();
		double unitprice =  cartWithAllItemsPage.getUnitPrice();
		System.out.println("Unit price is:" +unitprice);
		double subToatl =cartWithAllItemsPage.getTotalPrice();
		System.out.println("subttotal:" +subToatl);
					
	}

}
