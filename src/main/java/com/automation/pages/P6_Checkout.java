package com.automation.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.library.CaptureScreenshot;
import com.automation.library.MyActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.automation.library.*;

public class P6_Checkout extends MyActions{
	AppiumDriver<MobileElement> driver;
	
    public P6_Checkout(AppiumDriver driver) {
    	super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	 
    @AndroidFindBy (xpath  = "//android.view.ViewGroup[1]//android.view.ViewGroup[2]//android.view.ViewGroup[1]//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.View[text(),\"Checkout\"]")
	private MobileElement  Checkout_Title;
    
    @AndroidFindBy (accessibility  = "phoneNum")
	private MobileElement  phoneNum;
  
    @AndroidFindBy (accessibility  = "shippingAdd1")
	private MobileElement shippingAdd1 ;
    
    @AndroidFindBy (accessibility  = "shippingAdd2")
	private MobileElement shippingAdd2 ;
    
    @AndroidFindBy (accessibility  = "shippingCity")
	private MobileElement shippingCity ;
  
    @AndroidFindBy (accessibility  = "shippingZIPCode")
	private MobileElement shippingZIPCode ;
    
    @AndroidFindBy (accessibility  = "selectCountryTrigger")
	private MobileElement selectCountryTrigger ;
    
    @AndroidFindBy (xpath  = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
	private List<MobileElement> List_select ;
    
    @AndroidFindBy (accessibility  = "confirmShippingFormBtn")
	private MobileElement confirmShippingFormBtn ;

    public boolean isdisplay() {
  	  return A_WaitVisiable(Checkout_Title).isDisplayed();
     } 
    
   public void fullfillregisterBtn(String phoneNum1, String shippingAdd11,String shippingAdd21, String shippingCity1, String shippingZIPCode1, String password) {
	   A_WaitVisiable(phoneNum);
	   phoneNum.sendKeys(phoneNum1);
	   shippingAdd1.sendKeys(shippingAdd11);
	   shippingAdd2.sendKeys(shippingAdd21);
	   shippingCity.sendKeys(shippingCity1);
	   shippingZIPCode.sendKeys(shippingZIPCode1);
	   selectCountryTrigger.click();
	   List_select.get(new Random().nextInt(List_select.size())).click();
	   confirmShippingFormBtn.click();
   }
// ******************************************** Payment 

   @AndroidFindBy (accessibility  = "Cash on Delivery")
	private MobileElement Cash_on_Delivery ;
 
   @AndroidFindBy (accessibility  = "Bank Transfer")
	private MobileElement  Bank_Transfer;
   
   @AndroidFindBy (accessibility  = "Card Payment")
	private MobileElement  Card_Payment;
   
   @AndroidFindBy (accessibility  = "android:id/text1")
	private MobileElement Wallet ;
   
   @AndroidFindBy (accessibility  = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView")
	private List<MobileElement> List_wallet ;

   @AndroidFindBy (accessibility  = "confirmBtn")
	private MobileElement confirmBtn ;
   
   // ******************** Confirm
   @AndroidFindBy (accessibility  = "confirmTabHeader")
	private MobileElement confirmTabHeader ;
 
   @AndroidFindBy (accessibility  = "confirmShippingAdd1")
	private MobileElement confirmShippingAdd1 ;

   @AndroidFindBy (accessibility  = "confirmShippingAdd2")
	private MobileElement confirmShippingAdd2 ;
 
   @AndroidFindBy (accessibility  = "confirmCity")
	private MobileElement  confirmCity;
   
   @AndroidFindBy (accessibility  = "itemName")
	private MobileElement  itemName;
   
   @AndroidFindBy (accessibility  = "itemPrice")
	private MobileElement  itemPrice;
   
   @AndroidFindBy (accessibility  = "placeOrderBtn")
	private MobileElement  placeOrderBtn;
   
   
  //******************* Confirm
   @AndroidFindBy (accessibility  = "text1")
	private MobileElement  text1;
	

	@AndroidFindBy (accessibility  = "emptyCartSuggestionMsg" )
	private MobileElement  emptyCartSuggestionMsg;
	
}


