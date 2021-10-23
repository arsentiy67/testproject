package com.hackathon.testproject.pages.nyse;

import com.hackathon.testproject.model.HistoricPrice;
import com.hackathon.testproject.model.Period;
import com.hackathon.testproject.pages.AbstractPage;
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

    public void setHistoricPricesRange(Period period) {
        fromDateInput.setFocus();
        setDate(fromDateInput, period.getStartDate());
        setDate(toDateInput, period.getEndDate());
        goBtn.click();
    }

    private void setDate(iWebElement dateInput, String date) {
        dateInput.sendKeys(Keys.CONTROL, "a");
        dateInput.sendKeys(Keys.DELETE);
        dateInput.setText(date);
        selectedDayBtn.click();
    }

    public List<HistoricPrice> getHistoricPrices() {
        List<HistoricPrice> historicPrices = new ArrayList<>();
        return historicPrices;
    }
}

