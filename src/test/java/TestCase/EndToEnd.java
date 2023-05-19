package TestCase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.library.MyActions;
import com.automation.pages.P0_Menu;
import com.automation.pages.P1_Login;
import com.automation.pages.P2_Register;
import com.automation.pages.P3_Home;
import com.automation.pages.P4_ProductDetail;
import com.automation.pages.P5_Cart;

public class EndToEnd extends DriverInstance {


	String email = "abc@gmail.com";
	String name = "abc";
	String phone = "0123456789";
	String password = "Matkhau";
	int random_product_index;
	String ProductName;
	int ProductPrice;
	
	
	@Test
	public void EndToEndTC() throws InterruptedException {
    	MyActions MyActions = new MyActions(driver);
    	P0_Menu P0_Menu = new P0_Menu(driver);
    	P1_Login P1_Login = new P1_Login(driver);
    	P2_Register P2_Register = new P2_Register(driver);
    	P3_Home P3_Home = new P3_Home(driver);
    	P4_ProductDetail P4_ProductDetail = new P4_ProductDetail(driver);
    	P5_Cart P5_Cart = new P5_Cart(driver);
    	
        	
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
	    
	    MyActions.A_swipe(driver, 50, 50, 80, 30);
	    
	    random_product_index = P3_Home.random_index_Product();
	    
		ProductName = P3_Home.getproductName(random_product_index);
		ProductPrice = P3_Home.getproductPrice(random_product_index);
	    
	    P3_Home.click_product(random_product_index);
	    
	    // Màn hình xem chi tiết
	    
	    P4_ProductDetail.assert_isdisplay();
	    
	    MyActions.A_swipe(driver, 50, 50, 70, 40);
	    
	    assertEquals(ProductName, P4_ProductDetail.getproductName());
	    
	    assertEquals(ProductPrice,  P4_ProductDetail.getproductPrice());
	    
	    P4_ProductDetail.click_addToCartBtn();
	    
	    assertEquals(P0_Menu.getProductNumber(), 1);
	    
	    // Màn hình Cart 
	    
	    P0_Menu.click_cartIcon();
	    
	    assertEquals(ProductName, P5_Cart.getproductName1());
	    
	    assertEquals(ProductPrice,  P5_Cart.getproductPrice1());
	    
	    Thread.sleep(2000);
	    
	    
	}
}
