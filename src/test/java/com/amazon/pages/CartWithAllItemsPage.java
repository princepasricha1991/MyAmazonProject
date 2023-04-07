package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class CartWithAllItemsPage extends BaseClass{
	
	Action action = new Action();

	@FindBy(xpath = "//span[@id='a-autoid-5-announce']")
	WebElement quantityBtn;
				
	@FindBy(xpath = "//div[@id='a-page']//form[1]//p[1]/span[1]")
	WebElement unitPrice;
	
	@FindBy(xpath = "//*[@id='sc-subtotal-amount-activecart']//span")
	WebElement subtotal;
	
	public CartWithAllItemsPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public double getUnitPrice() {
		
		String unitPrice1 = unitPrice.getText();		
		String unit = unitPrice1.replaceAll("[^A-Za-z0-9]",""); 		
		Double finalUnitPrice = Double.parseDouble(unit); 
		return finalUnitPrice/100;
		 
	}
	

public double getTotalPrice() {
		
		String subTotalPrice1 = subtotal.getText();
		String unit = subTotalPrice1.replaceAll("[^A-Za-z0-9]","");
		Double finalPrice = Double.parseDouble(unit);
		return finalPrice/100;
	}
	
	
}
