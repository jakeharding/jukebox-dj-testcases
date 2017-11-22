

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage page;
	private String validUsername = "admin";
	private String validPassword = "admin";

	private String invalidUsername = "NoGoodUsername";
	private String invalidPassword = "BadPassword";



	@Before
	public void setUp() throws Exception {
	  
		super.setUp();
    
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

		wait.until(ExpectedConditions.urlContains("manage-events"));
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

}
