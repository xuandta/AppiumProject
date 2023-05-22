package com.automation.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.automation.library.MyActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P5_Cart extends MyActions {
	AndroidDriver<MobileElement> driver;

	public P5_Cart(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "cartHeader")
	private MobileElement cartHeader;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"productName\"])")
	private List<MobileElement> productName;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"productPrice\"])")
	private List<MobileElement> productPrice;

	@AndroidFindBy(accessibility = "cartTotalPrice")
	private MobileElement cartTotalPrice;

	@AndroidFindBy(accessibility = "clearCartBtn")
	private MobileElement clearCartBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[2]//android.view.ViewGroup[2]/android.widget.TextView[text(),\"Login\"]")
	private MobileElement LoginBtn;

	@AndroidFindBy(accessibility = "checkoutBtn")
	private MobileElement checkoutBtn;

	public void isDisplayed() {
		A_Assert_isDisplayed(cartHeader,"cartHeader");
	}

	public void checkout_isDisplayed() {
		A_Assert_isDisplayed(checkoutBtn,"checkoutBtn");
	}

	public void LoginBtn_isdisplay() {
		A_Assert_isDisplayed(LoginBtn,"LoginBtn");
	}

	public String getproductName1() {
		return A_WaitVisiable(productName.get(0)).getText();
	}

	public int getproductPrice1() {
		return Integer.parseInt((productPrice.get(0).getText().replaceAll("[\\$ ]", "")));
	}

	public void Click_clearCartBtn() {
		A_Click(clearCartBtn,"clearCartBtn");	
	}

	public void Click_checkoutBtn() {
		A_Click(checkoutBtn,"checkoutBtn");
	}

}
