package com.automation.pages;

import java.util.List;

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

public class P5_Cart extends MyActions{
	AppiumDriver<MobileElement> driver;
	
    public P5_Cart(AppiumDriver driver) {
    	super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	 
    @AndroidFindBy (accessibility  = "cartHeader")
	private MobileElement  cartHeader;
    
    @AndroidFindBy (xpath  = "(//android.widget.TextView[@content-desc=\"productName\"])")
	private List<MobileElement> productName  ;
    
    @AndroidFindBy (xpath  = "(//android.widget.TextView[@content-desc=\"productPrice\"])")
	private List<MobileElement> productPrice  ;
  
    @AndroidFindBy (accessibility  = "cartTotalPrice")
	private MobileElement cartTotalPrice ;
    
    @AndroidFindBy (accessibility  = "clearCartBtn")
	private MobileElement clearCartBtn ;
    
    @AndroidFindBy (xpath  = "//android.view.ViewGroup[2]//android.view.ViewGroup[2]/android.widget.TextView[text(),\"Login\"]")
	private MobileElement LoginBtn ;
  
    @AndroidFindBy (accessibility  = "checkoutBtn")
	private MobileElement  checkoutBtn;
    

    public boolean isdisplay() {
    	return A_WaitVisiable(cartHeader).isDisplayed();
     } 
    
    public boolean checkout_isdisplay() {
    	return A_WaitVisiable(checkoutBtn).isDisplayed();
    } 
    
    public boolean LoginBtn_isdisplay() {
    	return A_WaitVisiable(LoginBtn).isDisplayed();
    }
    
    public String getproductName1() {
 	   return A_WaitVisiable(productName.get(0)).getText();
    }
    
    public int getproductPrice1() {
 	   return Integer.parseInt((productPrice.get(0).getText().replaceAll("[\\$ ]", ""))) ;
    }    
    
    public void Click_clearCartBtn() {
		A_Click(clearCartBtn);
	}
    
    public void Click_checkoutBtn() {
		A_Click(checkoutBtn);
	}
   
}
	

