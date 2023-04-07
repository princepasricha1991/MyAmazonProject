package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.actiondriver.Action;
import com.amazon.base.BaseClass;

public class LoginPasswordPage extends BaseClass{
	
	Action action = new Action();
	@FindBy(id = "ap_password")
	WebElement passwordField;
	
	@FindBy(id = "signInSubmit")
	WebElement signInBtn;
	
	@FindBy(name = "rememberMe")
	WebElement rememberMeBox;
	
	public LoginPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailOrMobile(String password) {
		action.type(passwordField, password);
	}
	public LoginPage clickOnSignIn() {
		action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public LoginPage signIn(String password) {
		action.type(passwordField, password);
		action.click(driver, signInBtn);
		return new LoginPage();
	}
	
}
