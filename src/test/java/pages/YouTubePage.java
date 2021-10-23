package pages;

import core.web.iElementsList;
import core.web.iWebElement;
import org.openqa.selenium.support.FindBy;
import utils.logging.iLogger;

public class YouTubePage extends AbstractPage {
    @FindBy(xpath = "//input[@id='search']")
    private iWebElement searchBar;
    @FindBy(xpath = "//ytd-channel-renderer//yt-formatted-string[@id='text' and text()='%s']")
    private iWebElement searchChannelName;
    @FindBy(css = "a#video-title")
    private iElementsList videoTitles;

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
        iWebElement titleOnPage = videoTitles.stream().filter(s -> s.getAttribute("title").contains(title)).findFirst().get();
        titleOnPage.click();
    }
}

