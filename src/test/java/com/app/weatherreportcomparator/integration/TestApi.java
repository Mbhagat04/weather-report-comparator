package com.app.weatherreportcomparator.integration;

import com.app.weatherreportcomparator.base.BaseTest;
import com.app.weatherreportcomparator.domain.AppMode;
import com.app.weatherreportcomparator.pages.HomePage;
import com.app.weatherreportcomparator.pages.WeatherPage;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestApi extends BaseTest {
    public TestApi() {
        super(AppMode.API);
        initializeApi();
    }

    @Test(groups = "fetchdata", priority = 1)
    public void testOpenApi() {
        Response response = RestAssured.given()
                .then().get(url_celsius);
        ResponseBody response_body = response.getBody();
        apiWeather.setCity(response_body.jsonPath().getString("name"));
        apiWeather.setCondition(response_body.jsonPath().getString("weather[0].main"));
        apiWeather.setTemperatureInDegree(Integer.parseInt(response_body.jsonPath().getString("main.temp").substring(0,1)));
        apiWeather.setHumidity(Integer.parseInt(response_body.jsonPath().getString("main.humidity")));
        apiWeather.setWind(response_body.jsonPath().getString("wind.speed"));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        response = RestAssured.given()
                .then().get(url_fahrenheit);
        apiWeather.setTemperatureInFahrenheit(Integer.parseInt(response.getBody().jsonPath().getString("main.temp").substring(0,1)));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }

}