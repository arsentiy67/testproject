package pages.nyse;

import core.web.iElementsList;
import core.web.iWebElement;
import lombok.SneakyThrows;
import model.HistoricPrice;
import model.Period;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    private static final String DATE_FORMAT_INITIAL = "MM/dd/yyyy";
    private static final String DATE_FORMAT_OUTPUT = "YYYY-MM-DD";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_INITIAL);

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

    @SneakyThrows
    private String convertToDateInAnotherFormat(String date) {
        Date d = SIMPLE_DATE_FORMAT.parse(date);
        SIMPLE_DATE_FORMAT.applyPattern(DATE_FORMAT_OUTPUT);
        return SIMPLE_DATE_FORMAT.format(d);
    }

    private void setDate(iWebElement dateInput, String date) {
        dateInput.sendKeys(Keys.CONTROL, "a");
        dateInput.sendKeys(Keys.DELETE);
        dateInput.setText(date);
        selectedDayBtn.click();
    }
}

