package tests.ui;

import org.testng.annotations.Test;
import steps.ChannelSteps;
import steps.VideoServiceSteps;
import steps.YoutubeSteps;
import utils.FibonacciPrimeRandomGenerator;
import utils.logging.iLogger;

import java.util.List;

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
        ChannelSteps.openVideoByTitle(videoTitles.get(videoNumber % videoTitles.size() - 1));
        ChannelSteps.screenshot();
        //part 2 with API call
        String videoName = VideoServiceSteps.getVideoName();
        VideoServiceSteps.selectVideoByTitle(videoName);
        YoutubeSteps.clickMatchingVideo(videoName);
        iLogger.takeScreenshot();
    }

    @Test
    public void test1() {
        String videoName = VideoServiceSteps.getVideoName();
        VideoServiceSteps.selectVideoByTitle(videoName);
        YoutubeSteps.clickMatchingVideo(videoName);
        iLogger.takeScreenshot();
    }
}
