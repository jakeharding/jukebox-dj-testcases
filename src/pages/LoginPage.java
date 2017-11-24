package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Input;

/**
 * LoginPage.java
 * <p>
 * Created by jake
 * Created on 11/22/17
 * <p>
 * <p>
 * Login page object for Selenium tests.
 */
public class LoginPage extends BaseElement {
    public Input usernameInput;
    public Input passwordInput;
    public WebElement submitBtn;
    public WebElement usernameError;
    public WebElement logoutLink;

    public final static String usernameTid = "username-input";
    public final static String passwordTid = "password-input";
    public final static String submitTid = "submit-btn";
    public final static String usernameErrorTid = "username-error";
    public final static String logoutLinkTid = "logout";


    public LoginPage (WebDriver driver) {
        super(driver);
        usernameInput = new Input(driver, usernameTid);
        passwordInput = new Input(driver, passwordTid);
        submitBtn = getElementByTid(submitTid);
        usernameError = getElementByTid(usernameErrorTid);
    }

    public void submit () {
        submitBtn.click();
    }

    public ExpectedCondition<WebElement> hasInvalidLoginError() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.className("toast-message")));
    }

    public ExpectedCondition<WebElement> hasUsernameError() {
        return ExpectedConditions.visibilityOf(usernameError);
    }

    public ExpectedCondition<Boolean> hasRedirectedToDashboard () {
        return ExpectedConditions.urlContains("manage-events");
    }

    public ExpectedCondition<WebElement> hasLogoutLink () {
        logoutLink = getElementByTid(logoutLinkTid);
        return ExpectedConditions.visibilityOf(logoutLink);
    }

    public ExpectedCondition<Boolean> isOnHomePage() {
        return ExpectedConditions.urlContains("/home");
    }

    public ExpectedCondition<Boolean> hasRedirectedToLogin () {
        return ExpectedConditions.urlContains("/login");
    }
}
