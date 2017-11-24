import org.junit.*;
import static org.junit.Assert.*;

import pages.LoginPage;

/**
 * LoginTests.java
 * <p>
 * Created by jake
 * Created on 11/22/17
 * <p>
 * <p>
 * Test the login page.
 */
public class LoginTests extends BaseTest {
    private LoginPage page;

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

        page.passwordInput.enter(password);
        page.usernameInput.enter(username);

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
        wait.until(page.hasInvalidLoginError());
        pause();
    }

    @Test
    public void testInvalidUsernameEntered () throws Exception {
        page.usernameInput.enter("LongUsername");
        page.usernameInput.clear();
        page.passwordInput.clear();
        pause();
        wait.until(page.hasUsernameError());
        pause();
    }

    @Test
    public void testLogout () throws Exception {
        login();
        wait.until(page.hasLogoutLink());
        page.logoutLink.click();
        pause();
        wait.until(page.isOnHomePage());
        pause();
    }

    @Test
    public void testRedirectToLogin () {
        driver.get(baseUrl + "#/manage-events");
        wait.until(page.hasRedirectedToLogin());
    }
}
