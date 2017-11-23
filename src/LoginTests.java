/**
 * LoginTests.java
 * <p>
 * Created by jake
 * Created on 11/22/17
 * <p>
 * <p>
 * Test the login page.
 */


import org.junit.*;
import static org.junit.Assert.*;

import pages.LoginPage;

public class LoginTests extends BaseTest {
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

        wait.until(page.isOnLoginPage());
    }

    private void login() {
        page.passwordInput.enter(validPassword);
        page.usernameInput.enter(validUsername);
        page.submit();
    }

}
