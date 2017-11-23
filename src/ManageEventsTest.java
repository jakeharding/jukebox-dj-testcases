import org.junit.Before;
import org.junit.Test;
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

    }

    @Test
    public void testPageInit () {
        wait.until(ExpectedConditions.visibilityOf(page.logoutLink));
        wait.until(ExpectedConditions.visibilityOf(page.events));

        assert false;
    }

}
