package com.automation.pages;

import static org.testng.Assert.assertEquals;

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

public class P4_ProductDetail extends MyActions {
	AppiumDriver<MobileElement> driver;
	
    public P4_ProductDetail(AppiumDriver driver) {
    	super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	 
    @AndroidFindBy (xpath  = "//android.view.ViewGroup[2]//android.view.ViewGroup[1]//android.view.ViewGroup[1]/android.view.View")
    private MobileElement Title_Product_Detail ;
    
    @AndroidFindBy (accessibility  = "productName")
	public MobileElement productBrand ;
  
    @AndroidFindBy (xpath  = "//android.widget.TextView[@content-desc=\"productBrand\"]")
    public MobileElement productName ;
    
    @AndroidFindBy (accessibility  = "productAvailability")
    public MobileElement  productAvailability;
    
    @AndroidFindBy (accessibility  = "productDesc")
    public MobileElement productDesc ;
  
    @AndroidFindBy (accessibility  = "productPrice")
    public MobileElement productPrice ;
    
    @AndroidFindBy (accessibility  = "addToCartBtn")
	private MobileElement addToCartBtn ;
    
    @AndroidFindBy (id  = "text1")
	private MobileElement text1; 
    
    @AndroidFindBy (id  = "text2")
	private MobileElement text2; 

    public void assert_isdisplay() {
    	assertEquals(A_WaitVisiable(Title_Product_Detail).isDisplayed(), true); 
     } 
   
   public void click_addToCartBtn() {
	   A_Click(addToCartBtn);
   }
   
   public String getproductBranch() {
	   return productBrand.getText();
   }
   
   public String getproductName() {
	   return productName.getText();
   }
   
   public String getproductAvailability() {
	   return productAvailability.getText();
   }
   
   public String getproductDesc() {
	   return productDesc.getText();
   }
   
   public int getproductPrice() {
	   return Integer.parseInt((productPrice.getText().replaceAll("[\\$ ]", ""))) ;
   }
  
   
   
    
}
	

