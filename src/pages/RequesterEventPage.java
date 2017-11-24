package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Input;

/**
 * RequesterEventPage.java
 * <p>
 * Created by jake
 * Created on 11/23/17
 * <p>
 * <p>
 * Page object for Requester event page.
 */


public class RequesterEventPage extends BaseElement {

    public WebElement reqSongSegBtn;
    public WebElement songReqListSegBtn;
    public Input searchInput;
    public WebElement songBtn;
    public WebElement reqListEntry;
    public WebElement songContainer;

    public static final String reqSongBtnTid = "request-song-btn";
    public static final String songReqListBtnTid = "request-list-btn";
    public static final String searchInputTid = "search-input";
    public static final String songBtnTid = "song-0";
    public static final String reqListEntryTid = "request-0";
    public static final String songConTid = "song-container";

    public RequesterEventPage (WebDriver driver) {
        super(driver);
        searchInput = new Input(driver, searchInputTid);
        songReqListSegBtn = getElementByTid(songReqListBtnTid);
        reqSongSegBtn = getElementByTid(reqSongBtnTid);
        songBtn = getElementByTid(songBtnTid);
        songContainer = getElementByTid(songConTid);
    }

    public Integer getNumOfAvailableSongsLoaded () {
        return songContainer.findElements(By.cssSelector("button")).size();
    }

    public void viewSongRequests () {
        songReqListSegBtn.click();
        reqListEntry = getElementByTid(reqListEntryTid);
    }

    public void viewAvailableSongs () {
        reqSongSegBtn.click();
    }

    public void requestSong() {
        songBtn.click();
    }

    public ExpectedCondition<Boolean> resultAreLoaded (Integer numSongs) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return getNumOfAvailableSongsLoaded() < numSongs;
            }
        };
    }

    public ExpectedCondition<WebElement> hasRequestNotification () {
        return ExpectedConditions.presenceOfElementLocated(By.ByClassName.className("success-toast"));
    }

    public void clearSearchInput () {
        driver.findElement(By.className("searchbar-clear-icon")).click();
    }

}
