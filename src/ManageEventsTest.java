import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DashboardPage;
import pages.LoginPage;

/**
 * ManageEventsTest.java
 * <p>
 * Created by jake
 * Created on 11/22/17
 * <p>
 * <p>
 * Test the DJ dashboard.
 */


public class ManageEventsTest extends BaseTest {

    public DashboardPage page;

    @Before
    public void setUp() {
        // Requires login

        driver.get(baseUrl + "#/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.usernameInput.enter("admin");
        loginPage.passwordInput.enter("admin");
        loginPage.submit();

        page = new DashboardPage(driver);
        wait.until(page.hasEventsList());
    }

    @Test
    public void testClickEvent () {
        page.event.click();
        wait.until(page.hasRedirectedToEventPage());
    }

    @Test
    public void testClickCreateEvent () {
        page.createtBtn.click();
        wait.until(page.hasRedirectedToCreatePage());
    }

}
