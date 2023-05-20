package TestCase;

import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.library.MyActions;
import com.automation.pages.P0_Menu;
import com.automation.pages.P1_Login;

public class LoginFunction extends DriverInstance {

	@Test
	public void TC01_Login_valid() {
		P0_Menu P0_Menu = new P0_Menu(driver);
		P1_Login P1_Login = new P1_Login(driver);

		P0_Menu.click_userIcon();

		P1_Login.fullfillLogin("a", "a");

		P1_Login.assert_isLogIn();

	}

	@Test
	public void TC02_Login_invalid() {
		MyActions MyActions = new MyActions(driver);
		P0_Menu P0_Menu = new P0_Menu(driver);
		P1_Login P1_Login = new P1_Login(driver);

		P0_Menu.click_userIcon();

		P1_Login.fullfillLogin("abc", "def");

		MyActions.A_Assert(P1_Login.ErrorMessage_isdisplay(), true);

	}
}
