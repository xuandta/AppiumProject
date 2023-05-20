package com.automation.library;


import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MyActions {
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	public MyActions(WebDriver driver) {
		this.driver = (AppiumDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	// ************************ swipe
	public void A_swipe(AppiumDriver<MobileElement> driver,int xStartpoint, int xEndpoint, int yStartpoint,int yEndpoint) {
		Dimension windowSize = driver.manage().window().getSize();
		int screenHeight = windowSize.getHeight();
		int screenWidth = windowSize.getWidth();
		
		int xStartPoint = xStartpoint*screenWidth/100;
		int xEndPoint = xEndpoint*screenWidth/100;
		
		int yStartPoint = yStartpoint*screenHeight/100;
		int yEndPoint = yEndpoint*screenHeight/100;
		
		
		PointOption startPoint = new PointOption().withCoordinates(xStartPoint,yStartPoint);
		PointOption endPoint = new PointOption().withCoordinates(xEndPoint,yEndPoint);
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction
			.press(startPoint)
			.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
			.moveTo(endPoint)
			.release()
			.perform();
	}
	
	// ************ wait 
	public WebElement A_WaitVisiable(WebElement webElement) {
		return wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public WebElement A_WaitClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// ************ Click
	public void A_Click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	

	
	// ************ Sendkey
	public void A_Senkey(WebElement element, String key) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);
	}
	// ************* Random
	public void A_ClickRandom(List<MobileElement> ListElement) {
		ListElement.get(new Random().nextInt(ListElement.size())).click();
	}
	
	public int A_index_Random(List<MobileElement> ListElement) {
		return new Random().nextInt(ListElement.size());
	}
	
	// ************ DropdownList
	public void SwipeAndSelectFromDropDownListByText() {
//		do
	}
	
	// ************ Sleep
	public void A_Sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// ************ Allert Pop-up
	public void A_Accept_Allert_Android() {
        A_Sleep(500);
        driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
	}
	
	public void A_Accept_Allert_iOS() {
        A_Sleep(500);
        driver.findElement(By.id("Allow")).click();
	}
}
