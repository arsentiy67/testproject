package tests.ui;

import org.testng.annotations.Test;
import steps.ChannelSteps;
import steps.YoutubeSteps;
import utils.FibonacciPrimeRandomGenerator;

import static steps.VideoServiceSteps.getVideoName;
import static steps.VideoServiceSteps.selectVideoByTitle;
import static steps.YoutubeSteps.clickMatchingVideo;

public class YouTubeTest extends BaseUITest {

    @Test
    public void test() {
        String channelName = "EPAM Systems Global";
        List<String> videoTitles;
        int videoNumber = FibonacciPrimeRandomGenerator.generate();
        YoutubeSteps.navigateToSite();
        YoutubeSteps.searchText(channelName);
        YoutubeSteps.navigateToChannelFromSearch(channelName);
        ChannelSteps.openVideosTab();
        videoTitles = ChannelSteps.getVideoTitles();
        ChannelSteps.openVideoByTitle(videoTitles.get(videoNumber - 1));
    }

    @Test
    public void test1() {
        String videoName = getVideoName();
        selectVideoByTitle(videoName);
        clickMatchingVideo(videoName);
    }
}
