package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Input;

/**
 * CreateEventPage.java
 * <p>
 * Created by jake
 * Created on 11/22/17
 * <p>
 * <p>
 * Page object for create event page.
 */


public class CreateEventPage extends BaseElement {

    public Input eventNameInput;
    public WebElement isActiveBtn;
    public WebElement submitBtn;
    public WebElement eventNameError;
    public WebElement pageHeading;

    public static final String eventNameTid = "event-name";
    public static final String pageHeadingTid= "page-heading";
    public static final String eventIsActiveTid = "event-is-active";
    public static final String submitBtnTid = "submit-btn";
    public static final String eventNameErrTid = "event-name-error";

    public CreateEventPage (WebDriver driver) {
        super(driver);
        eventNameInput = new Input(driver, eventNameTid);
        isActiveBtn = getElementByTid(eventIsActiveTid);
        submitBtn = getElementByTid(submitBtnTid);
        eventNameError = getElementByTid(eventNameErrTid);
        pageHeading = getElementByTid(pageHeadingTid);
    }

    public ExpectedCondition<Boolean> hasRedirectedToDashboard () {
        return ExpectedConditions.urlContains("/manage-events");
    }

    public ExpectedCondition<WebElement> hasEventNameError () {
        return ExpectedConditions.visibilityOf(eventNameError);
    }

    public ExpectedCondition<WebElement> canBeSubmitted () {
        return ExpectedConditions.elementToBeClickable(submitBtn);
    }

    public void submit () {
        submitBtn.click();
    }
}
