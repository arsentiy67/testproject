package com.hackathon.testproject.pages.nyse;

import com.hackathon.testproject.pages.AbstractPage;
import core.web.iWebElement;
import org.openqa.selenium.support.FindBy;

public class QuotePage extends AbstractPage<QuotePage> {

    @FindBy(xpath = "(//*[@class='react-datepicker__input-container'])[1]/input")
    private iWebElement fromDateInput;

    @FindBy(xpath = "(//*[@class='react-datepicker__input-container'])[2]/input")
    private iWebElement toDateInput;

    @FindBy(xpath = "//button[span[contains(text(),'GO')]]")
    private iWebElement goBtn;

    public void setHistoricPricesRange(String fromDate, String toDate) {
        fromDateInput.setFocus();
        fromDateInput.clear();
        fromDateInput.setText(fromDate);
        toDateInput.clear();
        toDateInput.setText(toDate);
        goBtn.click();
    }
}

