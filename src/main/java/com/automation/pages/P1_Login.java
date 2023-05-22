package com.automation.pages;

import org.openqa.selenium.support.PageFactory;

import com.automation.library.MyActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P1_Login extends MyActions {
	AndroidDriver<MobileElement> driver;

	public P1_Login(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1][text(),\"Login\"]")
	private MobileElement loginTitle;

	@AndroidFindBy(accessibility = "emailInput")
	private MobileElement emailInput;

	@AndroidFindBy(accessibility = "passwordInput")
	private MobileElement passwordInput;

	@AndroidFindBy(accessibility = "loginBtn")
	private MobileElement loginBtn;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2][text(),\"Don't have an account yet?\"]")
	private MobileElement Dont_have_an_account_yet;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")
	private MobileElement registerBtn;

	@AndroidFindBy(xpath = "//android.widget.ScrollView//android.widget.TextView[2][text(),\"Please fill in your credentials\"]")
	private MobileElement Error_msg;

	@AndroidFindBy(accessibility = "signOutBtn")
	private MobileElement signOutBtn;

	public void assert_isdisplay() {
		A_Assert_isDisplayed(loginTitle,"loginTitle");
	}

	public void assert_isLogIn() {
		A_Assert_isDisplayed(signOutBtn, "signOutBtn");
	}

	public void fullfillLogin(String email, String password) {
		A_Senkey(emailInput,"emailInput", email);
		A_Senkey(passwordInput,"passwordInput", password);
		A_Click(loginBtn,"loginBtn");
	}

	public void click_registerBtn() {
		A_Click(registerBtn,"registerBtn");
	}

	public void ErrorMessage_isdisplay() {
		A_Assert_isDisplayed(Error_msg,"Error_msg");
	}

}
