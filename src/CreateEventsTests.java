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
    public void testCreateEvent () {

        assert false;
    }
}
