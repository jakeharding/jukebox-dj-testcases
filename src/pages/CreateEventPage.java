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

    public static final String eventNameTid = "event-name";
    public static final String eventIsActiveTid= "event-is-active";

    public CreateEventPage (WebDriver driver) {
        super(driver);
        eventNameInput = new Input(driver, eventNameTid);
        isActiveBtn = getElementByTid(eventIsActiveTid);
    }

    public ExpectedCondition<Boolean> hasRedirectedToDashboard () {
        return ExpectedConditions.urlContains("/manage-events/");
    }
}
