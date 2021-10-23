package com.hackathon.testproject.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Period {
    private String endDate;
    private String startDate;
}
