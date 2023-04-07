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
public class LoginEmailMobileNoPage extends BaseClass {
	
	Action action = new Action();
	@FindBy(id = "ap_email")
	WebElement emailMobileNoBox;
	
	@FindBy(id = "continue")
	WebElement continueBtn;
	
	@FindBy(id = "createAccountSubmit")
	WebElement createNewAccBtn;
	
	
	public LoginEmailMobileNoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPasswordPage signInId(String signInid)
	{
		action.type(emailMobileNoBox, signInid);
		action.click(driver, continueBtn);
		return new LoginPasswordPage();
	}
	
	public CreateNewAccPage createNewAccount() {
		action.click(driver, createNewAccBtn);
		return new CreateNewAccPage();
	}
	

}
