package com.automation.library;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MyActions {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	public MyActions(WebDriver driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 20);
	}

	// ****************** swipe
	public void A_swipe(AppiumDriver<MobileElement> driver, int xStartpoint, int xEndpoint, int yStartpoint,
			int yEndpoint) {
		Dimension windowSize = driver.manage().window().getSize();
		int screenHeight = windowSize.getHeight();
		int screenWidth = windowSize.getWidth();

		int xStartPoint = xStartpoint * screenWidth / 100;
		int xEndPoint = xEndpoint * screenWidth / 100;

		int yStartPoint = yStartpoint * screenHeight / 100;
		int yEndPoint = yEndpoint * screenHeight / 100;

		PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
		PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1))).moveTo(endPoint)
				.release().perform();
		Log.info("Swipe Screen");
	}

	// ***************** Scroll
	public void A_ScrollToText(String text) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
						+ text + "\").instance(0))"))
				.click();
		;
		Log.info("Scroll to Text \""+text+"\"");
	}

	// ***************** wait
	public WebElement A_WaitVisiable(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement A_WaitClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// ***************** Click
	public void A_Click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Log.info("Click on: " + element);
	}
	
	public void A_Click(WebElement element, String elementName) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Log.info("Click on: " + elementName);
	}

	// ***************** Sendkey
	public void A_Senkey(WebElement element, String key) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);
		Log.info("Sendkey value: \"" + key + "\" into element: " + element);
	}
	
	public void A_Senkey(WebElement element, String elementName, String key) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);
		Log.info("Sendkey value: \"" + key + "\" into element: " + elementName);
	}

	// ***************** Random

	public void A_ClickRandom(List<MobileElement> ListElement) {
		ListElement.get(new Random().nextInt(ListElement.size())).click();
		Log.info("Click Random " + ListElement);
	}
	
	public void A_ClickRandom(List<MobileElement> ListElement, String NameElement) {
		ListElement.get(new Random().nextInt(ListElement.size())).click();
		Log.info("Click Random " + NameElement);
	}

	public int A_index_Random(List<MobileElement> ListElement) {
		return new Random().nextInt(ListElement.size());
	}

	// ***************** DropdownList


	// ***************** Sleep
	public void A_Sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
			Log.info("Sleep "+miliseconds+" miliseconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ***************** Allert Pop-up
	public void A_Accept_Allert_Android() {
		A_Click(driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")));
		Log.info("Accept Allert");
	}

	public void A_Accept_Allert_iOS() {
		A_Click(driver.findElement(By.id("Allow")));
	}

	// ***************** Assertion
	public void A_Assert(String string1, String string2) {
		try {
			assertEquals(string1, string2);
			Log.info("[PASS] Assertion 2 String");
		} catch (AssertionError E) {
			Log.error("[FAIL] Assertion 2 String - Because: " + E.getMessage());
			Assert.fail();
		}
	}
	public void A_Assert(String string1, String string2, String AssertName) {
		try {
			assertEquals(string1, string2);
			Log.info("[PASS] - " + AssertName);
		} catch (AssertionError E) {
			Log.error("[FAIL] - " + AssertName +" - Because: "+ E.getMessage());
			Assert.fail();
		}
	}
	public void A_Assert(int int1, int int2) {
		try {
			assertEquals(int1, int2);
			Log.info("[PASS] Assertion 2 int");
		} catch (AssertionError E) {
			Log.error("[FAIL] Assertion 2 int - Because: " + E.getMessage());
			Assert.fail();
		}
	}

	public void A_Assert(int int1, int int2, String AssertName) {
		try {
			assertEquals(int1, int2);
			Log.info("[PASS] - " + AssertName);
		} catch (AssertionError E) {
			Log.error("[FAIL] - " + AssertName +" - Because: "+ E.getMessage());
			Assert.fail();
		}
	}
	public void A_Assert(Boolean boolean1, Boolean boolean2) {
		try {
			assertEquals(boolean1, boolean2);
			Log.info("[PASS] Assertion 2 Boolean");
		} catch (AssertionError E) {
			Log.error("[FAIL] Assertion 2 Boolean - Because: " + E.getMessage());
			Assert.fail();
		}
	}
	
	public void A_Assert(Boolean boolean1, Boolean boolean2,String AssertName) {
		try {
			assertEquals(boolean1, boolean2);
			Log.info("[PASS] - " + AssertName);
		} catch (AssertionError E) {
			Log.error("[FAIL] - " + AssertName +" - Because: "+ E.getMessage());
			Assert.fail();
		}
	}

	public void A_Assert(Boolean boolean1) {
		try {
			assertTrue(boolean1);
			Log.info("[PASS] Assertion True");
		} catch (AssertionError E) {
			Log.error("[FAIL] Assertion True ");
			Assert.fail();
		}
	}
	
	public void A_Assert(Boolean boolean1,String AssertName) {
		try {
			assertTrue(boolean1);
			Log.info("[PASS] - " + AssertName);
		} catch (AssertionError E) {
			Log.error("[FAIL] - " + AssertName +" - Because: "+ E.getMessage());
			Assert.fail();
		}
	}

	public void A_Assert_isDisplayed(WebElement element) {
		try {
			assertTrue(A_WaitVisiable(element).isDisplayed());
		} catch (AssertionError E) {
			Log.error("Element: " + element + "is not Displayed");
		}
	}

	public void A_Assert_isEnabled(WebElement element) {
		try {
			A_Assert(element.isEnabled());
		} catch (AssertionError E) {
			Log.error("Element: " + element + "is not Enabled");
			Assert.fail();
		}
	}

	public void A_Assert_isSelected(WebElement element) {
		try {
			A_Assert(element.isSelected());
		} catch (AssertionError E) {
			Log.error("Element: " + element + "is not Selected");
			Assert.fail();
		}
	}

	// ***************** Sth
	// ***************** Sth
	// ***************** Sth
	// ***************** Sth
	// ***************** Sth
	// ***************** Sth
	// ***************** Sth

}
