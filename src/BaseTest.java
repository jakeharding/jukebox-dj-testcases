import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static String baseUrl = "http://localhost:8000/";
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void beforeClass () {
//        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
//        driver = new FirefoxDriver()
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
//        driver.close();
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
}
