package tests.ui;

import model.Period;
import model.PriceStatistics;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import site.NyseSite;
import steps.NyseSteps;

public class Scenario2Test extends BaseUITest {

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
