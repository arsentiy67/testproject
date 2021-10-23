package tests.ui;

import org.testng.annotations.Test;
import steps.ChannelSteps;
import steps.YoutubeSteps;

public class YouTubeTest extends BaseUITest{

    @Test
    public void test() {
        String channelName = "EPAM Systems Global";
        YoutubeSteps.navigateToSite();
        YoutubeSteps.searchText(channelName);
        YoutubeSteps.navigateToChannelFromSearch(channelName);
        ChannelSteps.openVideosTab();
    }
}
