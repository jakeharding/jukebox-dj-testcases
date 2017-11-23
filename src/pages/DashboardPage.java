package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

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

    @FindBy(xpath="//*[@tid='logout']")
    public WebElement logoutLink;

    @FindBy(xpath="//*[tid='events-list']")
    public WebElement events;

    private WebElement createtBtn;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
