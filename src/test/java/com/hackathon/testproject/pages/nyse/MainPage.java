package com.hackathon.testproject.pages.nyse;

import com.hackathon.testproject.pages.AbstractPage;
import core.web.iElementsList;
import core.web.iWebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage<MainPage> {
    @FindBy(id = "page-search")
    private iWebElement searchInput;

    @FindBy(css = "#search-results a")
    private iElementsList searchDropDownLinks;

    public void search(String searchValue) {
        searchInput.setText(searchValue);
        searchInput.click();
    }

    public void clickFirstSearchDropDownLink() {
        searchDropDownLinks.get(0).click();
    }
}
