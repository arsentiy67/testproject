package pages;

import core.DriverFactory;
import core.web.iWebElement;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.logging.iLogger;

import java.util.List;

public class YouTubePage extends AbstractPage {
    @FindBy(xpath = "//input[@id='search']")
    private iWebElement searchBar;
    @FindBy(xpath = "//ytd-channel-renderer//yt-formatted-string[@id='text' and text()='%s']")
    private iWebElement searchChannelName;
    //@FindBy(css = "a#video-title")
    @FindBy(xpath = "//yt-formatted-string[@aria-label]")
    private List<iWebElement> videoTitles;

    public YouTubePage(String pageUrl) {
        super(pageUrl);
    }

    public void searchText(String text) {
        iLogger.info("Search for text {}", text);
        searchBar.setText(text);
        searchBar.enter();
    }

    public void waitForChannelIsViewedInSearch(String channelName) {
        iLogger.info("wait for channel {} to be visible", channelName);
        waitForVisibilityOfElement(searchChannelName.template(channelName));
    }

    public void navigateToChannelFromSearch(String channelName) {
        searchChannelName.template(channelName).click();
    }

    public void clickMatchingVideo(String title) {
        iWebElement titleOnPage = videoTitles
                .stream()
                .filter(s -> s.getAttribute("aria-label").contains(title))
                .findFirst()
                .orElseThrow();
        titleOnPage.click();
    }
}

