package com.automation.pages;

import java.util.List;
import org.openqa.selenium.support.PageFactory;

import com.automation.library.MyActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class P6_Checkout extends MyActions {
	AndroidDriver<MobileElement> driver;

	public P6_Checkout(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text=\"Checkout\"]")
	private MobileElement Checkout_Title1;

	@AndroidFindBy(accessibility = "phoneNum")
	private MobileElement phoneNum;

	@AndroidFindBy(accessibility = "shippingAdd1")
	private MobileElement shippingAdd1;

	@AndroidFindBy(accessibility = "shippingAdd2")
	private MobileElement shippingAdd2;

	@AndroidFindBy(accessibility = "shippingCity")
	private MobileElement shippingCity;

	@AndroidFindBy(accessibility = "shippingZIPCode")
	private MobileElement shippingZIPCode;

	@AndroidFindBy(accessibility = "selectCountryTrigger")
	private MobileElement selectCountryTrigger;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
	private List<MobileElement> List_select;

	@AndroidFindBy(accessibility = "confirmShippingFormBtn")
	private MobileElement confirmShippingFormBtn;

	public boolean isdisplay() {
		return A_WaitVisiable(Checkout_Title1).isDisplayed();
	}

	public void fullfillregisterBtn(AndroidDriver<MobileElement> driver, String phoneNum1, String shippingAdd11, String shippingAdd21,
			String shippingCity1, String shippingZIPCode1, String country) {
		A_Senkey(phoneNum, phoneNum1);
		A_Senkey(shippingAdd1, shippingAdd11);
		A_Senkey(shippingAdd2, shippingAdd21);
		A_swipe(driver, 50, 50, 80, 40);
		A_Senkey(shippingCity, shippingCity1);
		A_Senkey(shippingZIPCode, shippingZIPCode1);
		A_swipe(driver, 50, 50, 80, 50);
		A_Click(selectCountryTrigger);
		A_ScrollToText(country);
		A_Click(confirmShippingFormBtn);
	}

// ******************************************** Payment 

	@AndroidFindBy(accessibility = "paymentTabHeader")
	private MobileElement paymentTabHeader;

	@AndroidFindBy(accessibility = "Cash on Delivery")
	private MobileElement Cash_on_Delivery;

	@AndroidFindBy(accessibility = "Bank Transfer")
	private MobileElement Bank_Transfer;

	@AndroidFindBy(accessibility = "Card Payment")
	private MobileElement Card_Payment;

	@AndroidFindBy(accessibility = "android:id/text1")
	private MobileElement Wallet;

	@AndroidFindBy(accessibility = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView")
	private List<MobileElement> List_wallet;

	@AndroidFindBy(accessibility = "confirmBtn")
	private MobileElement confirmBtn;

	public boolean Payment_isdisplay() {
		return A_WaitVisiable(paymentTabHeader).isDisplayed();
	}

	public void Bank_Transfer() {
		A_Click(Bank_Transfer);
	}

	public void Card_Payment() {
		A_Click(Card_Payment);
	}

	public void Click_Cash_on_Delivery() {
		A_Click(Cash_on_Delivery);
	}

	public void Click_confirmBtn() {
		A_Click(confirmBtn);
	}

	// ******************** Confirm order
	@AndroidFindBy(accessibility = "confirmTabHeader")
	private MobileElement confirmTabHeader;

	@AndroidFindBy(accessibility = "confirmShippingAdd1")
	private MobileElement confirmShippingAdd1;

	@AndroidFindBy(accessibility = "confirmShippingAdd2")
	private MobileElement confirmShippingAdd2;

	@AndroidFindBy(accessibility = "confirmCity")
	private MobileElement confirmCity;

	@AndroidFindBy(accessibility = "confirmZIPCode")
	private MobileElement confirmZIPCode;

	@AndroidFindBy(accessibility = "confirmCountry")
	private MobileElement confirmCountry;

	@AndroidFindBy(accessibility = "itemName")
	private MobileElement itemName;

	@AndroidFindBy(accessibility = "itemPrice")
	private MobileElement itemPrice;

	@AndroidFindBy(accessibility = "placeOrderBtn")
	private MobileElement placeOrderBtn;

	public boolean isdisplay_confirmTabHeader() {
		return A_WaitVisiable(confirmTabHeader).isDisplayed();
	}

	public String getconfirmShippingAdd1() {
		return A_WaitVisiable(confirmShippingAdd1).getText();
	}

	public String getconfirmShippingAdd2() {
		return A_WaitVisiable(confirmShippingAdd2).getText();
	}

	public String getconfirmCity() {
		return A_WaitVisiable(confirmCity).getText();
	}

	public String getitemName() {
		return A_WaitVisiable(itemName).getText();
	}

	public String getconfirmZIPCode() {
		return A_WaitVisiable(confirmZIPCode).getText();
	}

	public String getconfirmCountry() {
		return A_WaitVisiable(confirmCountry).getText();
	}

	public int getitemPrice() {
		return Integer.parseInt(A_WaitVisiable(itemPrice).getText().replaceAll("[\\$ ]", ""));
	}

	public void Click_placeOrderBtn() {
		A_Click(placeOrderBtn);
	}

	// ******************* Ordersuccess
	@AndroidFindBy(accessibility = "text1")
	private MobileElement text1;

	@AndroidFindBy(accessibility = "emptyCartSuggestionMsg")
	private MobileElement emptyCartSuggestionMsg;

	public boolean isOrdersuccess() {
		return A_WaitVisiable(emptyCartSuggestionMsg).isDisplayed();
	}
}
