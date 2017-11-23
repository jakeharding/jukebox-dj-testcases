package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Input;

/**
 * HomePage.java
 * <p>
 * Created by jake
 * Created on 11/23/17
 * <p>
 * <p>
 * Page object for the home page.
 */


public class HomePage extends BaseElement {

    public Input idInput;
    public WebElement noEventError;
    public WebElement submitBtn;
    public WebElement eventBtn;

    public static final String idInputTid = "id-input";
    public static final String noEventErrorTid = "no-event-error";
    public static final String eventBtnTid = "event-btn-0";
    public static final String submitBtnTid = "submit-btn";

    public HomePage (WebDriver driver) {
        super(driver);
        idInput = new Input(driver, idInputTid);
        noEventError = getElementByTid(noEventErrorTid);
        submitBtn = getElementByTid(submitBtnTid);
    }

    public void submit () {
        submitBtn.click();
    }

    public ExpectedCondition<Boolean> hasRedirectedToRequestEvent () {
        return ExpectedConditions.urlContains("/requester-events/");
    }

    public ExpectedCondition<WebElement> hasEventList () {
        eventBtn = getElementByTid(eventBtnTid);
        return ExpectedConditions.presenceOfElementLocated(getByForTid(eventBtnTid));
    }

}

