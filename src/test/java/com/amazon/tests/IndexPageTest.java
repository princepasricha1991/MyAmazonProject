/**
 * 
 */
package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pages.IndexPage;

/**
 * @author Prince Pasricha
 *
 */
public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	public IndexPageTest() {
		super();
	}

	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void initialSetup() {
		launchBrowser();
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(groups = { "Sanity"})
	public void searchboxWithoutSignIn() {
		indexPage = new IndexPage();
		boolean result = indexPage.verifySearchField();
		Assert.assertTrue(result);
		
	}
	
	
	
}
