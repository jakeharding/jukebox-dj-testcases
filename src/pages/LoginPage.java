package pages;

import org.openqa.selenium.*;

import utils.Input;

public class LoginPage extends BaseElement {
	public Input usernameInput;
	public Input passwordInput;
	public WebElement submitBtn;
 	public WebElement logoutLink; 
	
	public static String usernameTid = "username-input";
	public static String passwordTid = "password-input";
	public static String submitTid = "submit-btn";
	public static String logoutTid = "logout";
	
	public LoginPage (WebDriver driver) {
		super(driver);
		usernameInput = new Input(driver, usernameTid);
		passwordInput = new Input(driver, passwordTid);
		submitBtn = getElementByTid(submitTid);
	}
	
}
