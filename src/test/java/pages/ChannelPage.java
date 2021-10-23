package pages;

import core.web.iWebElement;
import org.openqa.selenium.support.FindBy;
import utils.logging.iLogger;

public class ChannelPage extends AbstractPage{
    @FindBy(xpath = "//*[@id='tabsContainer']//tp-yt-paper-tab[contains(.,'%s')]")
    private iWebElement channelTab;
    public ChannelPage() {
        super();
    }

    public void clickTab(String tabName) {
        iLogger.info("Open tab {}", tabName);
        channelTab.template(tabName).click();
        channelTab.template(tabName).waitForCssToBe("aria-selected", "true");
    }
}
