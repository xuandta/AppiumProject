package com.automation.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.library.CaptureScreenshot;
import com.automation.library.MyActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.automation.library.*;

public class P1_Login extends MyActions{
	AppiumDriver<MobileElement> driver;
	
    public P1_Login(AppiumDriver driver) {
    	super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
    @AndroidFindBy (xpath  = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1][text(),\"Login\"]") 
	private MobileElement loginTitle ;
    
    @AndroidFindBy (accessibility  = "emailInput")
	private MobileElement emailInput ;
    
    @AndroidFindBy (accessibility  = "passwordInput")
	private MobileElement passwordInput ;
    
    @AndroidFindBy (accessibility  = "loginBtn")
	private MobileElement loginBtn ;
    
    @AndroidFindBy (xpath  = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2][text(),\"Don't have an account yet?\"]")
	private MobileElement Dont_have_an_account_yet ;
    
    @AndroidFindBy (xpath  = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")
	private MobileElement registerBtn ;
    
    @AndroidFindBy (xpath  = "//android.widget.ScrollView//android.widget.TextView[2][text(),\"Please fill in your credentials\"]")
	private MobileElement Error_msg ;
    
    @AndroidFindBy (accessibility  = "signOutBtn")
	private MobileElement signOutBtn ;
    
    
   public void assert_isdisplay() {
	 assertEquals(A_WaitVisiable(loginTitle).isDisplayed(), true) ;
   } 
   
   public void assert_isLogIn() {
	  assertEquals(A_WaitVisiable(signOutBtn).isDisplayed(), true);
   } 
   
   public void fullfillLogin(String email, String password) {
	   A_Senkey(emailInput, email);
	   A_Senkey(passwordInput, password);
	   A_Click(loginBtn);
   }
   
   public void click_registerBtn() {
	   A_Click(registerBtn);
   }
   
   public boolean ErrorMessage_isdisplay() {
	   return A_WaitVisiable(Error_msg).isDisplayed();
   } 
    
}
	

