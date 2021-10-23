package tests.ui;

import org.testng.annotations.Test;
import steps.YoutubeSteps;

import static steps.VideoServiceSteps.getVideoName;
import static steps.VideoServiceSteps.selectVideoByTitle;
import static steps.YoutubeSteps.clickMatchingVideo;

public class YouTubeTest extends BaseUITest {

    @Test
    public void test() {
        String channelName = "EPAM Systems Global";
        YoutubeSteps.navigateToSite();
        YoutubeSteps.searchText(channelName);
        YoutubeSteps.waitForChannelToBePresented(channelName);
    }

//    @Test
//    public void test1() {
//        String videoName = getVideoName();
//        selectVideoByTitle(videoName);
//        clickMatchingVideo(videoName);
//    }
}
