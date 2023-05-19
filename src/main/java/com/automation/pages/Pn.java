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

public class Pn {
	AppiumDriver<MobileElement> driver;
	
    public Pn(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	 
//    @AndroidFindBy (accessibility  = "")
//	private MobileElement  ;
//    
//    @AndroidFindBy (accessibility  = "")
//	private MobileElement  ;
//  
//    @AndroidFindBy (accessibility  = "")
//	private MobileElement  ;
//    
//    @AndroidFindBy (accessibility  = "")
//	private MobileElement  ;
//    
//    @AndroidFindBy (accessibility  = "")
//	private MobileElement  ;
//  
//    @AndroidFindBy (accessibility  = "")
//	private MobileElement  ;
//    
//    @AndroidFindBy (accessibility  = "")
//	private MobileElement  ;
//    
//
//    public boolean isdisplay() {
//  	  return RegisterTitle.isDisplayed();
//     } 
//    
//   public void fullfillregisterBtn(String email, String name,String phone, String password) {
//	   email_input.sendKeys(email);
//	   name_input.sendKeys(name);
//	   phone_input.sendKeys(phone);
//	   password_input.sendKeys(password);
//	   registerBtn.click();
//   }
//   
//   public void click_backToLoginBtn() {
//	   backToLoginBtn.click();
//   }
//    
//   public boolean ErrorMessage_isdisplay() {
//	   return Error_msg.isDisplayed();
//   } 
}
	

