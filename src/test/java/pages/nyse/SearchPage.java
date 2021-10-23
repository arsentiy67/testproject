package com.hackathon.testproject.pages.nyse;

import com.hackathon.testproject.pages.AbstractPage;
import core.web.iElementsList;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage<SearchPage> {

    @FindBy(css = ".search-results .search-results-title a")
    private iElementsList searchResults;

    public void clickFirstSearchResult() {
        searchResults.get(0).click();
    }
}
