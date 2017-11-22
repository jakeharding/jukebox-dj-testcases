package pages;

import org.openqa.selenium.*;

public class BaseElement {
	WebDriver driver;
	
	
	public BaseElement (WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElementByTid(String tid) {
		return this.driver.findElement(getByForTid(tid));
	}
	
	public By getByForTid(String tid) {
		return By.cssSelector(String.format("[tid=%s]", tid));
	}
}
