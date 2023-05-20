package com.automation.pages;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.automation.library.MyActions;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class P3_Home extends MyActions {
	AndroidDriver<MobileElement> driver;

	public P3_Home(AndroidDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[2][text(),\"Home\"]")
	private MobileElement HomeTitle;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"categoryBadge\"])[1]")
	private MobileElement Tag_All;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"categoryBadge\"])[2]")
	private MobileElement Tag_Vitamin;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"categoryBadge\"])[3]")
	private MobileElement Tag_Book;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"categoryBadge\"]")
	private List<MobileElement> Tag;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"productName\"])")
	private List<MobileElement> productName;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"productPrice\"])")
	private List<MobileElement> productPrice;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"addToCartBtn\"])")
	private List<MobileElement> addToCartBtn;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"productItem\"])")
	private List<MobileElement> productItem;

	@AndroidFindBy(accessibility = "searchInput")
	private MobileElement searchInput;

	@AndroidFindBy(accessibility = "closeSearchIcon")
	private MobileElement closeSearchIcon;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"productName\"])")
	private List<MobileElement> search_productName;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"productDesc\"])")
	private List<MobileElement> search_productDesc;

	public void assert_isdisplay() {
		A_Assert(A_WaitVisiable(HomeTitle).isDisplayed(), true);
	}

	public void fullfillSearch(String keyword) {
		A_Senkey(searchInput, keyword);
		searchInput.sendKeys(Keys.ENTER);
	}

	public void click_Tag_All() {
		A_Click(Tag_All);
	}

	public void click_Tag_Vitamin() {
		A_Click(Tag_Vitamin);
	}

	public void click_Tag_Book() {
		A_Click(Tag_Book);
	}

	public void click_Tag_random() {
		A_ClickRandom(Tag);
	}

	public int random_index_Product() {
		return A_index_Random(productItem);
	}

	public void click_productName(int index) {
		A_Click(productName.get(index));
	}

	public void click_product(int index) {
		A_Click(productItem.get(index));
	}

	public void click_addToCartBtn(int index) {
		A_Click(addToCartBtn.get(index));
	}

	public void click_searchInput() {
		searchInput.click();
	}

	public void click_closeSearchIcon() {
		closeSearchIcon.click();
	}

	public void click_search_productName_random() {
		search_productName.get(new Random().nextInt(search_productName.size())).click();
	}

	public String getproductName(int index) {
		return productName.get(index).getText();
	}

	public int getproductPrice(int index) {
		return Integer.parseInt(productPrice.get(index).getText().replaceAll("[\\$ ]", ""));
	}
}
