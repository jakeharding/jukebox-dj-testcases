

import org.junit.*;
import static org.junit.Assert.*;

import pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage page;
	private String validUsername = "admin";
	private String validPassword = "admin";

	private String invalidUsername = "NoGoodUsername";
	private String invalidPassword = "BadPassword";



	@Before
	public void setUp() throws Exception {
		driver.get(baseUrl + "#/login");
		page = new LoginPage(driver);
	}

	@Test
  	public void testLogin() throws Exception {
		assertTrue(page.usernameInput.isVisible());
		assertTrue(page.passwordInput.isVisible());

		page.passwordInput.enter(validUsername);
		page.usernameInput.enter(validPassword);

		pause();
        page.submit();
		wait.until(page.hasRedirectedToDashboard());
		pause();
	}

	@Test
    public void testInvalidLogin () throws Exception {
        assertTrue(page.usernameInput.isVisible());
        assertTrue(page.passwordInput.isVisible());

        page.passwordInput.enter(invalidPassword);
        page.usernameInput.enter(invalidUsername);
        pause();

        page.submit();
        wait.until(page.errorIsPresent());
        pause();
    }

    @Test
    public void testInvalidUsernameEntered () throws Exception {
	    page.usernameInput.enter("LongUsername");

	    pause();
        page.usernameInput.clear();
	    wait.until(page.usernameErrorIsVisible());
	    pause();
    }

}
