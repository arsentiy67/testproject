package com.hackathon.testproject.pages.nyse;

import com.hackathon.testproject.model.HistoricPrice;
import com.hackathon.testproject.model.Period;
import com.hackathon.testproject.pages.AbstractPage;
import core.web.iElementsList;
import core.web.iWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class QuotePage extends AbstractPage<QuotePage> {

    @FindBy(xpath = "(//*[@class='react-datepicker__input-container'])[1]/input")
    private iWebElement fromDateInput;

    @FindBy(xpath = "(//*[@class='react-datepicker__input-container'])[2]/input")
    private iWebElement toDateInput;

    @FindBy(css = "[class*='day--selected']")
    private iWebElement selectedDayBtn;

    @FindBy(xpath = "//button[span[contains(text(),'GO')]]")
    private iWebElement goBtn;

    @FindBy(css = ".DataTable-nyse .Time .data-table-cell")
    private iElementsList historicPricesDateValues;

    @FindBy(css = ".DataTable-nyse .Close [class*='table-cell-price']")
    private iElementsList historicPricesCloseValues;

    public void setHistoricPricesRange(Period period) {
        fromDateInput.setFocus();
        setDate(fromDateInput, period.getStartDate());
        setDate(toDateInput, period.getEndDate());
        goBtn.click();
    }

    public List<HistoricPrice> getHistoricPrices() {
        List<HistoricPrice> historicPrices = new ArrayList<>();
        for (int rowInd = 0; rowInd < historicPricesDateValues.size(); ++rowInd) {
            historicPrices.add(HistoricPrice.builder()
                    .date(historicPricesDateValues.get(rowInd).getText())
                    .value(historicPricesCloseValues.get(rowInd).getText())
                    .build());
        }
        return historicPrices;
    }

    private void setDate(iWebElement dateInput, String date) {
        dateInput.sendKeys(Keys.CONTROL, "a");
        dateInput.sendKeys(Keys.DELETE);
        dateInput.setText(date);
        selectedDayBtn.click();
    }
}

