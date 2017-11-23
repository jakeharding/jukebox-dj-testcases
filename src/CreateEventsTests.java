import org.junit.Before;
import org.junit.Test;
import pages.CreateEventPage;

/**
 * CreateEventsTests.java
 * <p>
 * Created by jake
 * Created on 11/22/17
 * <p>
 * <p>
 * Test create events.
 */


public class CreateEventsTests extends BaseTest {

    private CreateEventPage page;

    @Before
    public void setUp () {
        login();
        driver.get(baseUrl + "#/create-event");
        page = new CreateEventPage(driver);
    }

    @Test
    public void testCreateEvent () throws Exception {
        page.eventNameInput.enter("A new event to rock");
        page.isActiveBtn.click();
        pause();
        wait.until(page.canBeSubmitted());
        page.submit();
        wait.until(page.hasRedirectedToDashboard());
        pause();
    }

    @Test
    public void testEventNameError () throws Exception {
        page.eventNameInput.enter("An event's name");
        pause();
        page.eventNameInput.clear();
        pause();
        page.pageHeading.click(); //Remove focus from input
        pause();
        wait.until(page.hasEventNameError());
    }
}
