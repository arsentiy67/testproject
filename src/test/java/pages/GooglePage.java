package pages;

import core.web.iWebElement;
import core.web.iElementsList;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends AbstractPage{
    @FindBy(className = "gLFyf gsfi")
    private iWebElement searchInput;
    @FindBy(className = "g")
    private iElementsList searchResults;

    public void searchText(String searchText) {
        searchInput.setText(searchText);
        searchInput.enter();
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }
}
