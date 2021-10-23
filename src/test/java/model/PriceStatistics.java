package model;

import lombok.Getter;
import lombok.Setter;
import model.Period;

import java.util.List;

@Getter
@Setter
public class PriceStatistics {
    private Period period;
    private List<HistoricPrice> stockData;
    private String highestClosingPrice;
}
