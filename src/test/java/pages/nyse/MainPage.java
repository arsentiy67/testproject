package pages.nyse;

import core.web.iElementsList;
import core.web.iWebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(id = "page-search")
    private iWebElement searchInput;

    @FindBy(css = "#search-results a")
    private iElementsList searchResultsLinks;

    public static void search(String searchValue) {


    }
}
