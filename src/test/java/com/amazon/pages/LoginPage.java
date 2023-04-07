/**
 * 
 */
package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

/**
 * @author Prince Pasricha
 *
 */
public class LoginPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement serachBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement searchBoxBtn;
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement helloUsernameMsg;
	
	@FindBy(id = "nav-orders")
	WebElement returnsAndOrdersHistory;
	
	@FindBy(id = "nav-cart")
	WebElement cartBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isSearchBoxDisplayed() {
		return action.isDisplayed(driver, serachBox);
	}
	
	public void helloUserMsg() {
		String heloMsg = helloUsernameMsg.getText();
		System.out.println(heloMsg);
		//action.moveToElement(driver, helloUsernameMsg);
	
	}
	
	public boolean isOrderHistoryDisplayed() {
		return action.isDisplayed(driver, returnsAndOrdersHistory);
	}
	
	public SearchResultPage searchProduct(String productName) {
		action.type(serachBox, productName);
		action.click(driver, searchBoxBtn);
		//action.explicitWait(driver, cartBtn, 0);
		return new SearchResultPage();
	}
	
	
	
	
	
	
	
	
	

}
