package utils;

import org.openqa.selenium.*;

import pages.BaseElement;

public class Input extends BaseElement {
    private WebElement element;
    private String tid;

    public Input (WebDriver driver, String tid) {
        super(driver);
        this.tid = tid;
        // Using ionic inputs so we have to find the child input to interact with.
        this.element = getElementByTid(tid).findElement(By.cssSelector("input"));

    }

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    public void enter(String text) {
        element.clear();
        element.sendKeys(text);
    }

    public boolean isVisible() {
        return element.isDisplayed();
    }
}
