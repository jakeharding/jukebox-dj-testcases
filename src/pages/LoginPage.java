package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Input;

public class LoginPage extends BaseElement {
    public Input usernameInput;
    public Input passwordInput;
    public WebElement submitBtn;

    public static String usernameTid = "username-input";
    public static String passwordTid = "password-input";
    public static String submitTid = "submit-btn";
    public static String logoutTid = "logout";
    public static String errorTid = "username-error";

    public LoginPage (WebDriver driver) {
        super(driver);
        usernameInput = new Input(driver, usernameTid);
        passwordInput = new Input(driver, passwordTid);
        submitBtn = getElementByTid(submitTid);
    }

    public void submit () {
        submitBtn.click();
    }

    public ExpectedCondition<WebElement> errorIsPresent () {
        return ExpectedConditions.visibilityOf(driver.findElement(By.className("toast-message")));
    }
}
