package steps;

import pages.ChannelPage;

public class ChannelSteps extends BaseSteps{
    private static ChannelPage page;

    public static void openVideosTab() {
        page = new ChannelPage();
        page.clickTab("Videos");
    }
}
