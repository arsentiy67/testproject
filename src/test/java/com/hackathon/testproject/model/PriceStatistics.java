package com.hackathon.testproject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PriceStatistics {
    private Period period;
    private List<HistoricPrice> stockData;
    private Integer highestClosingPrice;
}
