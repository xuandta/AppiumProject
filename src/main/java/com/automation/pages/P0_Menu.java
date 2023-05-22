package com.automation.pages;


import org.openqa.selenium.support.PageFactory;

import com.automation.library.Log;
import com.automation.library.MyActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P0_Menu extends MyActions {
	protected AndroidDriver<MobileElement> driver;

	public P0_Menu(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "homeIcon") 
	public MobileElement homeIcon;

	@AndroidFindBy(accessibility = "cartIcon")
	private MobileElement cartIcon;

	@AndroidFindBy(accessibility = "userIcon")
	public MobileElement userIcon;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"cartIcon\"]/android.view.ViewGroup/android.widget.TextView")
	private MobileElement cart_number;

	public void click_homeIcon() {
		A_Click(homeIcon,"homeIcon");
	}

	public void click_cartIcon() {
		A_Click(cartIcon,"cartIcon");
	}

	public void click_userIcon() {
		A_Click(userIcon,"userIcon");
	}

	public int getProductNumber() {
		return Integer.parseInt(A_WaitVisiable(cart_number).getText());
	}
}
