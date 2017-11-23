import org.junit.Before;
import org.junit.Test;
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
        login();
        page = new DashboardPage(driver);
        wait.until(page.hasEventsList());
    }

    @Test
    public void testClickEvent () throws Exception {
        page.event.click();
        pause();
        wait.until(page.hasRedirectedToEventPage());
        pause();
    }

    @Test
    public void testClickCreateEvent () throws Exception {
        page.createBtn.click();
        pause();
        wait.until(page.hasRedirectedToCreatePage());
        pause();
    }

}
