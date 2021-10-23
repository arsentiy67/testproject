package steps;

import pages.YouTubePage;

public class YoutubeSteps {
    private static YouTubePage page;


    public static void navigateToSite() {
        page = new YouTubePage("https://www.youtube.com/");
        page.navigate();
    }

    public static void searchText(String searchText) {
        page.searchText(searchText);
    }

    public static void navigateToChannelFromSearch(String channelName) {
        page.waitForChannelIsViewedInSearch(channelName);
        page.navigateToChannelFromSearch(channelName);
    }
}
