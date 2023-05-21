package TestCase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.library.MyActions;
import com.automation.library.TestListener;
import com.automation.pages.P0_Menu;
import com.automation.pages.P1_Login;
import com.automation.pages.P2_Register;
import com.automation.pages.P3_Home;
import com.automation.pages.P4_ProductDetail;
import com.automation.pages.P5_Cart;
import com.automation.pages.P6_Checkout;

@Listeners(TestListener.class)
public class EndToEnd extends DriverInstance {

	String email = "abc@gmail.com";
	String name = "abc";
	String phone = "0123456789";
	String password = "Matkhau";
	int random_product_index;
	int ProductPrice;
	String ProductName;
	String C_phone = "123";
	String C_Add1 = "100 Khương Đình";
	String C_Add2 = "187 Hạ Đình";
	String C_City = "Hà Nội";
	String C_Zipcode = "100000";
	String C_country = "Aruba";

	@Test
	public void EndToEndTC() {
		MyActions MyActions = new MyActions(driver);
		P0_Menu P0_Menu = new P0_Menu(driver);
		P1_Login P1_Login = new P1_Login(driver);
		P2_Register P2_Register = new P2_Register(driver);
		P3_Home P3_Home = new P3_Home(driver);
		P4_ProductDetail P4_ProductDetail = new P4_ProductDetail(driver);
		P5_Cart P5_Cart = new P5_Cart(driver);
		P6_Checkout P6_Checkout = new P6_Checkout(driver);

		// màn hình đăng ký

		P0_Menu.click_userIcon();

		P1_Login.click_registerBtn();

		P2_Register.fullfillregisterBtn(driver, email, name, phone, password);

		// màn hình log in

		P1_Login.assert_isdisplay();

		P1_Login.fullfillLogin(email, password);

		P1_Login.assert_isLogIn();

		// màn hình home >> Click vào sản phẩm bất kỳ

		P0_Menu.click_homeIcon();

		P3_Home.assert_isdisplay();

		MyActions.A_swipe(driver, 50, 50, 80, 40);

		random_product_index = P3_Home.random_index_Product();

		ProductName = P3_Home.getproductName(random_product_index);
		ProductPrice = P3_Home.getproductPrice(random_product_index);

		P3_Home.click_product(random_product_index);

		// Màn hình xem chi tiết

		P4_ProductDetail.assert_isdisplay();

		MyActions.A_swipe(driver, 50, 50, 70, 30);

		MyActions.A_Assert(ProductName, P4_ProductDetail.getproductName());

		MyActions.A_Assert(ProductPrice, P4_ProductDetail.getproductPrice());

		P4_ProductDetail.click_addToCartBtn();

		assertEquals(P0_Menu.getProductNumber(), 2);

		// Màn hình Cart

		P0_Menu.click_cartIcon();

		MyActions.A_swipe(driver, 50, 50, 70, 50);

		MyActions.A_Assert(ProductName, P5_Cart.getproductName1());

		MyActions.A_Assert(ProductPrice, P5_Cart.getproductPrice1());

		P5_Cart.Click_checkoutBtn();

		// Màn hình Checkout

		MyActions.A_Assert(P6_Checkout.isdisplay(), true);

		P6_Checkout.fullfillregisterBtn(driver, C_phone, C_Add1, C_Add2, C_City, C_Zipcode, C_country); //C_country

		// Màn hình Payment

		P6_Checkout.Payment_isdisplay();

		P6_Checkout.Click_Cash_on_Delivery();

		MyActions.A_swipe(driver, 50, 50, 70, 50);

		P6_Checkout.Click_confirmBtn();

		// Màn hình confirm

		P6_Checkout.isdisplay_confirmTabHeader();

		MyActions.A_Assert(P6_Checkout.getconfirmShippingAdd1().contains(C_Add1), true);
		MyActions.A_Assert(P6_Checkout.getconfirmShippingAdd2().contains(C_Add2), true);
		MyActions.A_Assert(P6_Checkout.getconfirmCity().contains(C_City), true);
		MyActions.A_Assert(P6_Checkout.getconfirmZIPCode().contains(C_Zipcode), true);
		MyActions.A_Assert(P6_Checkout.getconfirmCountry().contains(C_country), true);

		MyActions.A_swipe(driver, 50, 50, 80, 50);

		MyActions.A_Assert(P6_Checkout.getitemName(), ProductName);
		MyActions.A_Assert(P6_Checkout.getitemPrice(), ProductPrice);

		P6_Checkout.Click_placeOrderBtn();

		MyActions.A_Assert(P6_Checkout.isOrdersuccess(), true);
	}
}
