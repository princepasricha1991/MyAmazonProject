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
public class SearchResultPage extends BaseClass{
	
	Action action = new Action();
	@FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
	WebElement searchResultText;
	
	@FindBy(xpath = "//span[contains(text(),'Pixel 6a Cell Phone - Charcoal')]"  )
	WebElement productSelection;
	

	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductInfoPage selectProduct() {
		action.click(driver, productSelection);
		return new ProductInfoPage();
	}
	
	public String searchProductIs() {	
		return searchResultText.getText();
	}
	
	
	
	

}
