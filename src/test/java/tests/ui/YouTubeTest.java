package tests.ui;

import org.testng.annotations.Test;
import pages.YouTubePage;
import steps.YoutubeSteps;

public class YouTubeTest extends BaseUITest{

    @Test
    public void test() {
        YoutubeSteps.navigateToSite();
        YoutubeSteps.searchText("EPAM Systems Global");
    }
}
