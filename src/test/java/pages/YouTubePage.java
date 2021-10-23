package pages;

import core.web.iWebElement;
import org.openqa.selenium.support.FindBy;
import utils.logging.iLogger;

public class YouTubePage extends AbstractPage{
    @FindBy(id = "search")
    private iWebElement searchBar;

    public YouTubePage() {
        this.init();
    }

    public void searchText(String text) {
        iLogger.info("Search for text {}", text);
        searchBar.setText(text);
        searchBar.enter();
    }
}
