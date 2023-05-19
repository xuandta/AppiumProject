package TestCase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.library.MyActions;
import com.automation.pages.P0_Menu;
import com.automation.pages.P1_Login;
import com.automation.pages.P2_Register;

public class RegisterFunction extends DriverInstance{

    @Test
    public void TC03_Register_valid() {
    	

    	P0_Menu P0_Menu = new P0_Menu(driver);
    	P1_Login P1_Login = new P1_Login(driver);
    	P2_Register P2_Register = new P2_Register(driver);
	    
	    P0_Menu.click_userIcon();
	    
	    P1_Login.click_registerBtn();
	    
	    P2_Register.fullfillregisterBtn(driver, "abc@gmail.com", "abc", "0123456789", "Matkhau");
	 
	    P1_Login.assert_isdisplay();
    }
    
    
    @Test
    public void TC04_Register_Invalid(){
    
    	P0_Menu P0_Menu = new P0_Menu(driver);
    	P1_Login P1_Login = new P1_Login(driver);
    	P2_Register P2_Register = new P2_Register(driver);
	    
	    P0_Menu.click_userIcon();
	    
	    P1_Login.click_registerBtn();
	    
	    P2_Register.fullfillregisterBtn(driver, "", "", "", "");
    
	    assertEquals( P2_Register.ErrorMessage_isdisplay(), true);
	   
    }
}
