package com.hackathon.testproject.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HistoricPrice {
    private String date;
    private String value;
}
