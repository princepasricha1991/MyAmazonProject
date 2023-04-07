package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class ProductInfoPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//select[@id='quantity']")
	WebElement quantity;
	
	public ProductInfoPage() {
		PageFactory.initElements(driver, this);
	}		
	
	public AddedToCartPage addToCart() {
		action.click(driver, addToCartButton);
		return new AddedToCartPage();
	}
	
	public void changeQuantity(String qty) {
		action.selectByValue(quantity, qty);		
	}

}
