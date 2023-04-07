package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class AddedToCartPage extends BaseClass {
	
	Action action = new Action();

	@FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
	WebElement addToCartMsg;
	
	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	WebElement proceedToChkoutBtn;
	
//	@FindBy(xpath = "//span[@id='sw-gtc']//a")
//	WebElement goToCartLin;

	@FindBy(id = "sw-gtc")
	WebElement goToCartLink;
	
	public AddedToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAddToCart() {
		return action.isDisplayed(driver, addToCartMsg);
	}
	
	public CheckoutPage clickProcdToChkOut() {
		action.click(driver, proceedToChkoutBtn);
		return new CheckoutPage();
	}
	
	public CartWithAllItemsPage clickOnGoToCartPage() {
		action.click(driver, goToCartLink);
		return new CartWithAllItemsPage();
	}
	
	
	
}
