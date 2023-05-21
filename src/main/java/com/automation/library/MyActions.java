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
	}

	// ***************** Scroll
	public void A_ScrollToText(String text) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
						+ text + "\").instance(0))"))
				.click();
		;
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
//		log.info("Clicked on element: " + element);
	}

	// ***************** Sendkey
	public void A_Senkey(WebElement element, String key) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);
//		log.info("Sendkey value: \"" + key + "\" on element: " + element);
	}

	// ***************** Random

	public void A_ClickRandom(List<MobileElement> ListElement) {
		ListElement.get(new Random().nextInt(ListElement.size())).click();
	}

	public int A_index_Random(List<MobileElement> ListElement) {
		return new Random().nextInt(ListElement.size());
	}

	// ***************** DropdownList


	// ***************** Sleep
	public void A_Sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ***************** Allert Pop-up
	public void A_Accept_Allert_Android() {
		A_Click(driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")));
	}

	public void A_Accept_Allert_iOS() {
		A_Click(driver.findElement(By.id("Allow")));
	}

	// ***************** Assertion
	public void A_Assert(String string1, String string2) {
		try {
			assertEquals(string1, string2);
		} catch (AssertionError E) {
			System.out.println("********** Assertion String Error: " + E.getMessage());
			Assert.fail();
		}
	}

	public void A_Assert(int int1, int int2) {
		try {
			assertEquals(int1, int2);

		} catch (AssertionError E) {
			System.out.println("********** Assertion int Error: " + E.getMessage());
			Assert.fail();
		}
	}

	public void A_Assert(Boolean boolean1, Boolean boolean2) {
		try {
			assertEquals(boolean1, boolean2);
		} catch (AssertionError E) {
			System.out.println("********** Assertion Boolean Error: " + E.getMessage());
			Assert.fail();
		}
	}

	public void A_Assert(Boolean boolean1) {
		try {
			assertTrue(boolean1);
//			log.info("Assert [PASS]");
		} catch (AssertionError E) {
//			log.error("Assert [FAIL]" + E.getMessage());
			Assert.fail();
		}
	}

	public void A_Assert_isDisplayed(WebElement element) {
		try {
			assertTrue(A_WaitVisiable(element).isDisplayed());
//			log.info("Element: " + element + "is Displayed");
		} catch (AssertionError E) {
//			log.error("Element: " + element + "is not Displayed");
		}
	}

	public void A_Assert_isEnabled(WebElement element) {
		try {
			A_Assert(element.isEnabled());
//			log.info("Element: " + element + "is Enabled");
		} catch (AssertionError E) {
//			log.error("Element: " + element + "is not Enabled");
			Assert.fail();
		}
	}

	public void A_Assert_isSelected(WebElement element) {
		try {
			A_Assert(element.isSelected());
//			log.info("Element: " + element + "is Selected");
		} catch (AssertionError E) {
//			log.error("Element: " + element + "is not Selected");
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
