package com.automation.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Pn {
	AppiumDriver<MobileElement> driver;
	
    public Pn(AppiumDriver<MobileElement> driver) {
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
	

