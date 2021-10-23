package pages;

import core.web.iElementsList;
import core.web.iWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.logging.iLogger;

import java.util.ArrayList;
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
        refresh();
    }

    public List<String> getVideoTitles() {
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            titles.add(videoTitles.get(i).getAttribute("title"));
        }
        return titles;
    }

    public void clickVideoByTitle(String title) {
        iLogger.info("Click video with title {}", title);
        WebElement titleOnPage = videoTitles.stream().filter(s -> s.getAttribute("title").contains(title)).findFirst().get();
        titleOnPage.click();
    }
}
