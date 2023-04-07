package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class IndexPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(id = "nav-link-accountList-nav-line-1" ) 
	WebElement signInBtn;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement searchBoxBtn;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	//user actions methods
	
	public LoginEmailMobileNoPage clickOnSignIn() {
		action.click(driver, signInBtn);
		return new LoginEmailMobileNoPage();
	}
	
	public SearchResultPage searchProduct(String productName) {
		action.type(searchBox, productName); 
		action.click(driver, searchBoxBtn); 
		return new SearchResultPage(); 
	}
		
	
	public boolean verifySearchField() {
		return action.isDisplayed(driver, searchBox);
	}
	
	
	

}
