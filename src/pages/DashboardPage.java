package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * DashboardPage.java
 * <p>
 * Created by jake
 * Created on 11/22/17
 * <p>
 * <p>
 * Dashboard page object for Selenium tests.
 */
public class DashboardPage extends BaseElement {

    public WebElement event;
    public WebElement createBtn;

    public static final String eventTid = "events_0";
    public static final String createBtnTid = "create-btn";

    public DashboardPage(WebDriver driver) {
        super(driver);
        event = getElementByTid(eventTid);
        createBtn = getElementByTid(createBtnTid);
    }

    public ExpectedCondition<Boolean> hasRedirectedToCreatePage () {
        return ExpectedConditions.urlContains("create-event");
    }

    public ExpectedCondition<Boolean> hasRedirectedToEventPage () {
        return ExpectedConditions.urlContains("/events/");
    }

    public ExpectedCondition<WebElement> hasEventsList () {
        return ExpectedConditions.visibilityOf(event);
    }


}
