package com.automation.pages;

import org.openqa.selenium.support.PageFactory;

import com.automation.library.MyActions;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P2_Register extends MyActions {
	AndroidDriver<MobileElement> driver;

	public P2_Register(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ScrollView//android.widget.TextView[text(),\"Register\"]")
	private MobileElement RegisterTitle;

	@AndroidFindBy(accessibility = "email")
	private MobileElement email_input;

	@AndroidFindBy(accessibility = "name")
	private MobileElement name_input;

	@AndroidFindBy(accessibility = "phone")
	private MobileElement phone_input;

	@AndroidFindBy(accessibility = "password")
	private MobileElement password_input;

	@AndroidFindBy(accessibility = "registerBtn")
	private MobileElement registerBtn;

	@AndroidFindBy(accessibility = "backToLoginBtn")
	private MobileElement backToLoginBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"registerErrMsg\"]/android.widget.TextView")
	private MobileElement Error_msg;

	public boolean isdisplay() {
		return A_WaitVisiable(RegisterTitle).isDisplayed();
	}

	public void fullfillregisterBtn(AndroidDriver<MobileElement> driver, String email, String name, String phone,
			String password) {
		A_Senkey(email_input,"email_input", email);
		A_Senkey(name_input, "name_input",name);
		A_Senkey(phone_input,"phone_input", phone);
		A_Senkey(password_input,"password_input", password);
		A_swipe(driver, 50, 50, 70, 30);
		A_Click(registerBtn,"registerBtn");
	}

	public void click_backToLoginBtn() {
		A_Click(backToLoginBtn,"backToLoginBtn");
	}

	public boolean ErrorMessage_isdisplay() {
		return A_WaitVisiable(Error_msg).isDisplayed();
	}
}
