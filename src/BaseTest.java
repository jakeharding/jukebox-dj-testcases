import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String baseUrl;
    protected static String username;
    protected static String password;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String pathToProperties = "application.properties";


    @BeforeClass
    public static void beforeClass () {
//        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
//        driver = new FirefoxDriver()
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        try {
            File props = new File(pathToProperties);
            Properties p = new Properties();
            FileInputStream propsIn = new FileInputStream(props);
            p.load(propsIn);
            username = p.getProperty("username");
            password = p.getProperty("password");
            baseUrl = p.getProperty("baseUrl");

        } catch (Exception e) {
            fail("No properties file. Must have a properties file to hold username and password for tests.");
        }

        if (username.isEmpty() || password.isEmpty()) {
            fail("Please supply a username and password in application.properties");
        }
    }

    @After
    public void tearDown() throws Exception {
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
        }
    }

    @AfterClass
    public static void afterClass () {
        driver.quit();
    }

    public void pause () throws Exception {
        Thread.sleep(2000);
    }

    protected static void login () {
        driver.get(baseUrl + "#/login");
        LoginPage l = new LoginPage(driver);
        l.usernameInput.enter(username);
        l.passwordInput.enter(password);
        l.submit();
    }
}
