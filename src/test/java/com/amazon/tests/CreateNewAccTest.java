package com.amazon.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.base.BaseClass;
import com.amazon.pages.CreateNewAccPage;
import com.amazon.pages.IndexPage;
import com.amazon.pages.LoginEmailMobileNoPage;

import com.amazon.utility.ExcelSheet;

public class CreateNewAccTest extends BaseClass {
	IndexPage indexPage;
	LoginEmailMobileNoPage loginIdPage;
	CreateNewAccPage createNewAcc;
	
	
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void initialSetup() {
		launchBrowser();
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void closeBrowser() {
		driver.quit();
	}
	@Test(groups = { "Regression"})
	public void verifyCreateAccPageTest() {
		indexPage = new IndexPage();
		loginIdPage = indexPage.clickOnSignIn();
		createNewAcc = loginIdPage.createNewAccount();
		boolean result = createNewAcc.validateAccountCreatePage();
	    Assert.assertTrue(result);
		
	}
	@DataProvider
	public Object[][] Details(){
		Object result[][] = ExcelSheet.readData("Sheet1");
		return result;
	}
	
	@Test(dataProvider = "Details", groups = { "Regression"} )
	public void verifyEmptyNameTest(String name, String id, String pwd, String pwdAgn) {
		indexPage = new IndexPage();
		loginIdPage = indexPage.clickOnSignIn();
		createNewAcc = loginIdPage.createNewAccount();
		createNewAcc.createAccountInfo(name, id, pwd, pwdAgn);
		Boolean result = driver.findElement(By.xpath("//*[contains(text(),'Enter your name')]")).isDisplayed();
		Assert.assertTrue(result);
	}
	
	@Test(groups = {"Sanity"})
	public void verifyEmptyPhoneNoTest() {
		indexPage = new IndexPage();
		loginIdPage = indexPage.clickOnSignIn();
		createNewAcc = loginIdPage.createNewAccount();
		createNewAcc.createAccountInfo("jim","", "qwerty", "qwerty");
		Boolean result = driver.findElement(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")).isDisplayed();
		Assert.assertTrue(result);
	}
	
	@Test(groups = {"Regression"})
	public void verifyEmptyPwdTest() {
		indexPage = new IndexPage();
		loginIdPage = indexPage.clickOnSignIn();
		createNewAcc = loginIdPage.createNewAccount();
		createNewAcc.createAccountInfo("jim","1234567890", "", "qwerty");
		Boolean result = driver.findElement(By.xpath("//div[@id='auth-password-missing-alert']/div[1]/div[1]")).isDisplayed();
		Assert.assertTrue(result);
	}
	
	@Test(groups = {"Smoke"})
	public void verifyEmptyPwdAgainTest() {
		indexPage = new IndexPage();
		loginIdPage = indexPage.clickOnSignIn();
		createNewAcc = loginIdPage.createNewAccount();
		createNewAcc.createAccountInfo("jim","1234567890", "qwerty", "");
		Boolean result = driver.findElement(By.xpath("//div[contains(text(),'Type your password again')]")).isDisplayed();
		Assert.assertTrue(result);
	}
	
	@Test(groups = {"Regression"})
	public void verifyPwdAndPwdAgainTest() {
		indexPage = new IndexPage();
		loginIdPage = indexPage.clickOnSignIn();
		createNewAcc = loginIdPage.createNewAccount();
		createNewAcc.createAccountInfo("jim","1234567890", "qwerty", "qwert");
		Boolean result = driver.findElement(By.xpath("//div[contains(text(),'Passwords do not match')]")).isDisplayed();
		Assert.assertTrue(result);
	}
	
	
	

}
