package steps;

import pages.YouTubePage;
import utils.logging.iLogger;

public class YoutubeSteps {
    private static YouTubePage page;


    public static void navigateToSite() {
        page = new YouTubePage();
        page.navigate();
    }

    public static void searchText(String searchText) {
        page.searchText(searchText);
    }
}
