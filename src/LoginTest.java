

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage page;
	private String username = "admin";
	private String password = "admin";


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
		
		page.passwordInput.enter(username);
		page.usernameInput.enter(password);
		pause();
		page.submitBtn.click();

		wait.until(ExpectedConditions.urlContains("manage-events"));
		pause();
	}

  

}
