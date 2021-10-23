package pages;

import core.web.iElementsList;
import core.web.iWebElement;
import org.openqa.selenium.support.FindBy;
import utils.logging.iLogger;

import java.util.List;

public class ChannelPage extends AbstractPage{
    @FindBy(xpath = "//*[@id='tabsContainer']//tp-yt-paper-tab[contains(.,'%s')]")
    private iWebElement channelTab;
    @FindBy(css = "a#video-title")
    private iElementsList videoTitles;

    public ChannelPage() {
        super();
    }

    public void clickTab(String tabName) {
        iLogger.info("Open tab {}", tabName);
        channelTab.template(tabName).click();
    }

    public List<String> getVideoTitles() {
        return videoTitles.getTexts();
    }

    public void clickVideoByTitle(String title) {
        iWebElement titleOnPage = videoTitles.stream().filter(s -> s.getAttribute("title").contains(title)).findFirst().get();
        titleOnPage.click();
    }
}
