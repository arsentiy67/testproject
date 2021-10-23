package steps;

import pages.ChannelPage;

import java.util.List;

public class ChannelSteps extends BaseSteps{
    private static ChannelPage page;

    public static void openVideosTab() {
        page = new ChannelPage();
        page.clickTab("Videos");
    }

    public static List<String> getVideoTitles() {
        return page.getVideoTitles();
    }

    public static void openVideoByTitle(String videoTitle) {
        page.clickVideoByTitle(videoTitle);
    }
}
