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
public class CreateNewAccPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//h1[contains(text(),'Create account')]")
	WebElement createAccountFormTitle;
	
	@FindBy(id = "ap_customer_name")
	WebElement yourNameField;
	
	@FindBy(xpath = "//*[contains(text(),'Enter your name')]")
	WebElement yourNameFieldErrMsg;
	
	@FindBy(id = "ap_email")
	WebElement mobileNoOrEmailField;
	
	@FindBy(id = "ap_password")
	WebElement passwordField;
	
	@FindBy(id = "ap_password_check")
	WebElement passwordAgainField;
	
	@FindBy(id = "continue")
	WebElement continueBtn;
	
	public CreateNewAccPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreatePage() {
		return action.isDisplayed(driver, createAccountFormTitle);
	}
	
	public void createAccountInfo(String name, String emailOrPhoneNo, String pwd, String pwdAgain) {
		
		action.type(yourNameField, name);
		action.type(mobileNoOrEmailField, emailOrPhoneNo);
		action.type(passwordField, pwd);
		action.type(passwordAgainField, pwdAgain);
		action.click(driver, continueBtn);
		
	}
	

}
