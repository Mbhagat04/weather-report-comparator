package com.app.weatherreportcomparator.domain;

import lombok.Data;

@Data
public class Weather {
    private String condition;
    private String city;
    private String wind;
    private int humidity;
    private int temperatureInFahrenheit;
    private int temperatureInDegree;

}
