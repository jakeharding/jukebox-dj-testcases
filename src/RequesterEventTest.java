import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
import pages.HomePage;
import pages.RequesterEventPage;

import static org.junit.Assert.assertEquals;

/**
 * RequesterEventTest.java
 * <p>
 * Created by jake
 * Created on 11/23/17
 * <p>
 * <p>
 * Test requester event page.
 */


public class RequesterEventTest extends BaseTest {

    public RequesterEventPage page;

    @BeforeClass
    public static void beforeClass () {
        BaseTest.beforeClass();
        //TODO establish an ID on the server to use for this test.
        // ID must reference a DJ with only one active event.
        // Go to home page and enter the established ID for the test
        driver.get(baseUrl + "#/home");
        HomePage home = new HomePage(driver);
        home.idInput.enter("1234");
        home.submit();
    }

    @Before
    public void setUp () {
        page = new RequesterEventPage(driver);
        wait.until(page.isClickable());
    }


    @Test(expected = StaleElementReferenceException.class)
    public void testSelectSongForRequest() throws Exception {
        String songText = page.songBtn.getText();
        pause();
        page.requestSong();
        wait.until(page.hasRequestNotification());
        pause();

        // Song request should be in the request list.
        page.viewSongRequests();
        pause();

        String reqListEntryText = page.reqListEntry.getText();
        assertEquals("Text should match", songText, reqListEntryText);

        page.viewAvailableSongs();
        // Reference to the existing songBtn should now throw the expected exception because it has been removed from the DOM.
        page.songBtn.getText();

    }

    @Test
    public void testSearchInput () throws Exception {
        Integer numSongs = page.getNumOfAvailableSongsLoaded();
        page.searchInput.enter("Beastie");
        pause();
        wait.until(page.resultAreLoaded(numSongs));
        page.clearSearchInput();
    }
}
