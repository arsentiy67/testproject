package pages.nyse;

import core.web.iElementsList;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class SearchPage extends AbstractPage<SearchPage> {

    @FindBy(css = ".search-results .search-results-title a")
    private iElementsList searchResults;

    public void clickFirstSearchResult() {
        searchResults.get(0).click();
    }
}
