package com.hackathon.testproject.ui;

import com.hackathon.testproject.model.Period;
import com.hackathon.testproject.model.PriceStatistics;
import com.hackathon.testproject.site.NyseSite;
import com.hackathon.testproject.steps.NyseSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scenario2Test extends BaseUITest{

    private NyseSite nyseSite;

    @BeforeClass
    public void beforeClass() {
        nyseSite = new NyseSite(driver());
    }

    @Test
    public void getHighestEpamClosingPriceTest() {
        driver().navigate().to(NyseSite.URL);
        nyseSite.mainPage.acceptCookies();

        String searchText = "Epam";
        nyseSite.mainPage.search(searchText);
        nyseSite.searchPage.clickFirstSearchResult();

        Period pricePeriod = Period.builder()
                .startDate("2021-09-01")
                .endDate("2021-09-30")
                .build();
        nyseSite.quotePage.setHistoricPricesRange(pricePeriod);

        PriceStatistics priceStatistics = new PriceStatistics();
        priceStatistics.setPeriod(pricePeriod);
        priceStatistics.setStockData(nyseSite.quotePage.getHistoricPrices());

        NyseSteps.sendStockData(priceStatistics);
    }
}
