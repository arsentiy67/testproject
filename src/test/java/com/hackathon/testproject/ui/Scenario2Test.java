package com.hackathon.testproject.ui;

import com.hackathon.testproject.site.NyseSite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scenario2Test extends BaseUITest{

    private NyseSite nyseSite;

    @BeforeClass
    public void beforeClass() {
        nyseSite = new NyseSite(driver());
    }

    @Test
    public void getHighestEpamClosingPriceTest() { // todo rename the test
        driver().navigate().to(NyseSite.URL);
        nyseSite.mainPage.acceptCookies();

        String searchText = "Epam";
        nyseSite.mainPage.search(searchText);
        // todo assert that search results are present ?
        nyseSite.searchPage.clickFirstSearchResult();

        String fromDate = "2021-09-01";
        String toDate = "2021-09-30";
        nyseSite.quotePage.setHistoricPricesRange(fromDate, toDate);

    }
}
