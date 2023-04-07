/**
 * 
 */
package com.amazon.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pages.IndexPage;
import com.amazon.pages.LoginEmailMobileNoPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.LoginPasswordPage;


/**
 * @author Prince Pasricha
 *
 */
public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage ;
	LoginEmailMobileNoPage loginIdPage ;
	LoginPasswordPage pwdPage ; 
	LoginPage loginPage ;
	
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void initialSetup() {
		launchBrowser();
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(groups = {"Sanity"})
	public void loginTest() {
		indexPage = new IndexPage();
		loginIdPage = indexPage.clickOnSignIn();
		pwdPage = loginIdPage.signInId(prop.getProperty("username"));
		loginPage = pwdPage.signIn("password");
		loginPage.helloUserMsg();
		
		
	}
	
	

}
