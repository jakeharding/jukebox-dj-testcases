import org.junit.Before;
import org.junit.Test;
import pages.HomePage;

import static org.junit.Assert.*;

/**
 * HomePageTest.java
 * <p>
 * Created by jake
 * Created on 11/23/17
 * <p>
 * <p>
 * Tests for the home page.
 */


public class HomePageTest extends BaseTest {

    private HomePage page;

    @Before
    public void setUp () {
        driver.get(baseUrl + "#/home");
        page = new HomePage(driver);
    }


    @Test
    public void onlyInput4CharsTest () throws Exception{
        page.idInput.enter("12344433");
        pause();
        assertEquals("Should only input 4 chars", page.idInput.getValue(), "1234");
    }

    @Test
    public void test3CharsAreInvalid () throws Exception {
        page.idInput.enter("123");
        pause();
        assertFalse("Three chars should not be valid", page.submitBtn.isEnabled());
    }

    @Test
    public void testMultipleEventsReturned() throws Exception {
        //TODO Be sure the ID is correct for the environment running the test.
        page.idInput.enter("3456");
        page.submit();
        pause();
        wait.until(page.hasEventList());

        page.eventBtn.click();
        pause();
        wait.until(page.hasRedirectedToRequestEvent());
    }

    @Test
    public void testOneEventReturned () throws Exception {
        //TODO Be sure the ID is correct for the environment running the test.
        page.idInput.enter("1234");
        page.submit();
        pause();
        wait.until(page.hasRedirectedToRequestEvent());
    }
}
