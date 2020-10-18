package com.app.weatherreportcomparator.domain;

import lombok.Data;

@Data
public class Weather {
    private String condition;
    private String city;
    private String wind;
    private String humidity;
    private String temperatureInFahrenheit;
    private String temperatureInDegree;

      /*Condition : Humid and Overcast
      Wind: 2.31 KPH Gusting to 3.4 KPH
      Humidity: 84%
      Temp in Degrees: 26
      Temp in Fahrenheit: 79*/
}
